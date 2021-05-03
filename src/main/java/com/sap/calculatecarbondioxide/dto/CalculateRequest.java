package com.sap.calculatecarbondioxide.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CalculateRequest {
	private String start;
	private String end;
	private String transportationMethod;
}