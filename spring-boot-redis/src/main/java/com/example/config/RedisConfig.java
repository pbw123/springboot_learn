package com.example.config;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.config
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/18
// */
//@Configuration
////@EnableCaching//开启缓存
//public class RedisConfig extends CachingConfigurerSupport {
//
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisTemplate) {
////        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        RedisCacheManager cacheManager = RedisCacheManager.create(redisTemplate);
//        return cacheManager;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }
//}
