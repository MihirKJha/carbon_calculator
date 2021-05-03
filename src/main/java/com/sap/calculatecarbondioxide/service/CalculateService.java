package com.sap.calculatecarbondioxide.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sap.calculatecarbondioxide.constants.AppConstants;
import com.sap.calculatecarbondioxide.constants.TransportationMethods;
import com.sap.calculatecarbondioxide.dto.FindDistanceRequest;
import com.sap.calculatecarbondioxide.dto.metrix.FindDistanceResponse;
import com.sap.calculatecarbondioxide.dto.search.SearchResponse;

import lombok.extern.log4j.Log4j;

/**
 * Class responsible to execute logic for distance calculation
 * between two place using co-ordinates
 * 
 * @author mjha
 *
 */
@Log4j
public class CalculateService {

	/**
	 * Method to calculate CO2 consumption based on inputs
	 * 
	 * @param start
	 * @param end
	 * @param transportationMethod
	 * @return
	 */
	public String calculateCo2(String start,String end,String transportationMethod) {
    	String orsToken=System.getenv(AppConstants.ORS_TOKEN);
    	
    	OpenRouteService openRouteService = new OpenRouteService();
    	List<List<Double>> locations = new ArrayList<>();
    	List<Double> startCoordinates = getLocationCoordinates(start,orsToken,openRouteService);
    	List<Double> endCoordinates = getLocationCoordinates(end,orsToken,openRouteService);    	
    	locations.add(startCoordinates);
    	locations.add(endCoordinates);
    	
    	List<String> metrixList = new ArrayList<String>();
    	metrixList.add(AppConstants.DISTANCE);
    	
    	FindDistanceRequest request = FindDistanceRequest.builder()
    			.locations(locations)
    			.metrics(metrixList)
    			.units(AppConstants.KM)
    			.build();  	
       	FindDistanceResponse distanceResponse =openRouteService.findDistance(orsToken,AppConstants.DRIVING_CAR,request);
    	
    	List<Double>  dis = distanceResponse.getDistances().get(0);
    	double x = dis.get(0);
    	double y = dis.get(1);
    	
    	double distanceBetweenPlaces;
    	
    	if(x!=0) {
    		distanceBetweenPlaces=x;
    	}else {
    		distanceBetweenPlaces=y;
    	}
    	
    	TransportationMethods methods= TransportationMethods.valueOf(transportationMethod.toUpperCase());
    	
    	double co2Consumed=(Integer.parseInt(methods.getLabel())*distanceBetweenPlaces)/1000;
    	
    	double roundOff = Math.round(co2Consumed * 100.00) / 100.00;
    	
    	return AppConstants.TRIP + roundOff + AppConstants.MSG;
	}
    
    /**
     * Method to get location co-ordinates
     * 
     * @param locationName
     * @param orsToken
     * @return
     */
    private List<Double> getLocationCoordinates(String locationName,String orsToken,OpenRouteService openRouteService) {
    	SearchResponse locationDetails =openRouteService.searchCountry(orsToken, locationName,AppConstants.LOCALITY);
    		
		if(locationDetails.getFeatures().size()==0) {
			 return Collections.emptyList(); 
		}		    	
    	
    	log.info("Number of co-ordinates fetched "+locationDetails.getFeatures().size() +" for location "+ locationName);
    	
    	return locationDetails
	    			.getFeatures()
	    			.get(0)
	    			.getGeometry()
	    			.getCoordinates();       
    }
}