package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HerokuOptionPage extends BasePage{

    @FindBy(id="dropdown")
    WebElement dropDown;

    public HerokuOptionPage(WebDriver driver) {
        super(driver);
    }

    public void launch(){
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().get("http://the-internet.herokuapp.com/dropdown");
    }

    public List<WebElement> selectDropDown(){
        //getWait().until(ExpectedConditions.visibilityOfAllElements(dropDown));
        WebElement webElement = getDriver().findElement(By.id("dropdown"));
        Select select = new Select(webElement);
        List<WebElement> option = select.getOptions();
        for (WebElement element : option) {
            System.out.println(element.getText());
        }

        return option;
    }
}
