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

public class GPTdefs {

    WebDriver webDriver;

    AmazonPage amazonPage;

    @Before
    public void setUp() throws BrowserNotFoundException {
        webDriver=WebDriverSingleton.getDriver("Chrome");
        amazonPage=new AmazonPage(webDriver);
    }



    @Given("I open the Amazon Page URL")
    public void iOpenTheAmazonPageURL() {
        amazonPage.launch();
    }

    @When("I give the {string} in SearchBox")
    public void iGiveTheInSearchBox(String search) {
        amazonPage.setSearchBox(search);
    }

    @And("I scroll down the Page")
    public void iScrollDownThePage() {
        amazonPage.scrollPage();
    }

    @And("I click the Brands and select {string} Brand Checkbox")
    public void iClickTheBrandsAndSelectSonyBrandCheckbox(String brand) {
        amazonPage.selectBrand(brand);
    }

    @Then("I verify the {string} Text")
    public void iVerifyTheText(String header) {
        Assert.assertEquals(amazonPage.verifyHeader(),header);
    }

    @And("I switch Heroku page tab")
    public void iSwitchHerokuPageTab() {
        amazonPage.navigateToHerokuTab().launch();
    }


}
