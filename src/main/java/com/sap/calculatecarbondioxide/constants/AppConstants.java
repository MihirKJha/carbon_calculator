package com.sap.calculatecarbondioxide.constants;

/**
 * Application cosntants 
 * 
 * @author mjha
 *
 */
public class AppConstants {
	public static final String START = "start";
	public static final String KM = "km";
	public static final String LOCALITY ="locality";
	public static final String END = "end";
	public static final String TRANSPORTATION_METHOD = "transportation_method";
	public static final String HELP = "help";
	public static final String ERROR_PARSING = "ERROR: Unable to parse command-line arguments";
	public static final String JAR_COMMAND = "java -jar calculateCo2-1.jar";
	public static final String START_REQUIRED ="Start is required";
	public static final String END_REQUIRED ="end is required";
	public static final String TM_REQUIRED ="transportation_method is required";
	public static final String DUE =" due to: ";
	public static final String Invalid_TM = "Invalid transportation_method , Please give correct transportation_method";
	public static final String ORS_TOKEN ="ORS_TOKEN";
	public static final String DISTANCE ="distance";
	public static final String DRIVING_CAR ="driving-car";
	public static final String TRIP ="Your trip caused ";
	public static final String MSG ="kg of CO2-equivalent.";
	public static final String ACCEPT_HEADER_STR ="application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8";
	public static final String CONTENT_HEADER_STR ="application/json; charset=utf-8";	
	public static final String SEARCH_URL = "https://api.openrouteservice.org/geocode/search?api_key=";
	public static final String MATRIX_URL = "https://api.openrouteservice.org/v2/matrix/";
}
