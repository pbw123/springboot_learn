package com.example.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 潘炳稳 on 2019/3/29.
 */
@Service
public class UserService {
    @Resource
//    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void set(String key,Object value)
    {
        RedisSerializer serializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(serializer);
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key,value);
    }
    public Object get(String key)
    {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
       return vo.get(key);
    }
}
