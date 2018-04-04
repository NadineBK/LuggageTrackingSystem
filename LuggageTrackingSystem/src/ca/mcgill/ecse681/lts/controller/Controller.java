package ca.mcgill.ecse681.lts.controller;

import java.util.ArrayList;
import java.util.List;
import ca.mcgill.ecse681.lts.model.LTS;
import ca.mcgill.ecse681.lts.model.Passenger;
import ca.mcgill.ecse681.lts.persistence.PersistenceXStream;

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
			System.out.println(passenger.getPassportID() + "," + passportID);
			if(passenger.getPassportID().equals(passportID)) {
				return 1;
			}
		}
		return 0;
	}
	
	public static String getPassengerFirstName(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			System.out.println(passenger.getPassportID() + "," + passportID);
			if(passenger.getPassportID().equals(passportID)) {
				return passenger.getFirstName();
			}
		}
		return "";
	}
	
	public static String getPassengerLastName(String passportID) {
		LTS lts = LTS.getInstance();
		for (Passenger passenger : lts.getPassengers()) {
			System.out.println(passenger.getPassportID() + "," + passportID);
			if(passenger.getPassportID().equals(passportID)) {
				return passenger.getLastName();
			}
		}
		return "";
	}

}
