package com.hopetech.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource("classpath:application.properties")
@Data
public class RConfig {
	
	@Value("${server.servlet.path}")
	private String host;
	
	@Value("${server.port}")
	private int port;
	
	@Value("${server.connection-timeout}")
	private int timeout;

}
