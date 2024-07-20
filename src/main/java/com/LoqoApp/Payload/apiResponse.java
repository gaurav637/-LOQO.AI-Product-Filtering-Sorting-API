package com.LoqoApp.Payload;


// return api response 
public class apiResponse {

	private String message;
	private String result;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public apiResponse(String message, String result) {
		super();
		this.message = message;
		this.result = result;
	}
	
	public apiResponse() {
		
	}
	@Override
	public String toString() {
		return "apiResponse [message=" + message + ", result=" + result + "]";
	}
}
