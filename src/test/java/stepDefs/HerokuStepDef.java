package stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exceptions.BrowserNotFoundException;
import org.example.pages.HerokuPage;
import org.example.util.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HerokuStepDef {
    HerokuPage herokuPage;
    WebDriver webDriver;
    @Before
    public void setup() throws BrowserNotFoundException {
        webDriver= WebDriverSingleton.getDriver("Chrome");
        herokuPage=new HerokuPage(webDriver);
    }

    @Given("I am already on Heroku Dynamic Page URL with Header {string}")
    public void iAmAlreadyOnHerokuDynamicPageURLWithHeader(String header) {
        //herokuPage.launch();
        Assert.assertEquals(herokuPage.verifyHeader(),header);
    }


    @Then("I fetch the text content and refresh the Heroku Page And Validate")
    public void iFetchTheTextContentAndRefreshTheHerokuPageAndValidate() {
        String initial=herokuPage.validateDynamicContent();
        herokuPage.refreshHerokuPage();
        String next=herokuPage.validateDynamicContent();
        Assert.assertNotEquals(initial,next);
    }

    @And("I navigate to Google Page")
    public void iNavigateToGooglePage() {
        herokuPage.navigateToGooglePage().launch();
    }


}
