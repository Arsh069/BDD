package stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exceptions.BrowserNotFoundException;
import org.example.pages.AmazonPage;
import org.example.util.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

public class SortProductsStepDef {
    AmazonPage amazonPage;
    WebDriver webDriver;
    @Before
    public void setup() throws BrowserNotFoundException {
        webDriver= WebDriverSingleton.getDriver("Chrome");
        amazonPage=new AmazonPage(webDriver);
    }
    @Given("I navigate to Amazon Page on a new Tab")
    public void iNavigateToAmazonPageOnANewTab() {

        amazonPage.newTabLaunch();
    }

    @When("I search for {string} in search box")
    public void iSearchForInSearchBox(String data) {
        amazonPage.setSearchBox(data);
    }

    @And("I sort the results by price High to Low")
    public void iSortTheResultsByPriceHighToLow() {
        amazonPage.selectHighToLow();
    }

    @Then("I store the prices for first ten Products")
    public void iStoreThePricesForFirstTenProducts() {
        amazonPage.firstTenProducts();
    }

    @And("I sort the list in Ascending Order")
    public void iSortTheListInAscendingOrder() {
        List<Double> beforeSort=amazonPage.firstTenProducts();
        Collections.sort(amazonPage.firstTenProducts());
        Assert.assertEquals(beforeSort,amazonPage.firstTenProducts());
    }
    @And("I navigate to Heroku table Page")
    public void iNavigateToHerokuTablePage() {
        amazonPage.navigateToTabelPage().launch();
    }
}
