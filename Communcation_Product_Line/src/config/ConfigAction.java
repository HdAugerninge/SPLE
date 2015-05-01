package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Class managing the config-file. This class is used to create, update, read
 * and load the cofig file with the given parameters. The config file is needed
 * for the database connection and inside the ManagerAdHoc class
 * 
 * @author Dominik Fischer <dominik.fischer@paluno.uni-due.de>
 *
 */
class ConfigAction {

	private String path;

	public ConfigAction() {
		createProperties();
	}

	public ConfigAction(String pathtoload) {
		// TODO Auto-generated constructor stub
		// path = "./config.properties";
		this.path = pathtoload;
	}

	public ConfigAction(String pathtosave, String driver,
			String connectionstring, String dbuser, String dbpassword,
			String schema, String export) {
		// "./config.properties"
		this.path = pathtosave;
		createProperties(driver, connectionstring, dbuser, dbpassword, schema,
				export);
	}

	/**
	 * Load the propertiesfile from a fixed location in Workspace to identify
	 * relevant information about DB Connection
	 */
	public Object[] loadProperties() {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		InputStream input = null;
		ArrayList<String> a = new ArrayList<String>();

		try {

			input = new FileInputStream(path);

			// load a properties file
			prop.load(input);

			// get the property value and add it to Array
			a.add(prop.getProperty("driver"));
			a.add(prop.getProperty("connectionstring"));
			a.add(prop.getProperty("dbuser"));
			a.add(prop.getProperty("dbpassword"));
			a.add(prop.getProperty("schema"));
			a.add(prop.getProperty("export"));
			a.add(prop.getProperty("path"));

			return a.toArray();

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

	public String getValueForPropertie(String search) {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		InputStream input = null;
		try {

			input = new FileInputStream(path);

			// load a properties file
			prop.load(input);

			// get the property value and add it to Array

			return prop.getProperty(search);

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

	/**
	 * Prints all available Information to Console
	 */
	public void printAllProperties() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(path);
			prop.load(input);

			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				System.out.println("Key : " + key + ", Value : " + value);
			}

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
	}

	/**
	 * Creates the PropertiesFile with fixed Values
	 */
	private void createProperties() {
		Properties prop = new Properties();
		OutputStream output = null;
		path = "./config.properties";

		try {

			output = new FileOutputStream(path);

			// set the properties value
			prop.setProperty("driver", "com.mysql.jdbc.Driver");
			prop.setProperty("connectionstring", "jdbc:mysql://localhost:3306/");
			prop.setProperty("dbuser", "root");
			prop.setProperty("dbpassword", "root");
			prop.setProperty("schema", "Fispace_Gui");
			prop.setProperty("export", "./export.csv");
			prop.setProperty("path", "./config.properties");

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * Creates the PropertiesFile with variable input values
	 */
	private void createProperties(String driver, String connectionstring,
			String dbuser, String dbpassword, String schema, String export) {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream(path);

			// set the properties value
			prop.setProperty("driver", driver);
			prop.setProperty("connectionstring", connectionstring);
			prop.setProperty("dbuser", dbuser);
			prop.setProperty("dbpassword", dbpassword);
			prop.setProperty("schema", schema);
			prop.setProperty("export", export);
			prop.setProperty("path", path);

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
