package com.amazon.testSuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "nav-logo-sprites")
    WebElement amazonLogo;

    @FindBy(id = "twotabsearchtextbox")
    WebElement inputSearch;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.navigate().to(url);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageDisplayed() {
        return elementIsDisplayed(amazonLogo, 10);
    }

    public ResultsPage searchProduct(String product) {
        runProductSearch(product, inputSearch);

        return PageFactory.initElements(driver, ResultsPage.class);
    }


}
