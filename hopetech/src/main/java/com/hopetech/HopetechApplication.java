package com.hopetech;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class HopetechApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopetechApplication.class, args);
	}
}
