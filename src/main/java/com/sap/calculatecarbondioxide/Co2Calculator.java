package com.sap.calculatecarbondioxide;

import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import com.sap.calculatecarbondioxide.constants.AppConstants;
import com.sap.calculatecarbondioxide.constants.TransportationMethods;
import com.sap.calculatecarbondioxide.service.CalculateService;

/**
 * Main class
 * 
 * @author mjha
 *
 */
public class Co2Calculator {
	
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Option start = Option.builder(AppConstants.START).required(false).hasArg(true).argName(AppConstants.START).longOpt(AppConstants.START).build();
		Option end = Option.builder(AppConstants.END).required(false).hasArg(true).argName(AppConstants.END).longOpt(AppConstants.END).build();
		Option transportationMethod = Option.builder(AppConstants.TRANSPORTATION_METHOD).required(false).hasArg(true).argName(AppConstants.TRANSPORTATION_METHOD).longOpt(AppConstants.TRANSPORTATION_METHOD).build();
		Option help =Option.builder(AppConstants.HELP).required(false).hasArg(false).argName(AppConstants.HELP).longOpt(AppConstants.HELP).build();

		Options options = new Options();
		options.addOption(start)
		.addOption(end)
		.addOption(transportationMethod)
		.addOption(help);

		CommandLineParser parser = new DefaultParser();
		CommandLine line = null;
		
		try {
			line = parser.parse(options, args);
		} catch (ParseException parseException) {
			 System.out.println(AppConstants.ERROR_PARSING
			         + Arrays.toString(args) + AppConstants.DUE
			         + parseException);
		}

		if (line.hasOption(AppConstants.HELP) || args.length==0) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp(AppConstants.JAR_COMMAND, options, true);
			return;
		}
        
		String output = processCommandArguments(line);
		
		System.out.println(output);
	}
    
	/**
	 * Method to process command line arguments 
	 * 
	 * @param line
	 * @return
	 */
	private static String processCommandArguments(CommandLine line) {
		String startFromCmd = StringUtils.EMPTY ;
		String endFromCmd = StringUtils.EMPTY ;
		String tarnsportFromCmd = StringUtils.EMPTY ;
		
		if (line.hasOption(AppConstants.START)) {
			startFromCmd = line.getOptionValue(AppConstants.START);
		}else {
			return AppConstants.START_REQUIRED;
		}
		
		if (line.hasOption(AppConstants.END)) {
			endFromCmd = line.getOptionValue(AppConstants.END);
		}else {
			return AppConstants.END_REQUIRED;
		}
		
		if (line.hasOption(AppConstants.TRANSPORTATION_METHOD)) {
			tarnsportFromCmd = line.getOptionValue(AppConstants.TRANSPORTATION_METHOD);
		}else {
			return AppConstants.TM_REQUIRED;
		}
		
		String replacedMethod =tarnsportFromCmd.replaceAll("-", "_");
        
		if(!EnumUtils.isValidEnumIgnoreCase(TransportationMethods.class, replacedMethod)) {
			return AppConstants.Invalid_TM;
		}
		CalculateService exchangeRateService = new CalculateService();
		String output = exchangeRateService.calculateCo2(startFromCmd,endFromCmd, replacedMethod);
		return output;
	}
}