package com.hopetech.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Configuration
@PropertySource("classpath:redis.properties")
@ConfigurationProperties(prefix = "spring.redis")
//@ConfigurationProperties(prefix = "spring.redis", ignoreUnknownFields = false)
@Data
public class RedisConfig {

	private String host;
	
	private Integer port;
	 
	private String password;
	 
//	@Value("${jedis.pool.max-idle}")
//	private Integer maxIdle;
	 
	private int timeout;
	 
//	@Value("${redis.max-active}")
//	private Integer maxActive;

	public static void main(String[] args) {
		RedisConfig redisConfig = new RedisConfig();
		System.out.println(redisConfig.getHost());
		System.out.println(redisConfig.getPort());
		System.out.println(redisConfig.getTimeout());
	}
}
