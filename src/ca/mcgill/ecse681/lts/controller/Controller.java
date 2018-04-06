package ca.mcgill.ecse681.lts.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ca.mcgill.ecse681.lts.model.LTS;
import ca.mcgill.ecse681.lts.model.Luggage;
import ca.mcgill.ecse681.lts.model.Passenger;
import ca.mcgill.ecse681.lts.model.Tag;
import ca.mcgill.ecse681.lts.model.Flight;
import ca.mcgill.ecse681.lts.persistence.PersistenceXStream;

import java.sql.Date;

public class Controller {

	public Controller(){
	}
	
	/*public void createElection(String aName, String aIsByElection, Date aDateOfElectionForScheduledElection) throws InvalidInputException {
		try 
		{
			Election elec;
			elec = new Election (aName, aIsByElection, aDateOfElectionForScheduledElection);
			ElectionManager em = ElectionManager.getInstance();
			em.addElection(elec);
			PersistenceXStream.saveToXMLwithXStream(em);
		}
		catch (RuntimeException exp) 
		{
			throw new InvalidInputException(exp.getMessage());
		}

	}*/
	
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
	
	public static String getPassengerOverweightPrivelage(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				return String.valueOf(passenger.getOverweightLuggagePrivilege());
			}
		}
		return "";
	}

	public static String getPassengerLoungeAccess(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				return String.valueOf(passenger.getLoungeAccess());
			}
		}
		return "";
	}
	
	public static String getPassengerValidPassport(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			if(passenger.getPassportID().equals(passportID)) {
				return String.valueOf(passenger.getExpiredPassport());
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

	public static Luggage createLuggage(float aWeight, boolean aPriority, boolean aFragile, Passenger passenger)
 {
		LTS lts = LTS.getInstance();
		
		
		Luggage luggage = new Luggage (aWeight, aPriority, aFragile, passenger);
		passenger.addLuggage(luggage);
		
		PersistenceXStream.saveToXMLwithXStream(lts);	
		return luggage;
	}

}
