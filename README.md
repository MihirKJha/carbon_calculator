#CO2_EMISSION_CALCULATOR

CO2 emission calculator is command line utility that returns the amount of CO2-equivalent that will be caused when traveling between two cities using
a given transportation method.

Technology used
----------------------------------------
Java 8
Maven 
Apache common cli 
Junit
Mockito

Prerequisite
---------------------------------------------------------
presence of ORS_TOKEN as environment variable in system

How to build the project
----------------------------------------
mvn clean package


How to run the project
----------------------------------------
1. Copy calculateCo2-1.jar to from target folder to some other folder and open command window from that folder 

2. Run following command for uasge and help options ->   java -jar calculateCo2-1.jar --help

3. Run command with options in any order  ->   java -jar calculateCo2-1.jar --start  <start location name>     --end  <end location name>     --transportation_method  <transport methods>
      
4. Possible values of transportation_method are -

    Small cars
	small-diesel-car
	small-petrol-car
	small-plugin-hybrid-car
	small-electric-car
	medium-diesel-car
	medium-petrol-car
	medium-plugin-hybrid-car
	medium-electric-car
	large-diesel-car
	large-petrol-car
	large-plugin-hybrid-car
	large-electric-car
	bus
	train 

	
 5. E.g. ==>  java -jar calculateCo2-1.jar --start  Berlin --end  munich --transportation_method  large-diesel-car
	       
		   Your trip caused 165.32kg of CO2-equivalent.
	





Useful information
-----------------------------
1. CO2 amout will shown in KG after rounding to two decimal.
2. On giving invalid transportation_method option, following message will shown in console 
       - Invalid transportation_method , Please give correct transportation_method
3. On giving some random text as start or end option , open route service  API returns zero distance always,so
   CO2 amout will be 0.0kg always.
   


References
-----------------------------
https://openrouteservice.org/
