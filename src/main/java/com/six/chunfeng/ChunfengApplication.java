package com.six.chunfeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.six.chunfeng.mapper")
public class ChunfengApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChunfengApplication.class, args);
	}

}
