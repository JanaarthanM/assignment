package com.janaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class HttpUtils {

	public String sendGET(String queryJson) throws IOException {
		System.out.println(queryJson);
		URL obj = new URL("http://localhost:1235/getusers/%7B" + queryJson + "%7D");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		//System.out.println("GET Response Code :: " + responseCode);
		StringBuffer response = null;
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			//System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}
		return response.toString();

	}
}
