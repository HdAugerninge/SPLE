package control;

import gui.ChatTab;
import gui.Gui;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import control.CommunicationManager.MessageStorageHasChangedCallback;
import Model.Person;
import Model.TextMessage;
import Model.Variance;

/**
 * This class implements the events fired by the GUI component. It controls the
 * basic control flow. Created by Tobias on 25.04.2015.
 */
public class Manager implements MessageStorageHasChangedCallback {

	private CommunicationManager communicationManager;
	private Variance var;
	private Gui gui;
	private Person me;
	@SuppressWarnings("unused")
	private ArrayList<TextMessage> messageStorage;

	public Manager(Gui gui, Person me) {
		var = new Variance();
		this.communicationManager = CommunicationManager.getInstance();
		this.communicationManager
				.setOnMessageStorageHasChangedCallbackListener(this);
		this.gui = gui;
		this.me = me;
	}

	public void sendMessage(TextMessage messageToSend) {
		communicationManager.transferMessage(messageToSend);
	}

	public void showCamera(boolean enabled, JLabel lblCamPartner) {
		if (enabled) {
			lblCamPartner.setVisible(true);
		} else {
			lblCamPartner.setVisible(false);
		}
	}

	public void setChatValue(String verlauf, String avatarname, ChatTab ct) {
		ct.setChat(avatarname + "] " + verlauf);
	}

	public String getInputValue(ChatTab ct) {
		return ct.getInput();
	}

	public void showPeopleList(JFrame peopleFrame, JButton btnConfigNewName,
			JButton btnSend, JButton btnFile, JButton btnVoice,
			JToggleButton tglbtnCam) {
		peopleFrame.setVisible(true);
		// Disables Change Name button
		btnConfigNewName.setEnabled(false);
		btnSend.setEnabled(true);
		btnFile.setEnabled(true);
		btnVoice.setEnabled(true);
		tglbtnCam.setEnabled(true);
	}

	public void showConfig(JFrame configFrame) {
		configFrame.setVisible(true);
	}

	public void showLogin(JFrame loginFrame) {

	}

	@Override
	public void onMessageStorageHasChanged(List<TextMessage> messageStorage) {
		// Do Something with synchronized messages
		System.out.println("onMessageStorageHasChanged called!");

		List<gui.ChatTab> tabs = gui.getChatTabs();

		for(ChatTab tab : tabs) {
			tab.clearChat();
		}
		for (TextMessage m : messageStorage) {
			List<Person> receivers = m.getReceivers();
			if(m.getSender().equals(me)) {
				for (gui.ChatTab t : tabs) {
					if (t.getChatPartners().equals(receivers)) {
						t.setChat(m.getSender() + "] " + m.getMessagePaylaod());
					}
				}
			}
			// suche ob aktueller User Empfänger der Nachricht ist
			System.out.println("Me: " + me.getName());
			if(m.getReceivers().contains(me)) {
				System.out.println("other");
				List<Person> myReceivers = new ArrayList<Person>();
				myReceivers.add(m.getSender());
				List<Person> tempReceivers = new ArrayList<Person>(m.getReceivers());
				tempReceivers.remove(me);
				myReceivers.addAll(myReceivers);
				for (gui.ChatTab t : tabs) {
						System.out.println("Me: " + me.getName() + " them: "+ m.getReceivers().get(0) + " message: " + m.getMessagePaylaod());
						t.setChat(m.getSender() + "] " + m.getMessagePaylaod());
				}
			}	
		}
	}

	// Variantenbinding

	public String getVarante() {
		return var.getVariante();
	}

	public boolean hasConfig() {
		return var.hasConfig();
	}

	public boolean hasCamera() {
		return var.hasCamera();
	}

	public boolean hasSend() {
		return var.hasSend();
	}

	public boolean hasVoice() {
		return var.hasVoice();
	}

	public boolean hasFile() {
		return var.hasFile();
	}

	public boolean hasMultiCast() {
		return var.hasMultiCast();
	}

	public boolean hasConversation() {
		return var.hasConversation();
	}

}
