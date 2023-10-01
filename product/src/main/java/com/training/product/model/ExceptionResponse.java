package com.training.product.model;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
