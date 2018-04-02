package ca.mcgill.ecse681.lts.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LTSRegistration extends JPanel {

	private JPanel contentPane;
	private LTSWindow ltsw;

	/**
	 * Create the frame.
	 */
	public LTSRegistration(LTSWindow ltsw) {
		setBounds(100, 100, 715, 543);
		setBackground(new Color(135, 206, 235));
		setLayout(null);
	}

}
