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
import Model.mock.MockResources;

public class Gui {

	public JFrame frame, configFrame, peopleFrame;
	private JTabbedPane tabbedPane;
	private JLabel lblAvatar, lblCamPartner;
	private JButton btnConfigNewName, btnSend, btnFile, btnVoice;
	private JToggleButton tglbtnCam;
	private ImageIcon imgConfig, imgAvatar, imgSend, imgVoice, imgFile, imgCam,
			imgAdd, imgAv1, imgAv2, imgWebcam;
	private Person me;
	private ChatTab currentChatTab;
	private List<ChatTab> listChatTab;
	private String avatarname;
	//private Variance var;
	private String chatTabLabelHelper = "";
	private Manager manager;
	private Box verticalRightBox;

	// TODO getClass().getClassLoader().getResourceAsStream(this.path) for
	// images, damits als jar klappt

	public Gui() {

		imgConfig = new ImageIcon(getClass().getResource("19-gear-icon-16.png"));
		imgAvatar = new ImageIcon(getClass().getResource(
				"avatar-default-icon.png"));
		imgSend = new ImageIcon(getClass().getResource(
				"paper-plane-icon-16.png"));
		imgVoice = new ImageIcon(getClass().getResource("mic-icon-16.png"));
		imgFile = new ImageIcon(getClass().getResource("Download-icon-16.png"));
		imgCam = new ImageIcon(getClass().getResource(
				"App-Facetime-icon-16.png"));
		imgAdd = new ImageIcon(getClass().getResource("Plus-icon-16.png"));
		imgAv1 = new ImageIcon(getClass().getResource("man-icon.png"));
		imgAv2 = new ImageIcon(getClass().getResource("woman-icon.png"));
		imgWebcam = new ImageIcon(getClass().getResource("Webcam.png"));
		listChatTab = new ArrayList<ChatTab>();
		avatarname = "Testuser123";
		manager = new Manager();
		me = new Person(avatarname);
	}

