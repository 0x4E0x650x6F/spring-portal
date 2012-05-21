package com.tiago.portal.domains;

import com.tiago.portal.interfaces.IRequest;

public class Request implements IRequest {

	private String property = null;
	private Object value = null;
	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Object getRequestData() {
		
		return null;
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
