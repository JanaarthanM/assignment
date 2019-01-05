package com.janaa;

public class Formquery {

	private String query;
	private String response;

	public Formquery() {

	}

	public Formquery(String query, String response) {
		super();
		this.query = query;
		this.response = response;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
