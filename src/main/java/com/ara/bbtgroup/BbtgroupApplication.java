package com.ara.bbtgroup;

import com.ara.bbtgroup.model.User;
import com.ara.bbtgroup.rest.UserResource;
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
