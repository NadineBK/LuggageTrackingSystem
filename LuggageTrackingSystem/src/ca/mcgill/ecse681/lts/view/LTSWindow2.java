package ca.mcgill.ecse681.lts.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LTSWindow2 {

	private JFrame frame;
	private JTextField txtLuggageTrackingSystem;
	private JLabel lblNewLabel_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LTSWindow2 window = new LTSWindow2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LTSWindow2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.getContentPane().setLayout(null);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(106, 114, 141, 277);
		//frame.getContentPane().add(lblNewLabel_1);
		ImageIcon MyImage = new ImageIcon(this.getClass().getResource("/images/icon.png"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		lblNewLabel_1.setIcon(image);
		
		frame.getContentPane().add(lblNewLabel_1);
		
		txtLuggageTrackingSystem = new JTextField();
		txtLuggageTrackingSystem.setEditable(false);
		txtLuggageTrackingSystem.setBackground(new Color(135, 206, 235));
		txtLuggageTrackingSystem.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtLuggageTrackingSystem.setBounds(52, 27, 602, 50);
		txtLuggageTrackingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		txtLuggageTrackingSystem.setFont(new Font("Stencil", Font.PLAIN, 44));
		txtLuggageTrackingSystem.setText("Luggage Tracking System");
		frame.getContentPane().add(txtLuggageTrackingSystem);
		txtLuggageTrackingSystem.setColumns(10);
		
		Canvas canvas = new Canvas();
		canvas.setForeground(Color.BLACK);
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(327, 94, 327, 324);
		frame.getContentPane().add(canvas);
		
		JButton btnStartRegistration = new JButton("Start Registration");
		btnStartRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStartRegistration.setBounds(270, 438, 141, 33);
		frame.getContentPane().add(btnStartRegistration);
		frame.setBounds(100, 100, 715, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
