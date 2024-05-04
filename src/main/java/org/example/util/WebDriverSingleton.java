package org.example.util;

import org.example.exceptions.BrowserNotFoundException;
import org.openqa.selenium.WebDriver;

/**
 * Utility class for managing WebDriver instances in a thread-safe manner.
 * It ensures that each thread gets its own WebDriver instance.
 */
public class WebDriverSingleton {
    private static final ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();
    public WebDriverSingleton(){

   }

   public static WebDriver getDriver(String browser) throws BrowserNotFoundException {
        WebDriver driver=threadLocal.get();
        if(driver==null){
            driver=WebBrowserFactory.initiateWebdriver(browser);
            threadLocal.set(driver);
        }
        return driver;
   }

   public static void quitDriver(){
        WebDriver driver=threadLocal.get();
        if(driver!=null){
            driver.quit();
            threadLocal.remove();
        }
   }

}
