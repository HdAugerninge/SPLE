package config;

import java.util.Map;
import java.util.Properties;

public class Config {

	private static Config instance;
	private Map<String,Object> properties;
	
	public static String variant;
	
	private Config(){
		properties = new ConfigAction(variant).loadProperties();
	}
	
	
	public static Config getInstance(){
		if(instance==null){
			instance = new Config();
		}
		return instance;
	}
	
	//private 
	
	public Object getBinding(String key){
		Object ret = properties.get(key);
		if(ret == null){
			throw new RuntimeException("there is no information about that variability in the configs");
		}
		return ret;
	}
	
	public String getAllBindings(){
	
		return properties.toString();
	}
}
