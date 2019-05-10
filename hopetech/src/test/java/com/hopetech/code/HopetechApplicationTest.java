package com.hopetech.code;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hopetech.config.RConfig;
import com.hopetech.config.RedisConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class HopetechApplicationTest {
	
	@Autowired
	private RedisConfig redisConfig;
	@Autowired
	private RConfig r;
	
	@Test
	public void contextLoads() {
		System.out.println(redisConfig.getHost());
		System.out.println(redisConfig.getPort());
		System.out.println(redisConfig.getTimeout());
		System.out.println("===============================");
		System.out.println(r.getHost());
		System.out.println(r.getPort());
		System.out.println(r.getTimeout());
	}

}
