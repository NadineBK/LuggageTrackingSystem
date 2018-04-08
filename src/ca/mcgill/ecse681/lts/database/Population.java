package ca.mcgill.ecse681.lts.database;

import ca.mcgill.ecse681.lts.model.LTS;
import ca.mcgill.ecse681.lts.model.Passenger;

import java.sql.Date;
import java.util.Calendar;

import ca.mcgill.ecse681.lts.model.Flight;
import ca.mcgill.ecse681.lts.persistence.PersistenceXStream;

public class Population {

	public static void databaseCreation() {
		LTS lts = LTS.getInstance();
		  
		Passenger p = new Passenger("ABC123", "John", "Patrick", false, 23.0f, false, false, 0, lts);
		Flight f1 = new Flight("Montreal", "New York",  new Date(Calendar.getInstance().getTime().getTime()), "Air Canada", "AC 345", lts);
		Flight f2 = new Flight("New York", "Montreal",  new Date(18+100, 5, 4), "Air Canada", "AC 444", lts);
		Flight f3 = new Flight("Montreal", "Toronto",  new Date(10+100, 2, 7), "Air Canada", "AC 555", lts);
		Flight f4 = new Flight("Toronto", "Montreal",  new Date(10+100, 3, 1), "Air Canada", "AC 657", lts);
		Flight f5 = new Flight("Montreal", "Vancouver",  new Date(17+100, 4, 4), "Air Canada", "AC 333", lts);
		lts.addPassenger(p);
		lts.addFlight(f1);
		lts.addFlight(f2);
		lts.addFlight(f3);
		lts.addFlight(f4);
		lts.addFlight(f5);
		p.addFlight(f1);
		p.addFlight(f2);
		p.addFlight(f3);
		p.addFlight(f4);
		p.addFlight(f5);
		
		//add other passengers/flights/etc. to database
		//Passenger p2 = ...
		//lts.addPassenger(p2);
		PersistenceXStream.saveToXMLwithXStream(lts);
	}

}
