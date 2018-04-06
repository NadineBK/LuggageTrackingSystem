package ca.mcgill.ecse681.lts.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ca.mcgill.ecse681.lts.controller.Controller;
import ca.mcgill.ecse681.lts.model.Luggage;
import ca.mcgill.ecse681.lts.model.Passenger;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LTSLuggageRegistration extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2541143312780718091L;
	/**
	 * 
	 */
	private JTextField txtRegistration;
	private JLabel lblWeight;
	private JTextField weight;
	private JButton btnFinish;
	private JButton btnCancel;
	private JCheckBox chckbxPriority;
	private JCheckBox chckbxFragile;
	private JButton btnPayForOverweight;
	private JButton btnAddAnotherLuggage;
	private JButton btnRegisterLuggage;
	private JButton btnCheckIn;
	private JTable table;
	private JLabel lblFragile;
	private JLabel lblPriority;
	private float overweight;


	/**
	 * Create the panel.
	 */
	public LTSLuggageRegistration(final JFrame parent, String passportID) {
		setBounds(100, 100, 676, 504);
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		txtRegistration = new JTextField();
		txtRegistration.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtRegistration.setForeground(new Color(255, 255, 255));
		txtRegistration.setBackground(new Color(0, 0, 139));
		txtRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistration.setEditable(false);
		txtRegistration.setBounds(56, 29, 599, 37);
		txtRegistration.setText("Registration");
		add(txtRegistration);
		txtRegistration.setColumns(10);
		
		lblWeight = new JLabel("Weight (kg)");
		lblWeight.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblWeight.setBounds(97, 102, 118, 20);
		add(lblWeight);
		
		weight = new JTextField();
		weight.setBounds(216, 103, 128, 20);
		add(weight);
		weight.setColumns(10);
				
		btnCheckIn = new JButton("Check In ->");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!weight.getText().isEmpty()){
					if(Float.valueOf(weight.getText()) > Float.valueOf(Controller.getPassengerWeightLimit(passportID))){
						btnRegisterLuggage.setEnabled(false);
						btnPayForOverweight.setEnabled(true);
						overweight = (int) Math.ceil(Float.valueOf(weight.getText()) - Float.valueOf(Controller.getPassengerWeightLimit(passportID)));
					}else{
						btnRegisterLuggage.setEnabled(true);
						btnPayForOverweight.setEnabled(false);

					}
				
				}else{
					JOptionPane.showMessageDialog(null, "Please enter the weight of your luggage!", "LuggageTrackingSystem", 1);
				}
			}
		});
		
		btnCheckIn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnCheckIn.setBounds(217, 122, 126, 20);//setBounds(97, 102, 118, 20);
		add(btnCheckIn);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		lblFragile = new JLabel("New label");
		lblFragile.setBackground(Color.WHITE);
		lblFragile.setBounds(520, 272, 118, 131);
		lblFragile.setBorder(border);
		ImageIcon MyImage = new ImageIcon(this.getClass().getResource("/images/fragile.jpg"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblFragile.getWidth(), lblFragile.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		lblFragile.setIcon(image);
		lblFragile.setVisible(false);
		add(lblFragile);
		
		lblPriority = new JLabel("New label");
		lblPriority.setBackground(Color.WHITE);
		lblPriority.setBounds(43, 289, 118, 114);
		lblPriority.setBorder(border);
		ImageIcon MyImage2 = new ImageIcon(this.getClass().getResource("/images/priority.jpg"));
		Image img2 = MyImage2.getImage();
		Image newImg2 = img2.getScaledInstance(lblPriority.getWidth(), lblPriority.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image2 = new ImageIcon(newImg2);
		lblPriority.setIcon(image2);
		lblPriority.setVisible(false);
		add(lblPriority);
		
		JLabel lblTag = new JLabel("Tag");
		lblTag.setHorizontalAlignment(SwingConstants.CENTER);
		lblTag.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblTag.setBounds(259, 245, 161, 23);
		add(lblTag);
		
		btnFinish = new JButton("FINISH");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using our Self-Adaptive Luggage Tracking System!", "LuggageTrackingSystem", 1);
				setVisible(false);
 				LTSWindow ltsw = new LTSWindow(parent);
 				parent.setContentPane(ltsw);
			}
		});
		btnFinish.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnFinish.setBounds(566, 459, 89, 23);
		add(btnFinish);
		
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
		
		chckbxPriority = new JCheckBox("High Priority");
		chckbxPriority.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		chckbxPriority.setBounds(376, 101, 118, 23);
		chckbxPriority.setBackground(new Color(135, 206, 235));
		add(chckbxPriority);
		
		chckbxFragile = new JCheckBox("Fragile");
		chckbxFragile.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		chckbxFragile.setBounds(526, 101, 118, 23);
		chckbxFragile.setBackground(new Color(135, 206, 235));
		add(chckbxFragile);
		
		btnPayForOverweight = new JButton("Pay for Overweight Luggage");
		btnPayForOverweight.setEnabled(false);
		btnPayForOverweight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
 				LTSTransaction ltst = new LTSTransaction(parent, LTSLuggageRegistration.this, overweight);
 				parent.setContentPane(ltst);
			}
		});
		btnPayForOverweight.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnPayForOverweight.setBounds(216, 148, 229, 23);
		add(btnPayForOverweight);
		
		btnRegisterLuggage = new JButton("Register Luggage");
		btnRegisterLuggage.setEnabled(false);
		btnRegisterLuggage.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnRegisterLuggage.setBounds(216, 180, 229, 23);
		add(btnRegisterLuggage);
		
		btnRegisterLuggage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxFragile.isSelected())
				{
					lblFragile.setVisible(true);
				}
				else if(!chckbxFragile.isSelected())
				{
					lblFragile.setVisible(false);
				}
				if(chckbxPriority.isSelected())
				{
					lblPriority.setVisible(true);
				}
				else if(!chckbxPriority.isSelected())
				{
					lblPriority.setVisible(false);
				}
				
				Passenger passenger = Controller.getPassenger(passportID);
				Luggage luggage  = Controller.createLuggage(Float.valueOf(weight.getText()), chckbxPriority.isSelected(), chckbxFragile.isSelected(), passenger);
				
				
				table.getModel().setValueAt(Controller.getFlightSource(passportID), 0, 1);	
				table.getModel().setValueAt(Controller.getFlightDestination(passportID), 1, 1);	
				table.getModel().setValueAt(Controller.getFlightNumber(passportID), 2, 1);	
				table.getModel().setValueAt(Controller.getPassengerFirstName(passportID), 3, 1);	
				table.getModel().setValueAt(Controller.getPassengerLastName(passportID), 4, 1);	
				table.getModel().setValueAt(luggage.getTag().getLuggageID(), 5, 1);	
				
				btnRegisterLuggage.setEnabled(false);
			}
		});
		
		
		
		btnAddAnotherLuggage = new JButton("Add another luggage");
		btnAddAnotherLuggage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weight.setText("");
				chckbxFragile.setSelected(false);
				chckbxPriority.setSelected(false);	
				int i;
				for(i=0; i<6; i++) {
					table.getModel().setValueAt("",i,1);
				}
				lblPriority.setVisible(false);
				lblFragile.setVisible(false);
				btnRegisterLuggage.setEnabled(false);
				btnPayForOverweight.setEnabled(false);
			}
		});
		btnAddAnotherLuggage.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnAddAnotherLuggage.setBounds(233, 433, 229, 23);
		add(btnAddAnotherLuggage);
		
		table = new JTable();
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Source", null},
				{"Destination", null},
				{"Flight Number", null},
				{"First Name", null},
				{"Last Name", null},
				{"LuggageID", null},
			},
			new String[] {
				"Luggage Data", "Value"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(179, 289, 323, 114);	
	    table.setRowHeight(table.getRowHeight() + 3);
		
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT); 
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); 
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int x = 0; x < table.getColumnCount(); x++){ 
			table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer); 
			}
		
		add(table);
		

	}


	public void adjustButtons() {
		btnRegisterLuggage.setEnabled(true);
		btnPayForOverweight.setEnabled(false);
	}
	
}
