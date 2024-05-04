package stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exceptions.BrowserNotFoundException;
import org.example.pages.HerokuAlertsPage;
import org.example.pages.HerokuOptionPage;
import org.example.util.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.html.Option;
import java.util.List;

public class HerokuOptionStepDef {
    WebDriver webDriver;

    HerokuOptionPage herokuOptionPage;

    @Before
    public void setUp() throws BrowserNotFoundException {
        webDriver = WebDriverSingleton.getDriver("Chrome");
        herokuOptionPage = new HerokuOptionPage(webDriver);
    }


    @Given("I am on Heroku Options Page")
    public void iAmOnHerokuOptionsPage() {
        herokuOptionPage.launch();
    }

    @When("I click the Options and store it")
    public void iClickTheOptionsAndStoreIt() {
        herokuOptionPage.selectDropDown();
    }


    @Then("I verify all the options")
    public void iVerifyAllTheOptions() {
        herokuOptionPage.selectDropDown();

    }
}



