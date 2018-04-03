package ca.mcgill.ecse681.lts.application;

import java.awt.EventQueue;

//import ca.mcgill.ecse681.lts.model.Flight;
//import ca.mcgill.ecse681.lts.model.LTS;
//import ca.mcgill.ecse681.lts.model.Passenger;
import ca.mcgill.ecse681.lts.persistence.PersistenceObjectStream;
import ca.mcgill.ecse681.lts.view.LTSMain;

import javax.swing.JFrame;

public class LTSApplication {

	//private static LTS lts;
	private final static String FILE_NAME = "data.ems";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//LTSApplication app = new LTSApplication();
					//app.frame.setVisible(true);
					new LTSMain().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*public static LTS getLTS() {
		if (lts == null) {
			lts = load();
		}
		return lts;
	}
	
	public static void save() {
		PersistenceObjectStream.serialize(lts);
	}

	private static LTS load() {
		PersistenceObjectStream.setFilename(FILE_NAME);
		lts = (LTS) PersistenceObjectStream.deserialize();
		if (lts == null) {
			lts = new LTS();
		} else {
			//Flight.reinitializeUniqueID(lts.getFlights());
			Passenger.reinitializeUniqueID(lts.getPassengers());
			//ElectedBody.reinitializeUniqueID(ems.getElectedBodies());
		}
		return lts;
	}
	*/
}