	public void init() {
		initGui();
		initPeopleList();
		initConfig();
		System.out.println("Gui initialized");
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initGui() {
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
		verticalRightBox = Box.createVerticalBox();
		horizontalBox.add(verticalRightBox);

		Box horizontalTopRightBox = Box.createHorizontalBox();
		verticalRightBox.add(horizontalTopRightBox);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						manager.showPeopleList(peopleFrame, btnConfigNewName,
								btnSend, btnFile, btnVoice, tglbtnCam);
					}
				});
			}
		});
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalTopRightBox.add(btnAdd);
		btnAdd.setIcon(imgAdd);
		btnAdd.setVisible(manager.hasConversation());

		JButton btnConfig = new JButton("");
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						manager.showConfig(configFrame);
					}
				});
			}
		});
		btnConfig.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalTopRightBox.add(btnConfig);
		btnConfig.setIcon(imgConfig);
		btnConfig.setVisible(manager.hasConfig());

		lblAvatar = new JLabel("");
		lblAvatar.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalRightBox.add(lblAvatar);
		lblAvatar.setIcon(imgAvatar);

		lblCamPartner = new JLabel("");
		lblCamPartner.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalRightBox.add(lblCamPartner);
		lblCamPartner.setIcon(imgWebcam);
		lblCamPartner.setVisible(false);

		tglbtnCam = new JToggleButton("");
		tglbtnCam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						if (tglbtnCam.isSelected()) {
							manager.setChatValue("Cam übermittlet", avatarname,
									getCurrentChatTab());
							manager.showCamera(true, lblCamPartner);
						} else {
							manager.setChatValue("Cam beendet", avatarname,
									getCurrentChatTab());
							manager.showCamera(false, lblCamPartner);
						}
					}
				});
			}
		});
		tglbtnCam.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalRightBox.add(tglbtnCam);
		tglbtnCam.setIcon(imgCam);
		tglbtnCam.setVisible(manager.hasCamera());
		tglbtnCam.setEnabled(false);
		tglbtnCam
				.setToolTipText("Starten Sie eine Koversation um Kamera zu übermitteln!");
		Box horizontalBottomRightBox = Box.createHorizontalBox();
		verticalRightBox.add(horizontalBottomRightBox);

		btnSend = new JButton("");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextMessage messageToSend = new TextMessage(me, currentChatTab
						.getChatPartners(), manager
						.getInputValue(getCurrentChatTab()));
				manager.sendMessage(messageToSend);
				manager.setChatValue(
						manager.getInputValue(getCurrentChatTab()), avatarname,
						getCurrentChatTab());
			}
		});
		btnSend.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSend.setIcon(imgSend);
		horizontalBottomRightBox.add(btnSend);
		btnSend.setVisible(manager.hasSend());
		btnSend.setEnabled(false);
		btnSend.setToolTipText("Starten Sie eine Koversation um Nachricht zu übermitteln!");

		btnVoice = new JButton("");
		btnVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setChatValue("Voice übermittelt", avatarname,
						getCurrentChatTab());
			}
		});
		btnVoice.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVoice.setIcon(imgVoice);
		horizontalBottomRightBox.add(btnVoice);
		btnVoice.setVisible(manager.hasVoice());
		btnVoice.setEnabled(false);
		btnVoice.setToolTipText("Starten Sie eine Koversation um Sprache zu übermitteln!");

		btnFile = new JButton("");
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setChatValue("File übermittelt", avatarname,
						getCurrentChatTab());
			}
		});
		btnFile.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnFile.setIcon(imgFile);
		horizontalBottomRightBox.add(btnFile);
		btnFile.setVisible(manager.hasFile());
		btnFile.setEnabled(false);
		btnFile.setToolTipText("Starten Sie eine Koversation um Datei zu übermitteln!");

		frame.revalidate();
		// infoBox("Herzlich Willkommen", variante);
	}

	// Helpermethods
	private Integer getSelectedTab() {
		return tabbedPane.getSelectedIndex();
	}

	private ChatTab getCurrentChatTab() {
		return listChatTab.get(getSelectedTab());
	}

	private void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, titleBar,
				JOptionPane.INFORMATION_MESSAGE);
	}

	private String inputBox(String infoMessage, String titleBar) {
		return JOptionPane.showInputDialog(null, infoMessage, titleBar,
				JOptionPane.INFORMATION_MESSAGE);
	}

	// Init Methods for new Windows
	private void initPeopleList() {
		System.out.println("People created");
		peopleFrame = new JFrame();
		peopleFrame.getContentPane().setLayout(null);
		peopleFrame.setBounds(frame.getX() + frame.getWidth() / 2, frame.getY()
				+ frame.getHeight() / 2, 200, 250);
		JList<Person> peopleList = new JList<Person>();
		if (manager.hasMultiCast()) {
			// Decision if conversation can be started with many
			peopleList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		} else {
			// or only one person
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
		fireSelectedPeopleBtn
				.addActionListener((event) -> {
					chatTabLabelHelper = "";
					currentChatTab = new ChatTab(peopleList.getSelectedValuesList(), me);
					listChatTab.add(currentChatTab);
					peopleList.getSelectedValuesList().forEach(
							(person) -> chatTabLabelHelper += person.getName()
									+ ", ");
					tabbedPane.addTab(currentChatTab.getName(), currentChatTab);
					tabbedPane.setSelectedIndex(tabbedPane
							.indexOfComponent(currentChatTab));
					tabbedPane.invalidate();
					tabbedPane.repaint();
					tabbedPane.updateUI();
					peopleFrame.setVisible(false);
					System.out.println("Chat opened with "
							+ currentChatTab.getName());
				});
		peopleFrame.getContentPane().add(fireSelectedPeopleBtn);
		peopleList.setVisible(true);
	}

	private void initConfig() {
		System.out.println("Config created");
		configFrame = new JFrame();
		configFrame.getContentPane().setLayout(null);
		configFrame.setBounds(frame.getX() + frame.getWidth() / 2, frame.getY()
				+ frame.getHeight() / 2, 200, 250);
		JLabel lbl = new JLabel("Configuration");
		lbl.setBounds(0, 0, 100, 10);
		configFrame.getContentPane().add(lbl, BorderLayout.NORTH);
		btnConfigNewName = new JButton("Set new Name");
		btnConfigNewName
				.setToolTipText("Nur änderbar solange keine Konversation gestartet wurde");
		btnConfigNewName.setBounds(0, 175, 200, 50);
		btnConfigNewName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				avatarname = inputBox("Please enter your (new) name",
						"Avatarname");
				me.setName(avatarname);
			}
		});
		configFrame.getContentPane().add(btnConfigNewName, BorderLayout.CENTER);
		JButton btnAvatar1 = new JButton("");
		btnAvatar1.setToolTipText("Ändern Sie ihr Avatarbild");
		configFrame.getContentPane().add(btnAvatar1, BorderLayout.CENTER);
		JButton btnAvatar2 = new JButton("");
		btnAvatar2.setToolTipText("Ändern Sie ihr Avatarbild");
		configFrame.getContentPane().add(btnAvatar2, BorderLayout.CENTER);
		btnAvatar1.setBounds(0, 30, 100, 130);
		btnAvatar1.setIcon(imgAv1);
		btnAvatar1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon temp = (ImageIcon) lblAvatar.getIcon();
				lblAvatar.setIcon(btnAvatar1.getIcon());
				btnAvatar1.setIcon(temp);
			}
		});
		btnAvatar2.setBounds(100, 30, 100, 130);
		btnAvatar2.setIcon(imgAv2);
		btnAvatar2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon temp = (ImageIcon) lblAvatar.getIcon();
				lblAvatar.setIcon(btnAvatar2.getIcon());
				btnAvatar2.setIcon(temp);
			}
		});
		JButton btnVersion = new JButton("Zeige Version");
		configFrame.getContentPane().add(btnVersion, BorderLayout.CENTER);
		btnVersion.setBounds(0, 10, 200, 20);
		btnVersion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infoBox("Sie verwenden die Version: " + manager.getVarante(),
						"Versionsnummer");
			}
		});
	}

	private void initLogin() {
		//TODO
	}

}
