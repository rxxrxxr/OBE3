package com.onezogreen.onezo3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.onezogreen.onezo3")
public class Onezo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Onezo3Application.class, args);
	}

}
