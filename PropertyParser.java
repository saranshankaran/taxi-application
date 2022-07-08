package com.taxi.taxi_mobile_automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyParser {

    /**
     * This class contains methods for reading properties files.
     *
     * @author saran
     */
    private Properties properties;

    /**
     * This is constructor
     *
     * @param propertyFilePath
     */
    public PropertyParser(String propertyFilePath) {
        properties = new Properties();
        loadProperties(propertyFilePath);
    }

    // This is Private Constructor
    public PropertyParser() {
    }


    /**
     * This method loads properties file.
     *
     * @param propertyFilePath
     */
    private void loadProperties(String propertyFilePath) {
        File propertyFile = new File(propertyFilePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(propertyFile);
            properties.load(fileInputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * This method returns value from the properties file base on
     * given key.
     *
     * @param key
     * @return
     */
    public String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}



