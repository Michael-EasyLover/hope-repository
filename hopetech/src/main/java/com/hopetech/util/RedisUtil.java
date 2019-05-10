package com.hopetech.util;

import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtil {
	
	private RedisTemplate<String, Object> redisTemplate;  

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {  
        this.redisTemplate = redisTemplate;  
    }  
    
    

}
