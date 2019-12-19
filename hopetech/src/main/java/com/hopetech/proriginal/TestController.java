package com.hopetech.proriginal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hopetech.config.RConfig;
import com.hopetech.config.RedisConfig;

@RestController
public class TestController {
	@Autowired
	private RedisConfig redisConfig;
	@Autowired
	private RConfig r;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String handleRequest() {
		System.out.println(redisConfig.getHost());
		System.out.println(redisConfig.getPort());
		System.out.println(redisConfig.getTimeout());
		System.out.println("===============================");
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println(r.getHost());
		System.out.println(r.getPort());
		System.out.println(r.getTimeout());
		return "Controller is ok!";
	}
}
