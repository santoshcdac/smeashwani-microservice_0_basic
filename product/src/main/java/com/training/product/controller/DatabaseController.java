package com.training.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.product.configuration.Database;
import com.training.product.model.DatabaseDetails;

@RestController
@RequestMapping("/database")
public class DatabaseController {

	@Autowired
	private Database database;
	
	@GetMapping("/")
	public ResponseEntity<DatabaseDetails> getDetails() {
		DatabaseDetails databaseDetail = DatabaseDetails.builder()
		.name(database.getName())
		.password(database.getPassword())
		.build();
		return ResponseEntity.ok().body(databaseDetail);
	}
}