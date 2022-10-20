package com.amazon;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageFactory.BaseDriver;
import pageFactory.Configurations;
import pageFactory.DriverFactory;

public class GlobalHooks {

    private String scenarioName;

    public void tearUp(Scenario scenario, BaseDriver baseDriver){
        scenarioName = scenario.getName();
        Configurations.getBrowserName();
        baseDriver.driver = DriverFactory.driverBuilder(Configurations.getBrowserName());
        baseDriver.driver.manage().window().maximize();
        System.out.println("Testing Scenario: " + scenarioName);
    }

    public void tearDown(Scenario scenario, BaseDriver baseDriver){
        if (scenario.isFailed()) {
            byte[] screenshot = getScreenshot(baseDriver);
            scenario.attach(screenshot, "image/png", "Failed in scenario: " + scenarioName);
        }

        System.out.println("Test Case: " + scenarioName);
        System.out.println("Browser: " + Configurations.getBrowserName());
        System.out.println("Status: " + scenario.getStatus());

        baseDriver.driver.quit();
    }

    private byte[] getScreenshot(BaseDriver baseDriver){
        return ((TakesScreenshot) baseDriver.driver).getScreenshotAs(OutputType.BYTES);
    }
}
