package control;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.TextMessage;
import Model.transfer.MessageSerializer;

public class CommunicationManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient MessageSerializer messageSerializer;
	private List<TextMessage> messageStorage;
	private transient Thread workingThread;
	private MessageStorageHasChangedCallback messageStorageHasChangedCallback;
	private int size;
	
	private static CommunicationManager instance = null;

	private CommunicationManager() {
		messageSerializer = new MessageSerializer();
		messageStorage = new ArrayList<TextMessage>();
		size = 0;
		if(!new File(System.getProperty("java.io.tmpdir") + File.separator + "messagepipe.bin").exists()) {
			try {
				new File(System.getProperty("java.io.tmpdir") + File.separator + "messagepipe.bin").createNewFile();
				messageSerializer.pipeMessages(messageStorage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		workingThread = new Thread(new CommunicationManagerWorkingThread());
		workingThread.start();
	}

	public static CommunicationManager getInstance() {
		return (null == instance) ? new CommunicationManager() : instance;
	}
	
	public void setOnMessageStorageHasChangedCallbackListener(MessageStorageHasChangedCallback messageStorageHasChangedCallback) {
		this.messageStorageHasChangedCallback = messageStorageHasChangedCallback;
	}
	
	public void transferMessage(TextMessage messageToSend) {
		messageStorage.add(messageToSend);
		messageSerializer.pipeMessages(messageStorage);
	}

	private class CommunicationManagerWorkingThread implements Runnable {

		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			while(true) {
				System.out.println("Slept.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				messageStorage = (List<TextMessage>) messageSerializer.loadMessagesFromPipe();
				messageStorage.forEach((message) -> System.out.println(message.toString()));
				if(size != messageStorage.size()) {
					messageStorageHasChangedCallback.onMessageStorageHasChanged(messageStorage);
					size = messageStorage.size();
				}
			}
		}
	}
	
	public interface MessageStorageHasChangedCallback {
		public void onMessageStorageHasChanged(List<TextMessage> messageStorage);
	}
}
