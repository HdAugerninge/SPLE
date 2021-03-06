package Model.transfer;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Model.Message;
import Model.TextMessage;

public class MessageSerializer {

	public <T extends Message> void pipeMessages(
			List<? extends Message> messages) {
		try {
			new File(System.getProperty("java.io.tmpdir") + File.separator
					+ "messagepipe.bin").createNewFile();
			ObjectOutputStream messageStoragePipeOutputStream = new ObjectOutputStream(
					new FileOutputStream(System.getProperty("java.io.tmpdir")
							+ File.separator + "messagepipe.bin"));

			messageStoragePipeOutputStream.writeObject(messages);
			messageStoragePipeOutputStream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new RuntimeException("Could not pipe message.");
		}
	}

	@SuppressWarnings("unchecked")
	public List<? extends Message> loadMessagesFromPipe() {
		ObjectInputStream messageStoragePipeObjectInputStream = null;
		try {
			if (!new File(System.getProperty("java.io.tmpdir") + File.separator
					+ "messagepipe.bin").exists()) {
				new File(System.getProperty("java.io.tmpdir") + File.separator
						+ "messagepipe.bin").createNewFile();
			}
			FileInputStream messageStoragePipeFileInputStream = new FileInputStream(
					System.getProperty("java.io.tmpdir") + File.separator
							+ "messagepipe.bin");
			messageStoragePipeObjectInputStream = new ObjectInputStream(
					messageStoragePipeFileInputStream);
			return (List<? extends Message>) messageStoragePipeObjectInputStream
					.readObject();
		} catch (EOFException eofe) {
			pipeMessages(new ArrayList<TextMessage>());
			loadMessagesFromPipe();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} finally {
			try {
				if (null != messageStoragePipeObjectInputStream) {
					messageStoragePipeObjectInputStream.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
				throw new RuntimeException(
						"Could not load piped messages. (messageStoragePipeObjectInputStrem was null)");
			}
		}
		return new ArrayList<TextMessage>();
	}
}
