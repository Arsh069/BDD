package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HerokuTablePage extends BasePage {

    @FindBy(xpath = "//h3")
    WebElement header;

    @FindBy(xpath="//table[@id='table1']/child::tbody/tr")
    List<WebElement> table;
    public HerokuTablePage(WebDriver driver) {
        super(driver);
    }

    public void launch(){
        getDriver().get("http://the-internet.herokuapp.com/tables");
    }

    public String getHeader(){
        return header.getText();
    }

    public String fetchTables(){
        return table.get(0).getText();
    }



}
