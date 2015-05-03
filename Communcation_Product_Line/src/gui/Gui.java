package gui;

//import UltimateGUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.Box;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

import control.Manager;
import Model.Person;
import Model.TextMessage;
import Model.Variance;
import Model.mock.MockResources;

public class Gui {

	public JFrame frame;
	private JTabbedPane tabbedPane;
	private ImageIcon imgConfig, imgAvatar, imgSend, imgVoice, imgFile, imgCam,
			imgAdd;
	private ChatTab currentChatTab;
	private List<ChatTab> listChatTab;
	private String variante, avatarname;
	private Variance var;
	private String chatTabLabelHelper = "";
	private Manager manager;
	
//TODO  getClass().getClassLoader().getResourceAsStream(this.path) for images, damits als jar klappt
	
	public Gui() {
		
		imgConfig = new ImageIcon(getClass().getResource("19-gear-icon-16.png"));
		imgAvatar = new ImageIcon(getClass().getResource("avatar-default-icon.png"));
		imgSend = new ImageIcon(getClass().getResource("paper-plane-icon-16.png"));
		imgVoice = new ImageIcon(getClass().getResource("mic-icon-16.png"));
		imgFile = new ImageIcon(getClass().getResource("Download-icon-16.png"));
		imgCam = new ImageIcon(getClass().getResource("App-Facetime-icon-16.png"));
		imgAdd = new ImageIcon(getClass().getResource("Plus-icon-16.png"));
		listChatTab = new ArrayList<ChatTab>();
		variante = "Hier könnte Ihre Werbung stehen";
		avatarname = "Testuser123";
		var = new Variance();
		manager = new Manager();
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

		// Gesamter Frame fï¿½r EINEN TAB
		Box horizontalBox = Box.createHorizontalBox();
		frame.getContentPane().add(horizontalBox);
		horizontalBox.add(tabbedPane);
		

		// Buttons
		Box verticalRightBox = Box.createVerticalBox();
		horizontalBox.add(verticalRightBox);

		Box horizontalTopRightBox = Box.createHorizontalBox();
		verticalRightBox.add(horizontalTopRightBox);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {					
					@Override
					public void run() {
						showPeopleList();
						//TODO hide all Buttons solange keine Konversation geöffnet ist
					}
				});
			}
		});
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalTopRightBox.add(btnAdd);
		btnAdd.setIcon(imgAdd);
		btnAdd.setVisible(var.hasConversation());

		JButton btnConfig = new JButton("");
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showConfig();
			}
		});
		btnConfig.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalTopRightBox.add(btnConfig);
		btnConfig.setIcon(imgConfig);
		btnConfig.setVisible(var.hasConfig());

		JLabel lblAvatar = new JLabel("");
		lblAvatar.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalRightBox.add(lblAvatar);
		lblAvatar.setIcon(imgAvatar);

		JToggleButton tglbtnCam = new JToggleButton("");
		tglbtnCam.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
					showCamera();
				}
			});
		tglbtnCam.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalRightBox.add(tglbtnCam);
		tglbtnCam.setIcon(imgCam);
		tglbtnCam.setVisible(var.hasCamera());

		Box horizontalBottomRightBox = Box.createHorizontalBox();
		verticalRightBox.add(horizontalBottomRightBox);

		JButton btnSend = new JButton("");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChatValue(getInputValue());
				TextMessage messageToSend = new TextMessage(new Person("Testuser123"), currentChatTab.getChatPartners(), getInputValue());
				manager.sendMessage(messageToSend);
			}
		});
		btnSend.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSend.setIcon(imgSend);
		horizontalBottomRightBox.add(btnSend);
		btnSend.setVisible(var.hasSend());

		JButton btnVoice = new JButton("");
		btnVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChatValue("Voice übermittelt");
			}
		});
		btnVoice.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVoice.setIcon(imgVoice);
		horizontalBottomRightBox.add(btnVoice);
		btnVoice.setVisible(var.hasVoice());

		JButton btnFile = new JButton("");
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChatValue("File übermittelt");
			}
		});
		btnFile.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnFile.setIcon(imgFile);
		horizontalBottomRightBox.add(btnFile);
		btnFile.setVisible(var.hasFile());

		infoBox("Herzlich Willkommen", variante);
	}

	// Helpermethods
	private Integer getSelectedTab() {
		//System.out.println(tabbedPane.getSelectedIndex());
		return tabbedPane.getSelectedIndex();
	}

	private String getInputValue() {
		return listChatTab.get(getSelectedTab()).getInput();
	}

	private void setChatValue(String verlauf) {
//		System.out.println(getSelectedTab());
//		ChatTab temp = listChatTab.get(getSelectedTab());
//		System.out.println(temp.getName());
//		temp.setChat(avatarname + "] " + verlauf);
//		System.out.println(temp.getInput());
		listChatTab.get(getSelectedTab()).setChat(avatarname + "] " + verlauf);
		
	}

	private void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	private String inputBox(String infoMessage, String titleBar){
        return JOptionPane.showInputDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	private void showPeopleList() {
		JFrame peopleFrame = new JFrame();
		peopleFrame.getContentPane().setLayout(null);
		peopleFrame.setBounds(frame.getX() + frame.getWidth() / 2, frame.getY() + frame.getHeight() / 2, 200, 250);
		JList<Person> peopleList = new JList<Person>();
		if(var.hasMultiCast()){
			//Decision if conversation can be started with many
			peopleList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}else{
			//or only one person
			peopleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		peopleList.setLayoutOrientation(JList.VERTICAL_WRAP);
		peopleList.setVisibleRowCount(-1);
		DefaultListModel<Person> listModel = new DefaultListModel<Person>();
		MockResources.PERSONS.forEach((person) -> listModel.addElement(person));
		peopleList.setModel(listModel);
		peopleList.setBounds(0, 0, 200, 150);
		peopleFrame.getContentPane().add(peopleList);
		JButton fireSelectedPeopleBtn = new JButton();
		fireSelectedPeopleBtn.setBounds(0, 175, 200, 50);
		fireSelectedPeopleBtn.setText("Chat starten");
		fireSelectedPeopleBtn.addActionListener((event) -> {
			chatTabLabelHelper = "";
			currentChatTab = new ChatTab(peopleList.getSelectedValuesList());
			listChatTab.add(currentChatTab);
			peopleList.getSelectedValuesList().forEach((person) -> chatTabLabelHelper += person.getName() + ", ");
			tabbedPane.addTab(chatTabLabelHelper.substring(0, chatTabLabelHelper.length() - 2), currentChatTab);
			tabbedPane.setSelectedIndex(tabbedPane.indexOfComponent(currentChatTab));
			tabbedPane.invalidate();
			tabbedPane.repaint();
			tabbedPane.updateUI();
			peopleFrame.setVisible(false);
			System.out.println(currentChatTab.getName());
		});
		peopleFrame.getContentPane().add(fireSelectedPeopleBtn);
		peopleFrame.setVisible(true);
		peopleList.setVisible(true);
		
	}
	
	private void showConfig(){
		JFrame configFrame = new JFrame();
		configFrame.getContentPane().setLayout(null);
		configFrame.setBounds(frame.getX() + frame.getWidth() / 2, frame.getY() + frame.getHeight() / 2, 200, 250);
		//TODO Cofigframe ... Avatarbild ändern Avatarname ändern Plus VErsionsname anzeigen lassen
	}
	
	private void showCamera(){
		//TODO wei bei beiden Personen bild in Camera aufpopt
	}
}
