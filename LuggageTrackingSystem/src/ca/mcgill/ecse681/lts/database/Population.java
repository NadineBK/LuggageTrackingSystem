package ca.mcgill.ecse681.lts.database;

import ca.mcgill.ecse681.lts.model.LTS;
import ca.mcgill.ecse681.lts.model.Passenger;
import ca.mcgill.ecse681.lts.persistence.PersistenceXStream;

public class Population {

	public static void main() {
		LTS lts = LTS.getInstance();
		Passenger p = new Passenger("ABC123", "John", "Patrick", false, 23.0f, false, false, lts);
		lts.addPassenger(p);
		//add other passengers/flights/etc. to database
		//Passenger p2 = ...
		//lts.addPassenger(p2);
		PersistenceXStream.saveToXMLwithXStream(lts);
	}

}
