package ca.mcgill.ecse681.lts.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import ca.mcgill.ecse681.lts.model.LTS;
import ca.mcgill.ecse681.lts.model.Luggage;
import ca.mcgill.ecse681.lts.model.Passenger;
import ca.mcgill.ecse681.lts.model.Tag;
import ca.mcgill.ecse681.lts.model.Transaction;
import ca.mcgill.ecse681.lts.model.CreditCard;
import ca.mcgill.ecse681.lts.model.Flight;
import ca.mcgill.ecse681.lts.persistence.PersistenceXStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;

public class Controller {
	
	// defining a KieSession variable here that enables use of drools knowledgebase
	private static KieSession kSession;
	
	public Controller(){
	}
	
	/**
	 * Initializes kSession to allow execution of DROOLS rules. Performs all necessary steps. Establishes the "knowledge base"
	 */
	public static void initKnowledgeBase() {
		System.out.println("Executing initialization of knowledge base...");

		if (kSession == null) {
			
			//The code below that establishes the KieSession is a lightly-modified version from stackoverflow. 
			//link: https://stackoverflow.com/questions/24558451/cant-run-hello-world-on-drools-dlr-files-are-not-picked-from-classpath-by-kie
			
			KieServices ks = KieServices.Factory.get();
			KieFileSystem kfs = ks.newKieFileSystem();

		    // for each DRL file, referenced by a plain old path name:
			try {
				FileInputStream fis = new FileInputStream("./src/rules/coupon.drl");
				
				//The .write method "Adds the given Resource to this KieFileSystem in the specified path". The method is 
				//confusing; KieFileSystem requires all drl's to be in the src/main/resources path, so this cannot be changed. 
				//It's necessary for the knowledge base to be established properly
			    kfs.write("src/main/resources/coupon.drl", ks.getResources().newInputStreamResource( fis ) );

			    KieBuilder kieBuilder = ks.newKieBuilder( kfs ).buildAll();
			    Results results = kieBuilder.getResults();
			    
			    if( results.hasMessages( Message.Level.ERROR ) ){
			        System.out.println( results.getMessages() );
			        throw new IllegalStateException( "### errors ###" );
			    }

			    KieContainer kContainer = ks.newKieContainer( ks.getRepository().getDefaultReleaseId() );

			    //KieBase kieBase = kContainer.getKieBase();
			    kSession = kContainer.newKieSession();
				
			} catch (FileNotFoundException e) {
				System.out.println("Error reading coupon.drl: " + e);
				
			}

		}
	}
	
	/**
	 * Runs all coupon-related DROOLS rules, and shows coupons to user
	 * Method can be refined at later date to actually accommodate committing this data back to the database somehow
	 * 
	 * @param passportID : the passport ID of the passenger
	 */
	public static void executeCouponRules(String passportID) {
		Passenger mPassenger = getPassenger(passportID);
		
		if (kSession != null) {
			System.out.println("Inserting passenger and firing all rules");
			kSession.insert(mPassenger);
			kSession.fireAllRules();	//since all rules are coupon-related, this needs to be changed when it's no longer the case
		}
		
	}
	
