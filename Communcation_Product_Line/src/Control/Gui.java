package Control;

//import UltimateGUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JTextField;

import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Gui {

	private JFrame frame;
	private JTextField textSend;

	public Gui() {
		// Classcreator BErechtigung und Funktionailtät
	}

	public void init() {
		initialize();
		System.out.println("Gui initialized");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

		ImageIcon imgConfig = new ImageIcon("./img/19-gear-icon-16.png");
		ImageIcon imgAvatar = new ImageIcon("./img/avatar-default-icon.png");
		ImageIcon imgSend = new ImageIcon("./img/paper-plane-icon-16.png");
		ImageIcon imgVoice = new ImageIcon("./img/mic-icon-16.png");
		ImageIcon imgFile = new ImageIcon("./img/Download-icon-16.png");
		ImageIcon imgCam = new ImageIcon("./img/App-Facetime-icon-16.png");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// Gesamter Frame für EINEN TAB
		Box horizontalBox = Box.createHorizontalBox();
		tabbedPane.addTab("New tab", null, horizontalBox, null);

		// Chatfenster
		Box verticalLeftBox = Box.createVerticalBox();
		horizontalBox.add(verticalLeftBox);
		
		// Chat
		JScrollPane scrollPaneChat = new JScrollPane();
		verticalLeftBox.add(scrollPaneChat);
		JTextPane textPaneChat = new JTextPane();
		scrollPaneChat.setViewportView(textPaneChat);
		
		// Balken dazwischen
		Component verticalStrut = Box.createVerticalStrut(5);
		verticalLeftBox.add(verticalStrut);
		// Input
		JScrollPane scrollPaneInput = new JScrollPane();
		verticalLeftBox.add(scrollPaneInput);
		JTextPane textPaneInput = new JTextPane();
		scrollPaneInput.setViewportView(textPaneInput);
		
		// Buttons
		Box verticalRightBox = Box.createVerticalBox();
		horizontalBox.add(verticalRightBox);

		JButton btnConfig = new JButton("");
		btnConfig.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnConfig.setAlignmentY(Component.TOP_ALIGNMENT);
		verticalRightBox.add(btnConfig);
		btnConfig.setIcon(imgConfig);

		JLabel lblAvatar = new JLabel("");
		lblAvatar.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalRightBox.add(lblAvatar);
		lblAvatar.setIcon(imgAvatar);

		JToggleButton tglbtnCam = new JToggleButton("");
		tglbtnCam.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalRightBox.add(tglbtnCam);
		tglbtnCam.setIcon(imgCam);

		Box horizontalBottomRightBox = Box.createHorizontalBox();
		verticalRightBox.add(horizontalBottomRightBox);

		JButton btnSend = new JButton("");
		btnSend.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSend.setIcon(imgSend);
		horizontalBottomRightBox.add(btnSend);

		JButton btnVoice = new JButton("");
		btnVoice.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVoice.setIcon(imgVoice);
		horizontalBottomRightBox.add(btnVoice);

		JButton btnFile = new JButton("");
		btnFile.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnFile.setIcon(imgFile);
		horizontalBottomRightBox.add(btnFile);
	}

}
