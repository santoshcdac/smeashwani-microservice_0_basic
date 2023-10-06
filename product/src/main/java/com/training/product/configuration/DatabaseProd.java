package com.training.product.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConditionalOnProperty("DatabaseProd")
@Data
public class DatabaseProd implements Database {
	@Value("${DatabaseProd.name}")
	private String name;
	@Value("${DatabaseProd.password}")
	private String password;
}