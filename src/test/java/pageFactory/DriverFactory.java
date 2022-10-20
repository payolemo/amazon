package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;

public class DriverFactory {

    public static WebDriver driverBuilder(Object browserName) {

        WebDriver driver = null;
        DesiredCapabilities desiredCapabilities;

        switch (browserName.toString()) {
            case "firefox" -> {
                if(Objects.isNull(System.getProperty(FirefoxDriver.Capability.BINARY))){
                    System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY , Configurations.getLocalGeckoDriverPath());
                }
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                firefoxOptions.addArguments("bwsi");
                firefoxOptions.setBinary(Configurations.getFirefoxDriverBinary());
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, firefoxOptions);
                desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                driver = new FirefoxDriver(firefoxOptions);
            }
            case "chrome" -> {
                if(Objects.isNull(System.getProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY))){
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, Configurations.getLocalChromeDriverPath());
                }
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("bwsi");
                chromeOptions.setBinary(Configurations.getChromeDriverBinary());
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                driver = new ChromeDriver(chromeOptions);
            }
        }
        return driver;
    }
}
