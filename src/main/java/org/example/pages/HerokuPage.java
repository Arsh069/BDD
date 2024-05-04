package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class HerokuPage extends BasePage{

    @FindBy(xpath = "//h3")
    WebElement headerText;

    @FindBy(xpath = "//div[@id='content']/div[1]/div[2]")
    WebElement dynamicText;
    public HerokuPage(WebDriver driver) {
        super(driver);
    }

    public void launch(){
        getDriver().get("https://the-internet.herokuapp.com/dynamic_content");
    }

    public String verifyHeader(){
        return headerText.getText();
    }

    public void refreshHerokuPage(){
        getDriver().navigate().refresh();
    }
    public String validateDynamicContent(){
        String text=dynamicText.getText();
        return text;
    }

    public GooglePage navigateToGooglePage(){
        return new GooglePage(getDriver());
    }
}
