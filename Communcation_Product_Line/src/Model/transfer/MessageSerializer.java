package Model.transfer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Model.Message;

public class MessageSerializer {
	
	@SuppressWarnings("unchecked")
	public static <T extends Message> void pipeMessage(T message) {
		try {
			ObjectOutputStream messageStoragePipeOutputStream = new ObjectOutputStream(
					new FileOutputStream("messagepipe.bin"));
			List<T> messagesToWrite = (null != loadMessagesFromPipe()) ? (ArrayList<T>) loadMessagesFromPipe()
					: new ArrayList<T>();
			messagesToWrite.add(message);
			messageStoragePipeOutputStream.writeObject(messagesToWrite);
			messageStoragePipeOutputStream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new RuntimeException("Could not pipe message.");
		}
	}

	@SuppressWarnings("unchecked")
	public static List<? extends Message> loadMessagesFromPipe() {
		ObjectInputStream messageStoragePipeObjectInputStream = null;
		try {
			FileInputStream messageStoragePipeFileInputStream = new FileInputStream(
					"messagepipe.bin");
			messageStoragePipeObjectInputStream = new ObjectInputStream(
					messageStoragePipeFileInputStream);
			return (List<? extends Message>) messageStoragePipeObjectInputStream
					.readObject();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} finally {
			try {
				messageStoragePipeObjectInputStream.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				throw new RuntimeException("Could not load piped messages. (messageStoragePipeObjectInputStrem was null)");
			}
		}
		throw new RuntimeException("Could not load piped messages.");
	}
}
