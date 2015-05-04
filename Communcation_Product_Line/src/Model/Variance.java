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
		return  (config.getBinding("multicast").toString().equals("1"));
	}

	public IEncryption getEncryption() {
		String encryption = (String) config.getBinding("encryption");
		switch(encryption){
			case "default":	  return new DefaultEncryption();
			case "Caesarian": return new CaesarianEncryption();
		}
		return new DefaultEncryption();
	}
	
	public String getVariante(){
		return Config.variant;
	}

	public boolean hasCamera() {
		return  (config.getBinding("camera").toString().equals("1") );
	}
	
	public boolean hasAuthentification() {
		return  (config.getBinding("authentification").toString().equals("1"));
	}

	public boolean hasHistory() {
		return  (config.getBinding("history").toString().equals("1"));
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
		return true;
	}
	
	

}
