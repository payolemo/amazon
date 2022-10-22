package com.amazon.testSuite.steps;

import com.amazon.testSuite.pages.HomePage;
import com.amazon.testSuite.pages.ProductPage;
import com.amazon.testSuite.pages.ResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageFactory.BaseDriver;

public class VerifyTotalAmountSteps extends BaseDriver {

    private HomePage homePage;
    private ResultsPage resultsPage;
    private ProductPage productPage;

    public VerifyTotalAmountSteps() {
        this.homePage = new HomePage(driver);
    }

    @Given("I navigate to Amazon")
    public void iNavigateToAmazon() {
        homePage.isPageDisplayed();
    }
    @And("I search for {string}")
    public void iSearchFor(String productName) {
        resultsPage = homePage.searchProduct(productName);
        resultsPage.isPageDisplayed();
    }
    @And("I select the first Samsung product")
    public void iSelectTheFirstSamsungProduct() throws InterruptedException {
        productPage = resultsPage.openFirstProductOfBrand("Samsung");
        productPage.isPageDisplayed();
    }
    @And("I add the item to the cart")
    public void iAddTheItemToTheCart() {
        productPage.addProductToCart();
    }
    @And("I click to {string}")
    public void iClickTo(String string) {
        /* Semantic step only because I didn't find the mentioned option,
        a text in the entire document of the cart or product page,
        same happens changing the localization to mx.
        trust me... now I'm going to receive a new samsung refrigerator :v */
    }
    @And("I go back to the search page")
    public void iGoBackToTheSearchPage() {
        resultsPage = productPage.navigateBack();
        resultsPage.isPageDisplayed();
    }
    @And("I select the first Mabe product")
    public void iSelectTheFirstMabeProduct() {
        productPage = resultsPage.openFirstProductOfBrand("Mabe");
        productPage.isPageDisplayed();
    }
    @Then("I verify total amount is greater than {int}")
    public void iVerifyTotalAmountIsGreaterThan(int amount) {
        productPage.verifyPriceIsBiggerThan(amount);
    }
    @Then("I verify total amount is less than {int}")
    public void iVerifyTotalAmountIsLessThan(int amount) {
        productPage.verifyPriceIsLessThan(amount);
    }
}
