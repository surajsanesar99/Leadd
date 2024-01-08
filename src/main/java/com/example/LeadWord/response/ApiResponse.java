package com.example.LeadWord.response;

public class ApiResponse {

	public ApiResponse(String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	private String status;
	private Object data;
	public ApiResponse(String status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Object getStatus() {
		// TODO Auto-generated method stub
		return status;
	}
	public Object getData() {
		// TODO Auto-generated method stub
		return data;
	}

	
}
