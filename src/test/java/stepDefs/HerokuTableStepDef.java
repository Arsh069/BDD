package stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exceptions.BrowserNotFoundException;
import org.example.pages.AmazonPage;
import org.example.pages.HerokuTablePage;
import org.example.util.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;



public class HerokuTableStepDef {
    WebDriver webDriver;

    HerokuTablePage herokuTablePage;

    @Before
    public void setUp() throws BrowserNotFoundException {
        webDriver= WebDriverSingleton.getDriver("Chrome");
        herokuTablePage=new HerokuTablePage(webDriver);
    }

    @Given("I am already on Heroku Table Page")
    public void iAmAlreadyOnHerokuTablePage() {
        herokuTablePage.launch();
        Assert.assertEquals(herokuTablePage.getHeader(),"Data Tables");
    }

    @When("I fetch table details")
    public void iFetchTableDetails() {
        herokuTablePage.fetchTables();
    }
    @Then("I validate {}")
    public void iValidate(String data) {
        Assert.assertEquals(herokuTablePage.fetchTables(),data);
    }
}
