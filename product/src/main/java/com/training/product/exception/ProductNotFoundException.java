package com.training.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException  {
	private static final long serialVersionUID = 8805588262375463695L;

	public ProductNotFoundException(String msg) {
		 super(msg);
	}
}
