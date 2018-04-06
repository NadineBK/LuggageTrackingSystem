package ca.mcgill.ecse681.lts.database;

import ca.mcgill.ecse681.lts.model.LTS;
import ca.mcgill.ecse681.lts.model.Passenger;

import java.sql.Date;
import java.util.Calendar;

import ca.mcgill.ecse681.lts.model.Flight;
import ca.mcgill.ecse681.lts.persistence.PersistenceXStream;

public class Population {

	public static void main() {
		LTS lts = LTS.getInstance();
		  
		Passenger p = new Passenger("ABC123", "John", "Patrick", false, 23.0f, false, false, lts);
		Flight f = new Flight("Montreal", "New York",  new Date(Calendar.getInstance().getTime().getTime()), "Air Canada", "AC 345", lts);
		lts.addPassenger(p);
		lts.addFlight(f);
		p.addFlight(f);
		//add other passengers/flights/etc. to database
		//Passenger p2 = ...
		//lts.addPassenger(p2);
		PersistenceXStream.saveToXMLwithXStream(lts);
	}

}
