package com.training.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.product.configuration.Database;

@RestController
@RequestMapping("/database")
public class DatabaseController {

	@Autowired
	private Database database;
	
	@GetMapping
	public Database getDetails() {
		return database; 
	}
}
