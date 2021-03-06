package com.automation.confighandler;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final static Logger logger = Logger.getLogger(ConfigReader.class);
    private final String DEFAULT_CONFIG_FILE = "webdriver-helper.conf";
    private static ConfigReader configReader = new ConfigReader();
    private Properties properties = new Properties();


    private ConfigReader() {
        init();
    }

    public static ConfigReader getInstance() {
        return configReader;
    }

    public String getConfig(String key) {
        logger.debug("Reading " + key + " from properties");
        return getPreceding(key);
    }

    private String getPreceding(String key) {
        String valueAtEnvVar = getEnvValue(key);
        String valueAtPropertyFile = configReader.properties.getProperty(key);
        if (valueAtEnvVar != null) {
            logger.debug("Environment value for " + key + ": " + valueAtEnvVar);
            return valueAtEnvVar;
        } else if (valueAtPropertyFile != null) {
            logger.debug("Property file value for " + key + ": " + valueAtPropertyFile);
            return valueAtPropertyFile;
        } else {
            logger.debug("Property with key:" + key + " is not available at env or property file");
            return null;
        }
    }

    private static String getEnvValue(String key) {
        logger.debug("Reading " + key + " from environment variable");
        if (System.getenv(key) != null && !System.getenv(key).equals("")) {
            logger.debug("value found in env");
            return System.getenv(key);
        } else if (System.getProperty(key) != null && !System.getProperty(key).equals("")) {
            logger.debug("value found in properties");
            return System.getProperty(key);
        } else {
            logger.debug("No value found for " + key + " in env as well as system properties");
            return null;
        }
    }

    private void init() {
        logger.debug("DEFAULT FILE IS "+ DEFAULT_CONFIG_FILE);
        String configFile = getConfigFile();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(configFile)) {
            properties.load(resourceStream);
            logger.info("Properties has been loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getConfigFile() {
        String webDriverHelperConfig = System.getProperty("WEBDRIVER_HELPER_CONFIG");
        if (webDriverHelperConfig == null) {
            logger.info("No config file were provided. Using default config file : " + DEFAULT_CONFIG_FILE);
            return DEFAULT_CONFIG_FILE;
        }
        logger.info("webdriver-helper is using " + webDriverHelperConfig);
        return webDriverHelperConfig;
    }

}
