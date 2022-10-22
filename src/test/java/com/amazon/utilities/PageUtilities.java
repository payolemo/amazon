package com.amazon.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PageUtilities {
    public static boolean waitForElementVisibility(WebDriver driver, WebElement element, long seconds) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        boolean elementVisible = false;

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(visibilityOf(element));
            elementVisible = true;
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return elementVisible;
    }
}
