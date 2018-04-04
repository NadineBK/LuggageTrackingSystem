package ca.mcgill.ecse681.lts.persistence;

import java.util.Iterator;
import ca.mcgill.ecse681.lts.model.*;


public class PersistenceLTS {

	private static void initializeXStream() {
		PersistenceXStream.setFilename("data.xml");
		PersistenceXStream.setAlias("lts", LTS.class);
		PersistenceXStream.setAlias("creditCard", CreditCard.class);
		PersistenceXStream.setAlias("flight", Flight.class);
		PersistenceXStream.setAlias("luggage", Luggage.class);
		PersistenceXStream.setAlias("passenger", Passenger.class);
		PersistenceXStream.setAlias("tag", Tag.class);
		PersistenceXStream.setAlias("transaction", Transaction.class);
	}

	public static void loadLTS() {
		LTS ltsOb = LTS.getInstance();
		PersistenceLTS.initializeXStream();
		LTS ltsOb2 = (LTS) PersistenceXStream.loadFromXMLwithXStream();
		if (ltsOb2 != null) {
			
			Iterator<Passenger> pIt = ltsOb2.getPassengers().iterator();
			while (pIt.hasNext())
				ltsOb.addPassenger(pIt.next());
			
			Iterator<Flight> fIt = ltsOb2.getFlights().iterator();
			while (fIt.hasNext())
				ltsOb.addFlight(fIt.next());
			
			Iterator<Transaction> tIt = ltsOb2.getTransactions().iterator();
			while (tIt.hasNext())
				ltsOb.addTransaction(tIt.next());
			
			Iterator<CreditCard> cIt = ltsOb2.getCreditCards().iterator();
			while (cIt.hasNext())
				ltsOb.addCreditCard(cIt.next());

		}
	}

}
