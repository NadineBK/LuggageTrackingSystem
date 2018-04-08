package ca.mcgill.ecse681.lts.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ca.mcgill.ecse681.lts.controller.Controller;
import ca.mcgill.ecse681.lts.model.CreditCard;
import ca.mcgill.ecse681.lts.model.LTS;
import ca.mcgill.ecse681.lts.model.Passenger;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class LTSTransaction extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7515045867092081866L;
	private JTextField txtTransaction;
	private JLabel lblAmount;
	private JTextField amount;
	private JButton btnFinish;
	private JButton btnValidate;
	private JButton btnCancel;
	private JLabel lblCreditCardNumber;
	private JTextField creditCardNumber;
	private JLabel lblExpiryDate;
	private JTextField month;
	private JTextField year;
	private JLabel monthYear;
	private JLabel lblMonth;
	private JLabel lblYear;
	private JLabel lblNameOnCard;
	private JTextField nameOnCard;
	private JLabel lblSecurityCode;
	private JTextField securityCode;
	private JLabel lblOutput;
	/**
	 * Create the panel.
	 */
	public LTSTransaction(final JFrame parent, final JPanel lr, float overweight, String passportID) {
		setBounds(100, 100, 676, 504);
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		txtTransaction = new JTextField();
		txtTransaction.setForeground(new Color(255, 255, 255));
		txtTransaction.setBackground(new Color(0, 0, 139));
		txtTransaction.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		txtTransaction.setEditable(false);
		txtTransaction.setBounds(56, 29, 599, 37);
		txtTransaction.setText("Transaction");
		add(txtTransaction);
		txtTransaction.setColumns(10);
		
		lblAmount = new JLabel("Amount ($)");
		lblAmount.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAmount.setBounds(196, 102, 118, 20);
		add(lblAmount);
		
		amount = new JTextField();
		amount.setBounds(361, 103, 126, 20);
		amount.setEditable(false);
		amount.setText(String.valueOf(overweight*10));
		add(amount);
		amount.setColumns(10);
		
		btnFinish = new JButton("PAY");
		
		btnFinish.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnFinish.setBounds(290, 314, 89, 23);
		add(btnFinish);
		btnFinish.setEnabled(false);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
 				LTSWindow ltsw = new LTSWindow(parent);
 				parent.setContentPane(ltsw);
			}
		});
		btnCancel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnCancel.setBounds(43, 459, 89, 23);
		add(btnCancel);
		
		lblCreditCardNumber = new JLabel("Credit Card Number");
		lblCreditCardNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblCreditCardNumber.setBounds(196, 146, 145, 14);
		add(lblCreditCardNumber);
		
		creditCardNumber = new JTextField();
		creditCardNumber.setBounds(361, 144, 126, 20);
		add(creditCardNumber);
		creditCardNumber.setColumns(10);
		
		lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblExpiryDate.setBounds(196, 188, 94, 14);
		add(lblExpiryDate);
		
		month = new JTextField();
		month.setBounds(365, 179, 42, 20);
		add(month);
		month.setColumns(10);
		
		year = new JTextField();
		year.setBounds(437, 179, 42, 20);
		add(year);
		year.setColumns(10);
		
		
		monthYear = new JLabel("/");
		monthYear.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		monthYear.setHorizontalAlignment(SwingConstants.CENTER);
		monthYear.setBounds(409, 178, 25, 23);
		add(monthYear);
		
		lblMonth = new JLabel("MM");
		lblMonth.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(361, 201, 46, 14);
		add(lblMonth);
		
		lblYear = new JLabel("YY");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblYear.setBounds(433, 201, 46, 14);
		add(lblYear);
		
		lblNameOnCard = new JLabel("Name On Card");
		lblNameOnCard.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNameOnCard.setBounds(196, 228, 105, 14);
		add(lblNameOnCard);
		
		nameOnCard = new JTextField();
		nameOnCard.setBounds(361, 226, 126, 20);
		add(nameOnCard);
		nameOnCard.setColumns(10);
		
		lblSecurityCode = new JLabel("Security Code");
		lblSecurityCode.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSecurityCode.setBounds(196, 266, 118, 14);
		add(lblSecurityCode);
		
		securityCode = new JTextField();
		securityCode.setBounds(361, 263, 125, 20);
		add(securityCode);
		securityCode.setColumns(10);
		
		JButton btnPrintReceipt = new JButton("PRINT RECEIPT");
		btnPrintReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
 				parent.setContentPane(lr);
 				lr.setVisible(true);
 				((LTSLuggageRegistration) lr).adjustButtons();
 				
			}
		});
		btnPrintReceipt.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnPrintReceipt.setBounds(268, 380, 139, 23);
		add(btnPrintReceipt);
		btnPrintReceipt.setEnabled(false);
		
		lblOutput = new JLabel("");
		lblOutput.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setEnabled(false);
		lblOutput.setBounds(258, 348, 155, 21);
		add(lblOutput);
		
		btnValidate = new JButton("Validate Card");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean allValid = true;
				//credit card is 16 numbers, year and month after today
				int currentMonth = Calendar.getInstance().getTime().getMonth();
				int currentYear = Calendar.getInstance().getTime().getYear()-2000;
				if(!(month.getText().matches("[0-9]+") && ((month.getText().length() ==1) || (month.getText().length() ==2))) ) {	
					allValid=false;
					JOptionPane.showMessageDialog(null, "Invalid Month!", "LuggageTrackingSystem", 1);
					return;
				}
				if(!(year.getText().matches("[0-9]+") && (year.getText().length() ==2)) ) {
					
					allValid=false;
					JOptionPane.showMessageDialog(null, "Invalid Year!", "LuggageTrackingSystem", 1);
					return;
				}
				if(Integer.valueOf(year.getText())>currentYear){
					//do nothing
				}
				else if(Integer.valueOf(year.getText())<currentYear){
					allValid=false;
					JOptionPane.showMessageDialog(null, "Credit Card is expired!", "LuggageTrackingSystem", 1);
					return;
				}else{
					if(Integer.valueOf(month.getText())<currentMonth){
						allValid=false;
						JOptionPane.showMessageDialog(null, "Credit Card is expired!", "LuggageTrackingSystem", 1);
						return;
					}
				}
				
				if(!(creditCardNumber.getText().matches("[0-9]+") && creditCardNumber.getText().length() ==16)) {
					allValid=false;
					//joptionPane
					JOptionPane.showMessageDialog(null, "Invalid Credit Card Number!", "LuggageTrackingSystem", 1);
					return;
				}
				
				//security code is 3 numbers
				if(!(securityCode.getText().matches("[0-9]+") && securityCode.getText().length() ==3)) {
					allValid=false;
					JOptionPane.showMessageDialog(null, "Invalid Security Code!", "LuggageTrackingSystem", 1);
					return;
				}
				if(allValid){
					btnFinish.setEnabled(true);
					//, Date aExpirydate, String aCcname, int aSecurityCode
					Date exDate = new Date(Calendar.getInstance().getTime().getTime());
					exDate.setMonth(Integer.valueOf(month.getText()));
					exDate.setYear(Integer.valueOf(year.getText()));
					Controller.createTransaction(Float.valueOf(amount.getText()), true, 
							creditCardNumber.getText(), passportID, exDate,  nameOnCard.getText(), Integer.valueOf(securityCode.getText()));
					
					
				}
			}
		});
		btnValidate.setBounds(500, 263, 125, 20);
		btnValidate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		add(btnValidate);
		
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblOutput.setText("Transaction Successful!");
				lblOutput.setEnabled(true);
				btnPrintReceipt.setEnabled(true);
				btnFinish.setEnabled(false);
			}
		});
	}
}
