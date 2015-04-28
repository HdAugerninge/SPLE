
package gui;

//import UltimateGUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JPanel;

public class Gui {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JTextPane textPaneChat, textPaneInput;
	private ImageIcon imgConfig, imgAvatar, imgSend, imgVoice, imgFile, imgCam,
			imgAdd;
	private ChatTab currentChatTab;
	private List<ChatTab> listChatTab;
	private String variante;
	private JTextField textField;

	public Gui() {
		// Classcreator BErechtigung und Funktionailt�t
		imgConfig = new ImageIcon("./img/19-gear-icon-16.png");
		imgAvatar = new ImageIcon("./img/avatar-default-icon.png");
		imgSend = new ImageIcon("./img/paper-plane-icon-16.png");
		imgVoice = new ImageIcon("./img/mic-icon-16.png");
		imgFile = new ImageIcon("./img/Download-icon-16.png");
		imgCam = new ImageIcon("./img/App-Facetime-icon-16.png");
		imgAdd = new ImageIcon("./img/Plus-icon-16.png");
		listChatTab = new ArrayList<ChatTab>();
		variante = "Hier k�nnte Ihre Werbung stehen";
	}

	public void init() {
		initialize();
		System.out.println("Gui initialized");
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 615, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		// Gesamter Frame f�r EINEN TAB
		Box horizontalBox = Box.createHorizontalBox();
		frame.getContentPane().add(horizontalBox);
		horizontalBox.add(tabbedPane);
		
		ChatTab defaulttab = new ChatTab("");
		tabbedPane.addTab("New tab", null, defaulttab, null);
		

		// Buttons
		Box verticalRightBox = Box.createVerticalBox();
		horizontalBox.add(verticalRightBox);

		Box horizontalTopRightBox = Box.createHorizontalBox();
		verticalRightBox.add(horizontalTopRightBox);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = inputBox("Name eintragen bitte", "Neuer Chat");
				EventQueue.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						currentChatTab = new ChatTab(name);
						listChatTab.add(currentChatTab);
						tabbedPane.addTab(name, currentChatTab);
						tabbedPane.setSelectedIndex(tabbedPane.indexOfComponent(currentChatTab));
						tabbedPane.invalidate();
						tabbedPane.repaint();
						tabbedPane.updateUI();
						System.out.println(currentChatTab.getName());
					}
				});
				
				
//				frame.setVisible(true);
			}
		});
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalTopRightBox.add(btnAdd);
		btnAdd.setIcon(imgAdd);

		JButton btnConfig = new JButton("");
		btnConfig.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalTopRightBox.add(btnConfig);
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

		infoBox("Herzlich Willkommen", variante);
	}

	// Helpermethods
	private Integer getSelectedTab() {
		return tabbedPane.getSelectedIndex();
	}

	private String getInputValueTab(int tabnummer) {
		return tabbedPane.getComponent(tabnummer).getName();
	}

	private void setChatValue(String verlauf) {
		textPaneChat.setText(verlauf);
	}

	private void setTabName(int tabnummer, String teilnehmer) {
		tabbedPane.getComponentAt(tabnummer).setName(teilnehmer);
	}
	private void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	private String inputBox(String infoMessage, String titleBar){
        return JOptionPane.showInputDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
