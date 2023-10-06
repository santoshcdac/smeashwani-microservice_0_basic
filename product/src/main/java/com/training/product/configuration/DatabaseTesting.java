package com.training.product.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConditionalOnProperty("DatabaseTesting")
@Data
public class DatabaseTesting implements Database {
	@Value("${DatabaseTesting.name}")
	private String name;
	
	@Value("${DatabaseTesting.password}")
	private String password;
}