package com.amazon.testSuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver, String url) {
        driver.navigate().to(url);
        PageFactory.initElements(driver, this);
    }
}
