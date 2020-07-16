package com.aaa.config;

import com.aaa.properties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisConfig {
    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisCluster getJedisCluster(){
        //1.通过RedisProperties配置文件获取redis集群节点
        String nodes = redisProperties.getNodes();
        //2.切割nodes
        String[] split = nodes.split(",");
        //3.创建Set集合对象（泛型是HostAndPort）
        Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
        //4.遍历切割后的数组
        for (String hostPort : split) {
            //5.再次切割split数组
            String[] strings = hostPort.split(":");
            //6.创建HostAndPort对象，并且把切切割好的数组放进去  trim()方法是去掉字符串两边的空格
            HostAndPort hostAndPort=new HostAndPort(strings[0].trim(),Integer.parseInt(strings[1].trim()));
            //7.把hostAndPort对象放入Set集合中
            hostAndPorts.add(hostAndPort);
        }
        //9.创建JedisCluster对象
        JedisCluster jedisCluster=new JedisCluster(hostAndPorts ,redisProperties.getCommandTimeout(),redisProperties.getMaxAttmpts());
        //10.返回JedisCluster对象
        return jedisCluster;
    }
}
