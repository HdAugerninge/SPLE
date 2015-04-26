package Control;

//import UltimateGUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JTextField;

import java.awt.Image;

import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Gui {

	public JFrame frame;
	public JTextField textSend;
	
	public Gui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image imgConfig = new ImageIcon(this.getClass().getResource("/19-gear-icon-16.png")).getImage();
		Image imgAvatar = new ImageIcon(this.getClass().getResource("/avatar-default-icon.png")).getImage();
		Image imgSend = new ImageIcon(this.getClass().getResource("/paper-plane-icon-16.png")).getImage();
		Image imgVoice = new ImageIcon(this.getClass().getResource("/mic-icon-16.png")).getImage();
		Image imgFile = new ImageIcon(this.getClass().getResource("/Download-icon-16.png")).getImage();
		//Image imgCam = new ImageIcon(this.getClass().getResource("/App-Facetime-icon-16.png")).getImage();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		Box verticalBox = Box.createVerticalBox();
		tabbedPane.addTab("New tab", null, verticalBox, null);
		
		Box horizontalBottomBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBottomBox);
		
		Box verticalLeftBox = Box.createVerticalBox();
		horizontalBottomBox.add(verticalLeftBox);
		
		JScrollPane scrollPane = new JScrollPane();
		verticalLeftBox.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		verticalLeftBox.add(textPane);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		verticalLeftBox.add(verticalStrut);
		
		JTextField textSend = new JTextField();
		verticalLeftBox.add(textSend);
		textSend.setColumns(10);
		
		Box verticalRightBox = Box.createVerticalBox();
		horizontalBottomBox.add(verticalRightBox);
		
		JButton btnConfig = new JButton("");
		btnConfig.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnConfig.setAlignmentY(Component.TOP_ALIGNMENT);
		verticalRightBox.add(btnConfig);
		btnConfig.setIcon(new ImageIcon(imgConfig));
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalRightBox.add(lblAvatar);
		lblAvatar.setIcon(new ImageIcon(imgAvatar));
		
		JToggleButton tglbtnCam = new JToggleButton("");
		tglbtnCam.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalRightBox.add(tglbtnCam);
		//tglbtnCam.setIcon(new ImageIcon(imgCam));
		
		Box horizontalBottomRightBox = Box.createHorizontalBox();
		verticalRightBox.add(horizontalBottomRightBox);
		
		JButton btnSend = new JButton("");
		btnSend.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSend.setIcon(new ImageIcon(imgSend));
		horizontalBottomRightBox.add(btnSend);
		
		JButton btnVoice = new JButton("");
		btnVoice.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVoice.setIcon(new ImageIcon(imgVoice));
		horizontalBottomRightBox.add(btnVoice);
		
		JButton btnFile = new JButton("");
		btnFile.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnFile.setIcon(new ImageIcon(imgFile));
		horizontalBottomRightBox.add(btnFile);
	}
	
}
