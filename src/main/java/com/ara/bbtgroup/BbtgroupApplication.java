package com.ara.bbtgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class BbtgroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbtgroupApplication.class, args);
	}
}
