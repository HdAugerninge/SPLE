package control;

import gui.Gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import control.CommunicationManager.MessageStorageHasChangedCallback;
import Model.Person;
import Model.TextMessage;

/**
 * This class implements the events fired by the GUI component.
 * It controls the basic control flow.
 * Created by Tobias on 25.04.2015.
 */
public class Manager implements MessageStorageHasChangedCallback {

	private Gui gui;
	private CommunicationManager communicationManager;
	@SuppressWarnings("unused")
	private ArrayList<TextMessage> messageStorage;
	private Person me;
	public Manager() {
		this.communicationManager = CommunicationManager.getInstance();
		this.communicationManager.setOnMessageStorageHasChangedCallbackListener(this);
	}

	public Manager(Gui gui,Person me){
		this();
		this.gui = gui;
		this.me  = me;
	}


    public void editAvaterClicked(Event e){
        //bereite view mit avater auswahl vor
    }

	public void sendMessage(TextMessage messageToSend) {
		communicationManager.transferMessage(messageToSend);		
	}

	@Override
	public void onMessageStorageHasChanged(List<TextMessage> messageStorage) {
		// Do Something with synchronized messages
		System.out.println("onMessageStorageHasChanged called!");
		List<gui.ChatTab> tabs = gui.getChatTabs();
		
		for(TextMessage m: messageStorage){
			List<Person> receivers = m.getReceivers();
			//suche ob aktueller User Empfänger der Nachricht ist
			if(receivers.contains(me)){
				
				//TODO: und nicht bereits angezeigt
				
				//die nachricht soll an diesen tab
				for(gui.ChatTab t : tabs){
					if(t.getChatPartners().equals(receivers)){
						t.setChat(m.getSender()+"] "+m.getMessagePaylaod());
					}
				}
				
			}
		}
		
	
	}

}
