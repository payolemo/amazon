package com.amazon.testSuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage extends BasePage {

    @FindBy(xpath = "//*[@id='search']//span[text()='RESULTADOS']")
    WebElement resultsTitle;
    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']")
    WebElement resultList;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public ResultsPage(WebDriver driver, String url) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageDisplayed() {
        return elementIsDisplayed(resultsTitle, 10);
    }

    public ProductPage openFirstProductOfBrand(String brand){
        productFinder(brand, resultList).click();

        return PageFactory.initElements(driver, ProductPage.class);
    }
}
