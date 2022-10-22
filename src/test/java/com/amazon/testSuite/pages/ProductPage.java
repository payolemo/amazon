package com.amazon.testSuite.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(id = "productTitle")
    WebElement productTitle;
    @FindBy(xpath = "//span[@id='buybox-see-all-buying-choices']/parent::span/parent::div")
    WebElement purchaseOptions;
    @FindBy(xpath = "//input[@name='submit.addToCart']/parent::span")
    WebElement addToCart;
    @FindBy(xpath = "//span[@class='ewc-subtotal-amount']/child::span")
    WebElement subtotalAmount;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage(WebDriver driver, String url) {
        super(driver);
        driver.navigate().to(url);

        PageFactory.initElements(driver, this);
    }

    public boolean isPageDisplayed() {
        return elementIsDisplayed(productTitle, 10);
    }

    public void addProductToCart() {
        purchaseOptions.click();
        addToCart.click();
    }

    public ResultsPage navigateBack() {
        driver.navigate().back();
        driver.navigate().back();

        return PageFactory.initElements(driver, ResultsPage.class);
    }

    public void verifyPriceIsBiggerThan(int amount) {
        driver.navigate().back();
        isPageDisplayed();

        //Individually declared for better understanding
        boolean comparativeResult = false;

        double parsedAmount = amountModeler(subtotalAmount.getText());

        if(parsedAmount > amount) {
            comparativeResult = true;
        }
        Assert.assertTrue(comparativeResult);
    }

    public void verifyPriceIsLessThan(int amount) {
        driver.navigate().back();
        isPageDisplayed();

        //Individually declared for better understanding
        boolean comparativeResult = false;

        double parsedAmount = amountModeler(subtotalAmount.getText());

        if(parsedAmount < amount) {
            comparativeResult = true;
        }
        Assert.assertFalse(comparativeResult);
    }
}
