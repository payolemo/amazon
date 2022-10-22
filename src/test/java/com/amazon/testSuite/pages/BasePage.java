package com.amazon.testSuite.pages;

import com.amazon.utilities.PageUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected boolean elementIsDisplayed(WebElement element, int secs) {
        return PageUtilities.waitForElementVisibility(driver, element, secs);
    }

    public void runProductSearch(String productName, WebElement element){
        element.sendKeys(productName, Keys.ENTER);
    }

    public WebElement productFinder(String brand, WebElement element) {
        WebElement productOfNeededBranch = null;
        List<WebElement> results = element.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        for (WebElement product : results) {
            productOfNeededBranch = product.findElement(By.xpath("//div[@data-component-type='s-search-result']//span[contains(text(), '" + brand + "')]"));
        }
        return productOfNeededBranch;
    }

    public double amountModeler(String amountInTextFormat) {
        String amountWithValidChars = amountInTextFormat.replaceAll("(?<=\\d),(?=\\d)|\\$", "");

        return Double.parseDouble(amountWithValidChars);
    }

}
