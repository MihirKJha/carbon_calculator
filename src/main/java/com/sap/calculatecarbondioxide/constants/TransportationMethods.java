package com.sap.calculatecarbondioxide.constants;

/**
 * TransportationMethods ENUM
 * 
 * @author mjha
 *
 */
public enum TransportationMethods {	
	SMALL_DIESEL_CAR("142"),
	SMALL_PETROL_CAR("154"),
	SMALL_PLUGIN_HYBRID_CAR("73"),
	SMALL_ELECTRIC_CAR("50"),
	MEDIUM_DIESEL_CAR("171"),
	MEDIUM_PETROL_CAR("192"),
	MEDIUM_PLUGIN_HYBRID_CAR("110"),
	MEDIUM_ELECTRIC_CAR("58") ,
	LARGE_DIESEL_CAR("209"),
	LARGE_PETROL_CAR("282"),
	LARGE_PLUGIN_HYBRID_CAR("126"),
	LARGE_ELECTRIC_CAR("73"),
	BUS("27"),
	TRAIN("6");
	
	public final String label;

    private TransportationMethods(String label) {
        this.label = label;
    }


    public String getLabel() {
        return label;
    }
}
