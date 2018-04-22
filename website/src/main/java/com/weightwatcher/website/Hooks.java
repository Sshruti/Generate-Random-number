package com.weightwatcher.website;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
    public static WebDriver driver;
    @Before
    /**
     * Initiate browser
     * Implicit wait for 10 seconds
     * Delete all cookies
     * maximize window
     */
    public void initiateBrowser() throws MalformedURLException {
    	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    }

     
    @After
    /**
     * Quit
     */
    public void closeTest() {
    	driver.quit();
        driver = null;
    }
    
}
