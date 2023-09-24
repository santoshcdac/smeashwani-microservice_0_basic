package com.training.product.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class ServerDetails {
	
	String port;
	String systemname;
	String name;
	
}
