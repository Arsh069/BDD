package stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exceptions.BrowserNotFoundException;
import org.example.pages.GooglePage;
import org.example.pages.HerokuAlertsPage;
import org.example.util.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AlertsStepDef {

    WebDriver webDriver;

    HerokuAlertsPage herokuAlertsPage;

    @Before
    public void setUp() throws BrowserNotFoundException {
        webDriver= WebDriverSingleton.getDriver("Chrome");
        herokuAlertsPage=new HerokuAlertsPage(webDriver);
    }

    @Given("I am on Heroku Alerts Page")
    public void iAmOnHerokuAlertsPage() {
        herokuAlertsPage.launch();
    }

    @When("I Click on the JS Alerts Button")
    public void iClickOnTheJSAlertsButton() {
        herokuAlertsPage.clickJsAlertsButton();
    }

    @And("I click on Click JS Confirm Button")
    public void iClickOnClickJSConfirmButton() {
        herokuAlertsPage.clickJsConfirmButton();
    }

    @And("I click on Click JS Prompt Button")
    public void iClickOnClickJSPromptButton() {
        herokuAlertsPage.clickJsPromptButton();
    }

    @Then("I verify the Results for JS Prompt Button")
    public void iVerifyTheResultsForJSPromptButton() {
        Assert.assertEquals(herokuAlertsPage.verifyText(),"You entered: Arsh");
    }
}
