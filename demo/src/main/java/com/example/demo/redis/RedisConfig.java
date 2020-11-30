package com.example.demo.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.io.Serializable;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
/** 开启Session共享功能。使用此注解之后Session调用会自动通过Redis存储和获取。
 * 另外，想要达到Session共享的目的，在其他的系统上只需要做同样的配置即可。
其中maxInactiveIntervalInSeconds参数是设置Session失效时间，使用Redis
Session之后，原Spring Boot的server.session.timeout属性不再生效。*/
public class RedisConfig implements Serializable {

    @Bean("redisTemplate")
    @ConfigurationProperties(prefix="spring.redis")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

    //key RedisSerializer
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
