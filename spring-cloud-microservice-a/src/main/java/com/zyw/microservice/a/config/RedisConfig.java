//package com.zyw.microservice.a.config;
//
//import java.lang.reflect.Method;
//
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Configuration
//@EnableCaching
//public class RedisConfig extends CachingConfigurerSupport {
//
//	@Bean
//	public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName());
//                sb.append(method.getName());
//                for (Object object : params) {
//                    sb.append(object.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }
//	
//	/**
//     * redisTemplate 序列化使用的jdkSerializeable, 存储二进制字节码, 所以自定义序列化类
//     * @param redisConnectionFactory
//     */
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(redisConnectionFactory);
//		
//		// 使用Jackson2JsonRedisSerialize 替换默认序列化
//		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//		
//		// 设置value的序列化规则和 key的序列化规则
//		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//		redisTemplate.setKeySerializer(stringRedisSerializer);
//		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//		redisTemplate.setHashKeySerializer(stringRedisSerializer);
//		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//		redisTemplate.afterPropertiesSet();
//		return redisTemplate;
//	}
//	
//}
