package com.buster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class BusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusterApplication.class, args);
	}
}
