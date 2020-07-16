package com.aaa.redis;


import com.aaa.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;
import tk.mybatis.mapper.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.aaa.staticproperties.RedisStatic.*;


@Service
public class RedisService<T> {

    private RedisSerializer keySerializer = null;

    /**
     * 初始化redis的key序列化器
     */
    @PostConstruct
    public void initRedisSerializer() {
        if(this.keySerializer == null) {
            this.keySerializer = new JdkSerializationRedisSerializer(this.getClass().getClassLoader());
        }
    }

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 向redis存入数据
     * @param key
     * @param value
     * @param nxxx ：是固定值，有两个值  “nx”：如果redis中的key不存在，则就可以存储，如果已经有这个key，则不存
     *                                    “xx”：如果redis中的key存在，则直接覆盖，如果key不存在，则不存数据
     * @param expx ：是固定值，有两个值   “ex”：失效时间的单位是秒    “px”：失效时间的单位是毫秒
     * @param seconds ：失效时间
     * @return
     */
    public String set(String key,T value,String nxxx,String expx,Integer seconds){
        if (seconds!=null && seconds>0 &&
                (EX.equals(expx) || PX.equals(expx))&&
                (XX.equals(nxxx) || NX.equals(nxxx))){
            //说明在存入数据时候 就必须要上失效时间了
            return jedisCluster.set(key, JSONUtils.toJsonString(value),nxxx,expx,seconds);
        }else {
            //说明不需要设置失效时间
            //但是仍然需要进一步去判断用户所传递的是nx还是xx
            if (NX.equals(nxxx)){
                return String.valueOf(jedisCluster.setnx(key, JSONUtils.toJsonString(value)));
            }else if (XX.equals(nxxx)){
                return jedisCluster.set(key, JSONUtils.toJsonString(value));
            }
        }
        return NO;
    }

    /**
     * 从redis 中查询单个数据
     * @param key
     * @return
     */
    public T getOne(String key){
        return (T) JSONUtils.toObject(jedisCluster.get(key),Object.class);
    }

    /**
     * 从redis中查询数据 （value是字符串）
     * @param key
     * @return
     */
    public String getString(String key){
        return jedisCluster.get(key);
    }

    /**
     * 从redis中查询数据（集合数据）
     * @param key
     * @return
     */
    public List<T> getList(String key){
        return (List<T>) JSONUtils.toList(jedisCluster.get(key),Object.class);
    }

    /**
     * 删除一条redis数据
     * @param key
     * @return
     */
    public Long delOne(Object key){
        //目前来说架构遇到的问题:
        //封装redis的时候发现无法实现通用，因为JedisCluster只能接收String类型key值
        //并不符合架构标准，最终可以把Object对象转换为字节数组来进行处理这个问题
        return jedisCluster.del(rawKey(key));
    }

    /**
     * 批量删除key
     * @param keys
     * @return
     */
    public Long delMany(Collection<T> keys){
        if (CollectionUtils.isEmpty(keys)){
            return 0L;
        }else {
            byte[][] bytes = this.rawkeys(keys);
            return jedisCluster.del(bytes);
        }
    }
    /**
     * 把object对象转换为字节数组
     * @return
     */
    private byte[] rawKey(Object key){
        //Assert:断言 就是来判断用的
        //如果key有值则会去执行下面的代码
        //如果key没有，则直接return
        Assert.notNull(key,"no null key required");

        return this.keySerializer == null && key instanceof byte[] ?
                (byte[]) key : this.keySerializer.serialize(key);
    }


    private byte[][] rawkeys(Collection<T> keys) {
        byte[][] rks = new byte[keys.size()][];
        int i = 0;
        Object key;
        for(Iterator i9 = keys.iterator(); i9.hasNext(); rks[i++] = this.rawKey(key)) {
            key = i9.next();
        }
        return rks;
    }



}
