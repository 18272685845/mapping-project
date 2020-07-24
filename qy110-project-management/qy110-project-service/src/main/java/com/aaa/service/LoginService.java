package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.UserMapper;
import com.aaa.model.User;
import com.aaa.redis.RedisService;
import com.aaa.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.aaa.status.RedisFlag.*;
/**
 * @Author 郭航宇
 * @Date 15:55 2020/7/17
 * Description:
 **/

@Service
public class LoginService extends BaseService<User> {



    /**
     * 登陆操作
     * pojo：实体类
     *    povo:封装类型(当在实际开发中，会有很多种情况导致多表联查的时候无法装载数据--->我就根据返回前端的数据自己
     *    去封装一个对象出来---->view object)
     * @param user
     * @return
     */
    public TokenVo doLogin(User user ,RedisService redisService){
        TokenVo tokenVo=new TokenVo();
        User user1=new User();
        //判断user是否为null
        if (user !=null){
            user1.setUsername(user.getUsername());
            User user2 = super.selectOne(user1);
            //判断用户名是否为null
            if (user2 == null){
                 tokenVo.setIfSuccess(false).setType(1);
                 return tokenVo;
            }else{
                //用户名正确，查询密码
                user1.setPassword(user.getPassword());
                User user3 = super.selectOne(user1);
                //判断密码是否正确
                if (user3 == null){
                    //密码错误
                    tokenVo.setIfSuccess(false).setType(2);
                    return tokenVo;
                }else {
                    //密码正确 登陆成功
                    String token = UUID.randomUUID().toString().replaceAll("-","");
                    user3.setToken(token);

                    //获取用户id作为redisKey
                    String redisKey = String.valueOf(user3.getId());
                    System.out.println(redisKey);

                    //将token存入数据库user表中
                    Integer update = super.update(user3);
                    if (update>0){ //token存入数据库成功
                        //先将rediskey和token存入redis中，因为uuid是会变的，需要每次覆盖token，所以使用xx
                        String oneSet = redisService.set(redisKey, token);
                        if (RESULT_REDIS.equals(oneSet.toUpperCase())){

                            //第一次存入成功，再次进行set，使用xx
                            String twoSet = redisService.set(redisKey, token, "xx", "ex", 1800);
                            if (RESULT_REDIS.equals(twoSet.toUpperCase())){
                                //存入成功
                                tokenVo.setIfSuccess(true).setToken(token).setRedisKey(String.valueOf(user3.getId()));
                            }
                        }
                    }else {
                        tokenVo.setIfSuccess(false).setType(4);
                        return tokenVo;
                    }
                }
            }
        }else {
            tokenVo.setIfSuccess(false).setType(4);
            return tokenVo;
        }
        return tokenVo;
    }
}
