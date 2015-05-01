package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.mock.MockResources;

public class test123 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test123 window = new test123();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test123() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChatTab ct = new ChatTab(MockResources.PERSONS);
		ct.setLocation(0, 0);
		frame.add(ct);
		frame.setVisible(true);
	}

}