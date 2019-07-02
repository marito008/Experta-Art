package com.matriz.experta.art.models;

public class BackResponse {
	public enum statusResponse {
		SUCCESS, ERROR
	}

	public static statusResponse status;
	public int statusCode;
	public int w = 0;
	public String message;
	
	public BackResponse(statusResponse status, int statusCode, int w, String message) {
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.w = w;
	}

	
	
}
