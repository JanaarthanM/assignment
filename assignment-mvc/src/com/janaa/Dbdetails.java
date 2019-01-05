package com.janaa;

import org.springframework.stereotype.Component;

@Component
public class Dbdetails {

	private String file;
	private String host;
	private String port;
	private String database;
	private String collection;
	private String status;

	public Dbdetails() {

	}

	public Dbdetails(String file, String host, String port, String database, String collection, String status) {
		super();
		this.file = file;
		this.host = host;
		this.port = port;
		this.database = database;
		this.collection = collection;
		this.status = status;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
