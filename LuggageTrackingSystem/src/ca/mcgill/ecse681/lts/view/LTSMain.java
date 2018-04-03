package ca.mcgill.ecse681.lts.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class LTSMain extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4418254246815485951L;
	private JPanel contentPane;
	private LTSWindow w;


	/**
	 * Create the panel.
	 */
	public LTSMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 543);
		//setPreferredSize(new Dimension(460, 450));
		setTitle("Luggage Tracking System");
		//setBackground(new Color(135, 206, 235));
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		w = new LTSWindow(this);
		w.setSize(355, 158);
		w.setLocation(55, 25);
		w.setBounds(0, 0, 715, 543);
		//reg.setPreferredSize(new Dimension(450, 300));
		contentPane.add(w);
	}

}
