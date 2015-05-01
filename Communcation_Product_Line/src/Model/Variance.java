package Model;

import config.Config;
import Model.security.*;

/**
 * This class has all the functions to determine the variant at variation points
 * Created by Tobias on 25.04.2015.
 */
public class Variance {

	private Config config;
	
	public Variance(){
		config = Config.getInstance();
	}
	
	//variance binding:
	public boolean hasMultiCast() {
		return (boolean)config.getBinding("multicast");
	}

	public IEncryption getEncryption() {
		String encryption = (String) config.getBinding("encryption");
		switch(encryption){
			case "default":	  return new DefaultEncryption();
			case "Caesarian": return new CaesarianEncryption();
		}
		return new DefaultEncryption();
	}

	public boolean hasCamera() {
		return (boolean)config.getBinding("camera");
	}
	
	public boolean hasAuthentification() {
		return (boolean)config.getBinding("authentification");
	}

	public boolean hasHistory() {
		return (boolean)config.getBinding("history");
	}

	
	
	
	
	//optionale (und nicht genutzte) variance points
	public boolean hasSend() {
		return true;
	}

	public boolean hasVoice() {
		return true;
	}
	
	public boolean hasFile() {
		return true;
	}

	public boolean hasConfig() {
		return true;
	}

	public boolean hasConversation() {
		// TODO Auto-generated method stub
		return true;
	}

}
