package ca.mcgill.ecse681.lts.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class LTSWindow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7983207646348376216L;
	private JTextField txtLuggageTrackingSystem;
	private JLabel lblNewLabel_1;
	private int x = 100;
    private Timer timer;

	

	/**
	 * Create the panel.
	 */
	public LTSWindow() {
		//JFrame e = (JFrame) this.getParent();
		//setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		txtLuggageTrackingSystem = new JTextField();
		txtLuggageTrackingSystem.setEditable(false);
		txtLuggageTrackingSystem.setBackground(new Color(135, 206, 235));
		txtLuggageTrackingSystem.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtLuggageTrackingSystem.setBounds(46, 35, 599, 44);
		txtLuggageTrackingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		txtLuggageTrackingSystem.setFont(new Font("Stencil", Font.PLAIN, 44));
		txtLuggageTrackingSystem.setText("Luggage Tracking System");
		add(txtLuggageTrackingSystem);
		txtLuggageTrackingSystem.setColumns(10);
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(104, 130, 139, 262);
		ImageIcon MyImage = new ImageIcon(this.getClass().getResource("/images/icon.png"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		lblNewLabel_1.setIcon(image);
		add(lblNewLabel_1);
				
		Canvas canvas = new Canvas();
		canvas.setForeground(Color.BLACK);
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(307, 97, 327, 324);
		add(canvas);
		
		JButton btnStartRegistration = new JButton("Start Registration");
		btnStartRegistration.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_1.setOpaque(true);
				lblNewLabel_1.move(400,125);

				SwingUtilities.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                    try
	                    {
	                        Thread.sleep(750);
	                    }
	                    catch(Exception ie)
	                    {}	 
	                    
	                    setVisible(false);
	    				LTSRegistration ltsr = new LTSRegistration(LTSWindow.this);
	    				ltsr.setVisible(true);
	    				repaint();
	                }
	            });			
			}
		});
		
		btnStartRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStartRegistration.setBounds(244, 445, 157, 36);
		add(btnStartRegistration);
		setBounds(100, 100, 676, 504);
	}
	
	/*@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon MyImage = new ImageIcon(this.getClass().getResource("/images/icon.png"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		image.paintIcon(this, g, 50, 50);

	}
	
	public void move() {
		x += 50;
		repaint();
	}*/

}
