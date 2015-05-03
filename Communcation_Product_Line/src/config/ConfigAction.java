package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

/**
 * Class managing the config-file. This class is used to create, update, read
 * and load the cofig file with the given parameters. The config file is needed
 * for 
 * 
 * @author Dominik Fischer <dominik.fischer@paluno.uni-due.de>
 *
 */
class ConfigAction {

	private String path;

	public ConfigAction(String variant) {
		// TODO Auto-generated constructor stub
		this.path = "config/"+variant+".properties";
	}


	/**
	 * Load the propertiesfile from a fixed location in Workspace to identify
	 * relevant information about DB Connection
	 */
	public HashMap<String,Object> loadProperties() {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		InputStream input = null;
		HashMap<String,Object> map = new HashMap<String,Object>();
		try {

		//	input = new FileInputStream(path);
			input = getClass().getClassLoader().getResourceAsStream(this.path); //damits auch als .jar noch geht
			// load a properties file
			prop.load(input);
			prop.stringPropertyNames();
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while(it.hasNext()){
				String key 	 = (String) it.next();
				Object value = prop.get(key);
				map.put(key, value);
			}
			
			return map;

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}
/*
//	public String getValueForPropertie(String search) {
//		// TODO Auto-generated method stub
//
//		Properties prop = new Properties();
//		InputStream input = null;
//		try {
//
//			input = new FileInputStream(path);
//
//			// load a properties file
//			prop.load(input);
//
//			// get the property value and add it to Array
//
//			return prop.getProperty(search);
//
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		} finally {
//			if (input != null) {
//				try {
//					input.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return null;
//
//	}
//
//	/**
//	 * Prints all available Information to Console
//	 */
//	public void printAllProperties() {
//
//		Properties prop = new Properties();
//		InputStream input = null;
//
//		try {
//
//			input = new FileInputStream(path);
//			prop.load(input);
//
//			Enumeration<?> e = prop.propertyNames();
//			while (e.hasMoreElements()) {
//				String key = (String) e.nextElement();
//				String value = prop.getProperty(key);
//				System.out.println("Key : " + key + ", Value : " + value);
//			}
//
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		} finally {
//			if (input != null) {
//				try {
//					input.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	/**
//	 * Creates the PropertiesFile with fixed Values
//	 */
//	private void createProperties() {
//		Properties prop = new Properties();
//		OutputStream output = null;
//		path = "./config.properties";
//
//		try {
//
//			output = new FileOutputStream(path);
//
//			// set the properties value
//			prop.setProperty("driver", "com.mysql.jdbc.Driver");
//			prop.setProperty("connectionstring", "jdbc:mysql://localhost:3306/");
//			prop.setProperty("dbuser", "root");
//			prop.setProperty("dbpassword", "root");
//			prop.setProperty("schema", "Fispace_Gui");
//			prop.setProperty("export", "./export.csv");
//			prop.setProperty("path", "./config.properties");
//
//			// save properties to project root folder
//			prop.store(output, null);
//
//		} catch (IOException io) {
//			io.printStackTrace();
//		} finally {
//			if (output != null) {
//				try {
//					output.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//
//		}
//	}
//
//	/**
//	 * Creates the PropertiesFile with variable input values
//	 */
//	private void createProperties(String driver, String connectionstring,
//			String dbuser, String dbpassword, String schema, String export) {
//		Properties prop = new Properties();
//		OutputStream output = null;
//
//		try {
//
//			output = new FileOutputStream(path);
//
//			// set the properties value
//			prop.setProperty("driver", driver);
//			prop.setProperty("connectionstring", connectionstring);
//			prop.setProperty("dbuser", dbuser);
//			prop.setProperty("dbpassword", dbpassword);
//			prop.setProperty("schema", schema);
//			prop.setProperty("export", export);
//			prop.setProperty("path", path);
//
//			// save properties to project root folder
//			prop.store(output, null);
//
//		} catch (IOException io) {
//			io.printStackTrace();
//		} finally {
//			if (output != null) {
//				try {
//					output.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//
//		}
//	}
//	


}
