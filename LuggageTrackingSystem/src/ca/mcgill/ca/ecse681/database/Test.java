package ca.mcgill.ca.ecse681.database;
import ca.mcgill.ecse681.lts.model.LTS;
import ca.mcgill.ecse681.lts.model.Passenger;
import ca.mcgill.ecse681.lts.persistence.PersistenceXStream;

public class Test {

	public static void main(String[] args) {
		
		/*public void createElection(String aName, String aIsByElection, Date aDateOfElectionForScheduledElection) throws InvalidInputException {
			
			try {
				Election elec;
				elec = new Election (aName, aIsByElection, aDateOfElectionForScheduledElection);
				ElectionManager em = ElectionManager.getInstance();
				em.addElection(elec);
				PersistenceXStream.saveToXMLwithXStream(em);
			}
			catch (RuntimeException exp) {
				throw new InvalidInputException(exp.getMessage());
				
			}

		}*/
		LTS lts = LTS.getInstance();
		Passenger p = new Passenger("ABC123", "John", "Patrick", false, 23.0f, false, false, lts);
		lts.addPassenger(p);
		PersistenceXStream.saveToXMLwithXStream(p);
		
		System.out.println(p.getFirstName());
	}

}
