package stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exceptions.BrowserNotFoundException;
import org.example.pages.AmazonPage;
import org.example.pages.GooglePage;
import org.example.util.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleStepDef {
    WebDriver webDriver;

    GooglePage googlePage;

    @Before
    public void setUp() throws BrowserNotFoundException {
        webDriver= WebDriverSingleton.getDriver("Chrome");
        googlePage=new GooglePage(webDriver);
    }
    @Given("I am already on Google Page")
    public void iAmAlreadyOnGooglePage() {
        Assert.assertEquals(googlePage.verifyHeader(),"Google");
    }

    @When("I search for {string} in Search box")
    public void iSearchForInSearchBox(String search) {
        googlePage.searchResults(search);
    }

    @Then("I open the first URL in search page on new Window")
    public void iOpenTheFirstURLInSearchPageOnNewWindow() {
        googlePage.resultInNewWindow();
    }

    @And("I navigate back to old search results window")
    public void iNavigateBackToOldSearchResultsWindow() {
        googlePage.navigateBackToOldWindow();
    }

    @And("I navigate to new Tab")
    public void iNavigateToNewTab() {
        googlePage.navigateToNewTab();
    }
}
