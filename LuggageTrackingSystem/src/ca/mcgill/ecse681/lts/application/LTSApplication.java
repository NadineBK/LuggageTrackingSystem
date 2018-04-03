package ca.mcgill.ecse681.lts.application;

import ca.mcgill.ecse681.lts.persistence.PersistenceLTS;
import ca.mcgill.ecse681.lts.view.LTSMain;

public class LTSApplication {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// load model
		PersistenceLTS.loadLTS();
		
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LTSMain().setVisible(true);
            }
        });
        
	}
}

