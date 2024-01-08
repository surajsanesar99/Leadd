package com.example.LeadWord.response;

import java.util.List;

public class ErrorResponse {

	private String code;
	private String messages;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String code, String messages) {
		super();
		this.code = code;
		this.messages = messages;
	}


}
