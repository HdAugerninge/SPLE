package control;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import control.CommunicationManager.MessageStorageHasChangedCallback;
import Model.TextMessage;

/**
 * This class implements the events fired by the GUI component.
 * It controls the basic control flow.
 * Created by Tobias on 25.04.2015.
 */
public class Manager implements MessageStorageHasChangedCallback {

	private CommunicationManager communicationManager;
	private ArrayList<TextMessage> messageStorage;
	public Manager() {
		this.communicationManager = CommunicationManager.getInstance();
		this.communicationManager.setOnMessageStorageHasChangedCallbackListener(this);
	}

    public void singleMessageClicked(Event e){
        // mach den Kram, der geschehen soll, wenn eine einzelnahricht ausgewählt wurde
    	
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
	}

}
