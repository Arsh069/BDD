package org.example.pages;

import io.cucumber.core.filter.Options;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AmazonPage extends BasePage{

    @FindBy(id="twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id="p_89-title")
    WebElement brands;

    @FindBy(xpath = "//li[@id='p_89/Sony']/span/a/div/label/i")
    WebElement sonyBrand;

    @FindBy(xpath = "//div[@class='s-no-outline']/span[text()='Results']")
    WebElement headerText;


    @FindBy(xpath = "//select[@id='s-result-sort-select']")
    WebElement selectDropDown;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    List<WebElement> price;




    public AmazonPage(WebDriver driver) {
        super(driver);
    }

    public void launch(){
        getDriver().get("https://www.amazon.in/");
    }

    public void newTabLaunch(){
        //actions.sendKeys(Keys.CONTROL).sendKeys("t").perform();
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().get("https://www.amazon.in/");
    }
    public void setSearchBox(String data){
        getWait().until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.click();
        searchBox.sendKeys(data);
        searchBox.sendKeys(Keys.RETURN);
    }

    public void scrollPage(){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void selectBrand(String brand){
        getWait().until(ExpectedConditions.visibilityOf(brands));
        brands.click();
        getWait().until(ExpectedConditions.visibilityOf(sonyBrand));
        sonyBrand.click();

    }

    public String verifyHeader(){
        return headerText.getText();
    }

    public HerokuPage navigateToHerokuTab(){

        getDriver().switchTo().newWindow(WindowType.TAB);

        return new HerokuPage(getDriver());
    }

    public void selectHighToLow(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(selectDropDown));
        Select select=new Select(selectDropDown);
        select.selectByValue("price-asc-rank");

    }

    public List<Double> firstTenProducts(){

        getWait().until(ExpectedConditions.visibilityOfAllElements(price));

        List<Double> prices=new ArrayList<>();
        for(int i=0;i<10;i++){
            prices.add(Double.parseDouble(price.get(i).getText()));
        }
        return prices;
    }

    public HerokuTablePage navigateToTabelPage(){
        return new HerokuTablePage(getDriver());
    }

}
