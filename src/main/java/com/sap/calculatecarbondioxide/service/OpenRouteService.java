package com.sap.calculatecarbondioxide.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.calculatecarbondioxide.constants.AppConstants;
import com.sap.calculatecarbondioxide.dto.FindDistanceRequest;
import com.sap.calculatecarbondioxide.dto.metrix.FindDistanceResponse;
import com.sap.calculatecarbondioxide.dto.search.SearchResponse;

/**
 * Class responsible to call external oepn route API via HTTP
 * 
 * @author mjha
 *
 */
public class OpenRouteService {
    
	/**
	 * 
	 * @param apiKey
	 * @param text
	 * @param layers
	 * @return
	 */
	public SearchResponse searchCountry(String apiKey,String text, String layers) {
		Client client = ClientBuilder.newClient();
		String url =AppConstants.SEARCH_URL + apiKey + "&text="+text +"&layers=" +layers;
		Response response = client.target(url)
					  .request(MediaType.TEXT_PLAIN_TYPE)
					  .header("Accept", AppConstants.ACCEPT_HEADER_STR)
					  .get();
		SearchResponse searchResponse = response.readEntity(SearchResponse.class);
		
		return searchResponse;
	}
	
	/**
	 * 
	 * @param authorization
	 * @param profile
	 * @param findDistanceRequest
	 * @return
	 */
	public FindDistanceResponse findDistance(String authorization,String profile,FindDistanceRequest findDistanceRequest) {
		Client client = ClientBuilder.newClient();
		ObjectMapper mapper = new ObjectMapper();
		String json = StringUtils.EMPTY;
		
		try {
		   json = mapper.writeValueAsString(findDistanceRequest);
		} catch (JsonProcessingException e) {
		   e.printStackTrace();
		}
		
		Entity<String> payload = Entity.json(json);
	    String url =AppConstants.MATRIX_URL + profile;
		Response response = client.target(url)
					  .request()
					  .header("Authorization", authorization)
					  .header("Accept",  AppConstants.ACCEPT_HEADER_STR)
					  .header("Content-Type",AppConstants.CONTENT_HEADER_STR)
					  .post(payload);
		
		FindDistanceResponse findDistanceResponse = response.readEntity(FindDistanceResponse.class);
		
		return findDistanceResponse;
	}
}