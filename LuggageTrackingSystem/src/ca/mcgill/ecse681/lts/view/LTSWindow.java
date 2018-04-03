package ca.mcgill.ecse681.lts.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LTSWindow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7983207646348376216L;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public LTSWindow(final JFrame parent) {
		//parent = (JFrame) this.getParent();
		//setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setForeground(Color.BLACK);
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(316, 380, 310, 19);
		add(canvas);
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(84, 130, 139, 262);
		ImageIcon MyImage = new ImageIcon(this.getClass().getResource("/images/icon.png"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		lblNewLabel_1.setIcon(image);
		add(lblNewLabel_1);
		
		JButton btnStartRegistration = new JButton("Start Registration");
		btnStartRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lblNewLabel_1.setOpaque(true);
				lblNewLabel_1.setLocation(400,125);

				SwingUtilities.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                    try
	                    {
	                        Thread.sleep(1200);
	                    }
	                    catch(Exception ie)
	                    {}	 
	                    
	                    setVisible(false);
	    				LTSRegistration ltsr = new LTSRegistration(parent);
	    				parent.setContentPane(ltsr);
	    				//ltsr.setVisible(true);
	    				//repaint();
	                }
	            });			
			}
		});
		
		btnStartRegistration.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnStartRegistration.setBounds(275, 445, 157, 36);
		add(btnStartRegistration);
		setBounds(100, 100, 676, 504);
		
		JLabel lblNewLabel = new JLabel("Luggage Tracking System");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 31, 616, 57);
		add(lblNewLabel);

	}
	
	/*@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon MyImage = new ImageIcon(this.getClass().getResource("/images/icon.png"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		image.paintIcon(this, g, 50, 50);

	}*/

}
