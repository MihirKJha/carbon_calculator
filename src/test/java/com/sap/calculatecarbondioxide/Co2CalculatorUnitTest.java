package com.sap.calculatecarbondioxide;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sap.calculatecarbondioxide.constants.AppConstants;


class Co2CalculatorUnitTest {
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	@DisplayName("Test Co2 calculator with valid input")
	void testCo2WithProperInputs() {
		String[] input = new String[6];
		input[0]="--start";
		input[1]="Berlin";
		input[2]="--end";
		input[3]="munich";
		input[4]="--transportation_method";
		input[5]="large-diesel-car";
		
		new Co2Calculator().main(input);
		
		String output = AppConstants.TRIP + "122.52" + AppConstants.MSG;
	
		Assertions.assertEquals(output, outputStreamCaptor.toString()
			      .trim());
	}
	
	@Test
	@DisplayName("Test Co2 calculator with invalid transport method")
	void testCo2WithInvalidTM() {
		String[] input = new String[6];
		input[0]="--start";
		input[1]="Berlin";
		input[2]="--end";
		input[3]="munich";
		input[4]="--transportation_method";
		input[5]="large-diesel-car123";
		
		new Co2Calculator().main(input);
		
		Assertions.assertEquals(AppConstants.Invalid_TM, outputStreamCaptor.toString()
			      .trim());
	}
	
	@Test
	@DisplayName("Test Co2 calculator with invalid start")
	void testCo2WithInvalidStart() {
		String[] input = new String[6];
		input[0]="--start";
		input[1]="abc";
		input[2]="--end";
		input[3]="munich";
		input[4]="--transportation_method";
		input[5]="large-diesel-car";
		
		new Co2Calculator().main(input);
		
		String output = AppConstants.TRIP + "0.0" + AppConstants.MSG;
		
		Assertions.assertEquals(output, outputStreamCaptor.toString()
			      .trim());
	}
	
	
	@Test
	@DisplayName("Test Co2 calculator with invalid end")
	void testCo2WithInvalidEnd() {
		String[] input = new String[6];
		input[0]="--start";
		input[1]="Berlin";
		input[2]="--end";
		input[3]="abc";
		input[4]="--transportation_method";
		input[5]="large-diesel-car";
		
		new Co2Calculator().main(input);
		
		String output = AppConstants.TRIP + "0.0" + AppConstants.MSG;
		
		Assertions.assertEquals(output, outputStreamCaptor.toString()
			      .trim());
	}
	
	
	@Test
	@DisplayName("Test Co2 calculator with invalid start and end")
	void testCo2WithInvalidstartEnd() {
		String[] input = new String[6];
		input[0]="--start";
		input[1]="abc";
		input[2]="--end";
		input[3]="abc";
		input[4]="--transportation_method";
		input[5]="large-diesel-car";
		
		new Co2Calculator().main(input);
		
		String output = AppConstants.TRIP + "0.0" + AppConstants.MSG;
		
		Assertions.assertEquals(output, outputStreamCaptor.toString()
			      .trim());
	}
	
	@Test
	@DisplayName("Test Co2 calculator with randome order")
	void testCo2WithRandomOrderOfOptions() {
		String[] input = new String[6];
		input[0]="--end";
		input[1]="munich";
		input[2]="--transportation_method";
		input[3]="large-diesel-car";
		input[4]="--start";		
		input[5]="Berlin";
		
		
		new Co2Calculator().main(input);
		
		String output = AppConstants.TRIP + "122.52" + AppConstants.MSG;
		
		Assertions.assertEquals(output, outputStreamCaptor.toString()
			      .trim());
	}
}
