package pageFactory;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Objects;

public class Configurations {

    private static final String CHROME_PATH = "chrome.path";
    private static final String CHROME_BIN = "chrome.bin";
    private static final String GECKO_PATH = "gecko.path";
    private static final String GECKO_BIN = "gecko.bin";
    private static final String BROWSER_NAME = "browser.name";
    private static final String URL = "url";

    private static Config config;

    public static void loadConfig() {
        if(Objects.isNull(config)) {
            config = ConfigFactory.load("local.config.properties")
                    .withFallback(ConfigFactory.load("config.properties"));
        }
    }

    public static String getLocalChromeDriverPath() {
        loadConfig();
        return config.getString(CHROME_PATH);
    }

    public static String getChromeDriverBinary() {
        loadConfig();
        return config.getString(CHROME_BIN);
    }

    public static String getLocalGeckoDriverPath() {
        loadConfig();
        return config.getString(GECKO_PATH);
    }

    public static String getFirefoxDriverBinary() {
        loadConfig();
        return config.getString(GECKO_BIN);
    }

    public static String getUrl() {
        loadConfig();
        return config.getString(URL);
    }

    public static Object getBrowserName() {
        loadConfig();
        return config.getString(BROWSER_NAME);
    }
}
