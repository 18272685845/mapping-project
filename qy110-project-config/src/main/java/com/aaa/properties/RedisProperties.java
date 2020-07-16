package com.aaa.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author 郭航宇
 * @Date 17:04 2020/7/9
 * Description:
 *      redis配置文件
 **/
@Component
@ConfigurationProperties(prefix = "spring.redis")
@PropertySource("classpath:properties/redis.properties")
@Data
public class RedisProperties {
    private String nodes;
    private Integer maxAttmpts;
    private Integer expire;
    private Integer commandTimeout;
}