	public static int populatePassengerDetails(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			
			if(passenger.getPassportID().equals(passportID)) {
				return 1;
			}
		}
		return 0;
	}
	
	public static String getPassengerFirstName(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				return passenger.getFirstName();
			}
		}
		return "";
	}
	
	
	
	public static String getPassengerLastName(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				return passenger.getLastName();
			}
		}
		return "";
	}
	
	public static String getPassengerWeightLimit(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				return String.valueOf(passenger.getLuggageWeightLimit());
			}
		}
		return "";
	}
	
	public static String getPassengerOverweightPrivilege(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				if(passenger.getOverweightLuggagePrivilege()==true) {
					return "Yes";
				}
				return "No"; 
			}
		}
		return "";
	}

	public static String getPassengerLoungeAccess(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				if(passenger.getLoungeAccess()==true) {
					return "Yes";
				}
				return "No"; 
			}
		}
		return "";
	}
	
	public static String getPassengerValidPassport(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				if(passenger.getExpiredPassport()==true) {
					return "Yes";
				}
				return "No"; 
			}
		}
		return "";
	}

	public static Passenger getPassenger(String passportID){
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				return passenger;
			}
		}
		return null;
	}
	
	public static String getFlightSource(String passportID) {
		Passenger passenger  = getPassenger(passportID);
				
		for (Flight flight  : passenger.getFlights()) {
			//assuming one flight per day
			if(checkDate(flight)) {
				return String.valueOf(flight.getSource());
			}
		}
		return "";
	}

	private static boolean checkDate(Flight flight) {
		return (flight.getFlightdate().getDate() == ( Calendar.getInstance().getTime().getDate()))
				&& (flight.getFlightdate().getDay() == ( Calendar.getInstance().getTime().getDay())) 
				&& (flight.getFlightdate().getYear() == ( Calendar.getInstance().getTime().getYear()));
	}

	public static String getFlightDestination(String passportID) {
		Passenger passenger  = getPassenger(passportID);
		
		for (Flight flight  : passenger.getFlights()) {
			//assuming one flight per day
			if(checkDate(flight)) {
				return String.valueOf(flight.getDestination());
			}
		}
		return "";
	}

	public static String getFlightNumber(String passportID) {
		Passenger passenger  = getPassenger(passportID);
				
		for (Flight flight  : passenger.getFlights()) {
			//assuming one flight per day
			if(checkDate(flight)) {
				return String.valueOf(flight.getNumber());
			}
		}
		return "";
	}

	public static String getFlightDate(String passportID) {
		Passenger passenger  = getPassenger(passportID);
				
		for (Flight flight  : passenger.getFlights()) {
			//assuming one flight per day
			if(checkDate(flight)) {
				return String.valueOf(flight.getFlightdate());
			}
		}
		return "";
	}

	public static String getFlightAirline(String passportID) {
		Passenger passenger  = getPassenger(passportID);
				
		for (Flight flight  : passenger.getFlights()) {
			//assuming one flight per day
			if(checkDate(flight)) {
				return String.valueOf(flight.getAirline());
			}
		}
		return "";
	}

	public static Luggage createLuggage(float aWeight, boolean aPriority, boolean aFragile, String passportID)
	{
		LTS lts = LTS.getInstance();
		String location = getFlightSource(passportID);
		Passenger passenger = getPassenger(passportID);
		Luggage luggage = new Luggage (aWeight, aPriority, aFragile, location, passenger);
		passenger.addLuggage(luggage);
		
		PersistenceXStream.saveToXMLwithXStream(lts);	
		return luggage;
	}
	
	public static int getLuggageCount(String passportID)
	{
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				return passenger.getLuggages().size();
			}
		}
		return 0;
	}

	public static void createTransaction(float aAmount, boolean aPaid, 
			String aCreditCard, String passportID, Date aExpirydate, String aCcname, int aSecurityCode) {
		LTS lts = LTS.getInstance();
		CreditCard creditCard = new CreditCard(aCreditCard, aExpirydate, aCcname, aSecurityCode, lts);
		Passenger passenger = getPassenger(passportID);
		Transaction tr = new Transaction (aAmount, aPaid, new Date(Calendar.getInstance().getTime().getTime()), lts, passenger, creditCard);
		passenger.addTransaction(tr);		
		PersistenceXStream.saveToXMLwithXStream(lts);	
				
	}
	
	public static void getAirCanadaFlightCount(String passportID) {
		LTS lts = LTS.getInstance();
		int count = 0;
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				for(Flight flight: passenger.getFlights()) {
					if(flight.getAirline().equals("Air Canada")) {
						count++;
					}
				}
				passenger.setAirCanadaFlightCount(count);
			}
		}
		
		PersistenceXStream.saveToXMLwithXStream(lts);	
	}
	
}
