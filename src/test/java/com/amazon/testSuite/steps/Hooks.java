package com.amazon.testSuite.steps;

import com.amazon.GlobalHooks;
import com.amazon.testSuite.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageFactory.BaseDriver;
import pageFactory.Configurations;

public class Hooks extends BaseDriver {

    private final GlobalHooks globalHooks;
    private final String URL = Configurations.getUrl();
    public static BaseDriver baseDriver;

    public Hooks(BaseDriver driver, GlobalHooks globalHooks){
        this.globalHooks = globalHooks;
        baseDriver = driver;
    }

    @Before(order = 0)
    public void tearUp(Scenario scenario) {
        globalHooks.tearUp(scenario, baseDriver);
    }

    @Before(order = 1)
    public void navigateTo() {
        System.out.println(URL);
        HomePage homePage = new HomePage(driver, URL);
    }

    @After
    public void tearDown(Scenario scenario) {
        globalHooks.tearDown(scenario, baseDriver);
    }

}
