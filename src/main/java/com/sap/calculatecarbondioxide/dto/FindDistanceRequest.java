package com.sap.calculatecarbondioxide.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class FindDistanceRequest {
	@Builder.Default
	public List<List<Double>> locations = new ArrayList<>();
	@Builder.Default
	private List<String> metrics  = new ArrayList<>();
	private String units;
	
	
	@Getter
	@Setter
	@ToString
	@Builder
	public static class GeoLocation {
		double lattitude;
		double longitude;		
	}
}