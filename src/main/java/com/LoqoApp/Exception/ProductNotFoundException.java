package com.LoqoApp.Exception;

public class ProductNotFoundException extends RuntimeException {

	private String resource;
	
	private String fieldName;
	
	private String fieldValue;

	
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	public ProductNotFoundException() {
		
	}
	
	public ProductNotFoundException(String resource, String fieldName, String fieldValue) {
        super(String.format("%s Not Found with %s : value : %s", resource, fieldName, fieldValue));

		this.resource = resource;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	

}
