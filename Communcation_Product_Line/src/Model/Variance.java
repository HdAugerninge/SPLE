package Model;

import Model.security.*;

/**
 * This class has all the functions to determine the variant at variation points
 * Created by Tobias on 25.04.2015.
 */
public class Variance {

	public boolean hasMultiCast() {
		return true;
	}

	public IEncryption getEncryption() {
		// Default Verhalten f�r Encryption
		// TODO: abhängig von config zur�ck geben
		return new DefaultEncryption();
	}

	public boolean hasCamera() {
		return true;
	}

	public boolean hasSend() {
		return true;
	}

	public boolean hasVoice() {
		return true;
	}

	public boolean hasConfig() {
		return true;
	}

	public boolean hasFile() {
		return true;
	}

	public boolean hasConversation() {
		// TODO Auto-generated method stub
		return false;
	}

}
