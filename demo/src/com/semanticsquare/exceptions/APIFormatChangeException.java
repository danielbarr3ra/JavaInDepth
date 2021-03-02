package com.semanticsquare.exceptions;

public class APIFormatChangeException extends Exception {
	private String response;
	private String elementName;

	public APIFormatChangeException(String response, String elementName, String partner) {
		super("Response: " + response + ", Element: code, Partner: " + partner);
		this.response = response;
		this.elementName = elementName;
		this.partner = partner;
	}

	private String partner;

	public APIFormatChangeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public String getResponse() {
		return response;
	}

	public String getElementName() {
		return elementName;
	}

	public String getPartner() {
		return partner;
	}

}
