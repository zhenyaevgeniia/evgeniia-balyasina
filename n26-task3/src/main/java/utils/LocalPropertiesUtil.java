package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class LocalPropertiesUtil {

	private static final Logger LOG = LoggerFactory.getLogger(LocalPropertiesUtil.class);
	private static final String LOCAL_PROPERTIES = "conf/local.properties";
	private Properties properties = new Properties();
	private static LocalPropertiesUtil instance = null;

	private LocalPropertiesUtil() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(LOCAL_PROPERTIES);
		if (inputStream != null) {
			properties.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + LOCAL_PROPERTIES + "' not found in the classpath");
		}
	}

	public static LocalPropertiesUtil getInstance() {
		if(instance == null) {
			try {
				instance = new LocalPropertiesUtil();
			} catch (IOException e) {
				LOG.info("Can't create LocalPropertiesUtil instance!\n" + e.getMessage());
			}
		}
		return instance;
	}

	public String getStringProperty(String propertyName) {
		if(properties.containsKey(propertyName)) {
			return properties.getProperty(propertyName);
		}
		throw new IllegalStateException("Cannot load String property with name " + propertyName);
	}

	public int getIntProperty(String propertyName) {
		if(properties.containsKey(propertyName)) {
			return Integer.parseInt(properties.getProperty(propertyName));
		}
		throw new IllegalStateException("Cannot load int property with name " + propertyName);
	}

	public boolean getBooleanProperty(String propertyName) {
		if(properties.containsKey(propertyName)) {
			return Boolean.parseBoolean(properties.getProperty(propertyName));
		}
		throw new IllegalStateException("Cannot load boolean property with name " + propertyName);
	}


}
