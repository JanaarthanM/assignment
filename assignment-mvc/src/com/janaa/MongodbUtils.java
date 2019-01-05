package com.janaa;

import java.io.FileReader;
import java.util.Iterator;

import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;

@Component
public class MongodbUtils {

	@Autowired
	private Dbdetails dbdetails;

	public MongodbUtils() {

	}

	public Dbdetails getDbdetails() {
		return dbdetails;
	}

	public void setDbdetails(Dbdetails dbdetails) {
		this.dbdetails = dbdetails;
	}

	public void importData() throws Exception {
		String filename = dbdetails.getFile();
		filename = filename.replaceAll("\\\\", "/");
		String host = dbdetails.getHost();
		String port = dbdetails.getPort();
		String database = dbdetails.getDatabase();
		String collectionName = dbdetails.getCollection();
		CSVReader csvReader = new CSVReader(new FileReader(filename), ',', Character.MIN_VALUE);
		Iterator<String[]> iterator = csvReader.iterator();
		MongoClientOptions.Builder options = MongoClientOptions.builder();
		options.socketTimeout(0);
		options.heartbeatSocketTimeout(0);
		String dbURL = host + ":" + port;
		MongoClient mongoClient = new MongoClient(dbURL, options.build());
		MongoDatabase dbname = mongoClient.getDatabase(database);
		MongoCollection<Document> collection = dbname.getCollection(collectionName);
		int i = 0;
		String[] header = null;
		while (iterator.hasNext()) {
			if (i == 0)
				header = iterator.next();
			String[] row = iterator.next();
			int col = 0;
			JSONObject json = new JSONObject();
			for (String field : row) {
				json.put(header[col], Integer.parseInt(field));
				col++;
			}
			Document doc = Document.parse(json.toString());
			collection.insertOne(doc);
			i++;
		}
		System.out.println(i + " records are inserted into the collection " + collectionName + ".");
		csvReader.close();
		mongoClient.close();
	}
}
