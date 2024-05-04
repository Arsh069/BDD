package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GooglePage  extends BasePage {


    @FindBy(className = "lnXdpd")
    WebElement GoogleLogo;

    @FindBy(className = "gLFyf")
    WebElement searchBox;

    @FindBy(linkText = "Selenium")
    WebElement seleniumLink;

    @FindBy(linkText = "Downloads")
    WebElement downloadsLink;

    String oldWindowHandle;
    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void launch(){
        getDriver().get("https://www.google.com/");
    }

    public String verifyHeader(){
        return GoogleLogo.getAttribute("alt");
    }

    public void searchResults(String search){
        getWait().until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(search,Keys.RETURN);
    }

    public void resultInNewWindow(){
        oldWindowHandle=getDriver().getWindowHandle();
        String url=seleniumLink.getAttribute("href");
        getDriver().switchTo().newWindow(WindowType.WINDOW);
        getDriver().get(url);
    }

    public void navigateBackToOldWindow(){
        getDriver().switchTo().window(oldWindowHandle);
    }

    public void navigateToNewTab(){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Actions actions=new Actions(getDriver());
        actions.contextClick(downloadsLink).perform();
        actions.sendKeys("t",Keys.RETURN).perform();
    }

}
