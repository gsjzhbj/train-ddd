package com.yonyou.train.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class OrderServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OrderServerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OrderServerApplication.class);
	}

}
