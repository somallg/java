package com.somallg.sample.bundle.service.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import com.somallg.sample.bundle.service.Distance;

@Component
@Service
public class DistanceImpl implements Distance {
	
	private static String URL = "http://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver%20BC&destinations=San%20Francisco&sensor=false";

	@Override
	public String getDistance() {
		HttpClient httpClient = new HttpClient();
		HttpMethod getMethod = new GetMethod(URL);
		
		getMethod.addRequestHeader("accept", "application/json");
		
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != 200) {
				throw new RuntimeException("Failed: HTTP error code " + statusCode);
			}
			
			return getMethod.getResponseBodyAsString();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
}
