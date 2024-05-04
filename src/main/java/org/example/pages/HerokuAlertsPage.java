package org.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class HerokuAlertsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement JsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement JsConfirmButton;


    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement JsPromptButton;

    @FindBy(xpath = "//p[@id='result']")
    WebElement resultText;

    public HerokuAlertsPage(WebDriver driver) {
        super(driver);
    }

    public void launch(){
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickJsAlertsButton(){
        JsAlertButton.click();
        Alert alert=getDriver().switchTo().alert();
        alert.accept();
    }

    public void clickJsConfirmButton(){
        JsConfirmButton.click();
        Alert alert=getDriver().switchTo().alert();
        alert.dismiss();
    }

    public void clickJsPromptButton(){
        JsPromptButton.click();
        Alert alert=getDriver().switchTo().alert();
        alert.sendKeys("Arsh");
        alert.accept();
    }

    public String verifyText(){
        getWait().until(ExpectedConditions.visibilityOf(resultText));
        return resultText.getText();
    }

}

