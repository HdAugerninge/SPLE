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
		return  Boolean.valueOf(config.getBinding("multicast").toString());
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
		return  Boolean.valueOf(config.getBinding("camera").toString());
	}
	
	public boolean hasAuthentification() {
		return  Boolean.valueOf(config.getBinding("athentification").toString());
	}

	public boolean hasHistory() {
		return  Boolean.valueOf(config.getBinding("history").toString());
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
