package com.flypass.airbnb.general.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseObject<T>{

	private T body;
    private HttpStatus code;
	private String message;

	public ResponseObject(T body, HttpStatus code, String message) {
		this.body = body;
		this.code = code;
		this.message = message;
	}
}
