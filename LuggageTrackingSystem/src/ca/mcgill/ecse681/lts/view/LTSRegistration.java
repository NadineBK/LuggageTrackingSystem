package ca.mcgill.ecse681.lts.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ca.mcgill.ecse681.lts.controller.Controller;

public class LTSRegistration extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3330138391813747399L;
	private JTextField txtRegistration;
	private JTextField passportID;
	private JLabel lblPassportID;
	private JLabel lblFirstName;
	private JTextField firstName;
	private JLabel lblLastName;
	private JTextField lastName;
	private JLabel lblValidPassport;
	private JTextField validPassport;
	private JLabel lblWeightLimit;
	private JTextField weightLimit;
	private JLabel lblOverweightPrivilege;
	private JTextField overweightPrivilege;
	private JLabel lblLoungeAccess;
	private JTextField loungeAccess;
	private JLabel lblSource;
	private JTextField source;
	private JLabel lblDestination;
	private JTextField destination;
	private JLabel lblFlightNumber;
	private JTextField flightNumber;
	private JLabel lblFlightDate;
	private JTextField flightDate;
	private JLabel lblAirline;
	private JTextField airline;
	private JButton btnNext;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public LTSRegistration(final JFrame parent) {
		setBounds(100, 100, 676, 504);
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		txtRegistration = new JTextField();
		txtRegistration.setForeground(new Color(255, 255, 255));
		txtRegistration.setBackground(new Color(0, 0, 139));
		txtRegistration.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistration.setEditable(false);
		txtRegistration.setBounds(56, 29, 599, 37);
		txtRegistration.setText("Registration");
		add(txtRegistration);
		txtRegistration.setColumns(10);
		
		passportID = new JTextField();
		passportID.setBounds(230, 77, 190, 20);
		add(passportID);
		passportID.setColumns(10);
		
		JButton btnScan = new JButton("SCAN");
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Controller.populatePassengerDetails(passportID.getText());
				if(i == 1) {
					firstName.setText(Controller.getPassengerFirstName(passportID.getText()));
					//lastName.setText(Controller.getPassengerLastName(passportID.getText()));
					//keep doing this to populate all the fields using the separate methods
				}
				else if (i == 0)
				{
					JOptionPane.showMessageDialog(null, "Invalid Passport ID", "LuggageTrackingSystem", 1);
				}
			}
		});
		btnScan.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnScan.setBounds(478, 77, 89, 23);
		add(btnScan);
		
		lblPassportID = new JLabel("PassportID");
		lblPassportID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblPassportID.setBounds(114, 77, 118, 20);
		add(lblPassportID);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblFirstName.setBounds(55, 119, 118, 20);
		add(lblFirstName);
		
		firstName = new JTextField();
		firstName.setEditable(false);
		firstName.setBounds(183, 120, 126, 20);
		add(firstName);
		firstName.setColumns(10);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblLastName.setBounds(55, 150, 118, 20);
		add(lblLastName);
		
		lastName = new JTextField();
		lastName.setEditable(false);
		lastName.setBounds(183, 151, 126, 20);
		add(lastName);
		lastName.setColumns(10);
		
		lblValidPassport = new JLabel("Is Passport Valid?");
		lblValidPassport.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblValidPassport.setBounds(55, 181, 118, 20);
		add(lblValidPassport);
		
		validPassport = new JTextField();
		validPassport.setEditable(false);
		validPassport.setBounds(183, 182, 126, 20);
		add(validPassport);
		validPassport.setColumns(10);
		
		lblWeightLimit = new JLabel("Weight Limit (kg)");
		lblWeightLimit.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblWeightLimit.setBounds(331, 119, 118, 20);
		add(lblWeightLimit);
		
		weightLimit = new JTextField();
		weightLimit.setEditable(false);
		weightLimit.setBounds(529, 120, 126, 20);
		add(weightLimit);
		weightLimit.setColumns(10);
		
		lblOverweightPrivilege = new JLabel("Overweight Privilege? (32kg)");
		lblOverweightPrivilege.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblOverweightPrivilege.setBounds(330, 150, 200, 20);
		add(lblOverweightPrivilege);
		
		overweightPrivilege = new JTextField();
		overweightPrivilege.setEditable(false);
		overweightPrivilege.setBounds(529, 151, 126, 20);
		add(overweightPrivilege);
		overweightPrivilege.setColumns(10);
		
		lblLoungeAccess = new JLabel("Lounge Access?");
		lblLoungeAccess.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblLoungeAccess.setBounds(330, 181, 200, 20);
		add(lblLoungeAccess);
		
		loungeAccess = new JTextField();
		loungeAccess.setEditable(false);
		loungeAccess.setBounds(529, 182, 126, 20);
		add(loungeAccess);
		loungeAccess.setColumns(10);
		
		JLabel lblTravelDetails = new JLabel("Travel Details");
		lblTravelDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblTravelDetails.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblTravelDetails.setBounds(259, 245, 161, 14);
		add(lblTravelDetails);
		
		lblSource = new JLabel("Source");
		lblSource.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSource.setBounds(216, 280, 200, 20);
		add(lblSource);
		
		source = new JTextField();
		source.setEditable(false);
		source.setBounds(322, 281, 154, 20);
		add(source);
		source.setColumns(10);
		
		lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblDestination.setBounds(216, 311, 200, 20);
		add(lblDestination);
		
		destination = new JTextField();
		destination.setEditable(false);
		destination.setBounds(322, 312, 154, 20);
		add(destination);
		destination.setColumns(10);
		
		lblFlightNumber = new JLabel("Flight Number");
		lblFlightNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblFlightNumber.setBounds(216, 342, 200, 20);
		add(lblFlightNumber);
		
		flightNumber = new JTextField();
		flightNumber.setEditable(false);
		flightNumber.setBounds(322, 343, 154, 20);
		add(flightNumber);
		flightNumber.setColumns(10);
		
		lblFlightDate = new JLabel("Flight Date");
		lblFlightDate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblFlightDate.setBounds(216, 374, 200, 20);
		add(lblFlightDate);
		
		flightDate = new JTextField();
		flightDate.setEditable(false);
		flightDate.setBounds(322, 375, 154, 20);
		add(flightDate);
		flightDate.setColumns(10);
		
		lblAirline = new JLabel("Airline");
		lblAirline.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAirline.setBounds(216, 405, 200, 20);
		add(lblAirline);
		
		airline = new JTextField();
		airline.setEditable(false);
		airline.setBounds(322, 404, 154, 20);
		add(airline);
		airline.setColumns(10);
		
		btnNext = new JButton("NEXT ->");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
 				LTSLuggageRegistration ltslr = new LTSLuggageRegistration(parent);
 				parent.setContentPane(ltslr);
			}
		});
		btnNext.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNext.setBounds(566, 459, 89, 23);
		add(btnNext);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
 				LTSWindow ltsw = new LTSWindow(parent);
 				parent.setContentPane(ltsw);
			}
		});
		btnCancel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnCancel.setBounds(43, 459, 89, 23);
		add(btnCancel);
	}
}
