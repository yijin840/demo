package org.wys.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.codecs.Codec;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.codec.SerializationCodec;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.wys.demo.spring.context.UserContext;

/**
 * @author wys
 * @date 2021/11/23
 */
@Configuration
@Slf4j
public class BeanInjectConfiguration {


    /**
     * redisson注入到spring中
     * 序列化方式
     * @link https://github.com/redisson/redisson/wiki/4.-Data-serialization
     * @return redisson客户端
     */
    @Bean
    public RedissonClient redisson() {
        Config config = new Config();
        //序列化编码Codec
        config.setCodec(new StringCodec());
        config.useSingleServer().setAddress("redis://118.31.251.1:6379");
        config.useSingleServer().setPassword("123456");
        return Redisson.create(config);
    }

}
