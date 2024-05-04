package org.example.util;

import org.example.exceptions.BrowserNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Utility class for initializing a WebDriver based on a given browser type.
 */
public class WebBrowserFactory {
    private WebBrowserFactory(){
    }

    public static WebDriver initiateWebdriver(String browser) throws BrowserNotFoundException {
        return switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            case "firefox" -> new FirefoxDriver();

            default -> throw new BrowserNotFoundException(browser + "Does not exists");
        };
    }

}

