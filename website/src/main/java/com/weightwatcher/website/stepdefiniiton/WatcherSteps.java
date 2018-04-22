package com.weightwatcher.website.stepdefiniiton;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;

import com.weightwatcher.website.Enviroment;
import com.weightwatcher.website.Hooks;
import com.weightwatcher.website.pageobject.Weight_Watchers;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Cucumber each test step has mapped with corresponding step definition
 */
public class WatcherSteps {
    public WebDriver driver;
    
    public WatcherSteps()
    {
    	driver = Hooks.driver;
    }
  
    /**
     * Method initiates call to test browser
     */ 
	@Given("^the user navigate to weightwatechers website$")
	public void weightWatcherWebsite() throws InterruptedException,FileNotFoundException{
		driver.get(Enviroment.TEST_URL);
	}
	
	/**
     * Method verifies Weight Loss Program,Recipes & Help Weight Watchers title
     */ 
	@Given("^application verify page loaded'Weight Loss Program,Recipes & Help Weight Watchers'title$")
	public void verifyWeightlossTitle() throws InterruptedException,FileNotFoundException{
		Weight_Watchers weightWatchers = new Weight_Watchers();
		weightWatchers.validateWeightwatchersTitle();
	}
	
	/**
     * Method click on Find a Meeting on web-page
     */ 
	@When("^user click on 'Find a Meeting'$")
	public void findMeeting() throws InterruptedException,FileNotFoundException{
		Weight_Watchers weightWatchers = new Weight_Watchers();
		weightWatchers.doSearchMeeting();
	}
	
	/**
     * Method verifies Get Schedules & Time Near You title
     */ 
	@When("^application verify page loaded 'Get Schedules & Times Near You' title$")
	public void verifyGetSchedulesTitle() throws InterruptedException,FileNotFoundException{
		Weight_Watchers weightWatchers = new Weight_Watchers();
		weightWatchers.validateGetSchedulesTitle();
	}
	
	/**
     * Method initiates to enter zip-code to search field
     */ 
	@When("^user enter (.*) in search field$")
	public void enterZipCode(String zipcode) throws InterruptedException,FileNotFoundException{
		Weight_Watchers weightWatchers = new Weight_Watchers();
		weightWatchers.doEnterZipCode(zipcode);
		Thread.sleep(3000);
	}
	
	/**
     * Method initiates to display title for first result and distance from the meeting
     */
	@Then("^application display title for first result and distance$")
	public void displayFirstMeetingTitileAndDistance() throws InterruptedException,FileNotFoundException{
		Weight_Watchers weightWatchers = new Weight_Watchers();
		weightWatchers.validateTitleFirstMeeting();
		weightWatchers.validateDistanceFirstMeeting();
		
	}
	
	/**
     * Method initiates to display location for first result
     */
	@Then("^application display Loacation for first results$")
	public void getLocationAndNumberOfMettings()throws InterruptedException,FileNotFoundException{
		Weight_Watchers weightWatchers = new Weight_Watchers();
		weightWatchers.getLocationFirstMeeting();
	}
	
	/**
     * Method initiates to click on first result
     */
	@When("^user click on first displayed result$")
	public void clickFirstResult() throws InterruptedException,FileNotFoundException{
		Weight_Watchers weightWatchers = new Weight_Watchers();
		weightWatchers.doClickFirstMetting();
		}
	
	/**
     * Method initiates to display location and verify with the first results clicked
     */
	@When("^application display location of the first result and verified location name$")
	public void displayLocation() throws InterruptedException,FileNotFoundException{
		Weight_Watchers weightWatchers = new Weight_Watchers();
		weightWatchers.displayLocation();
		Thread.sleep(3000);
	}
	
	/**
     * Method initiates to display today's hours of operation
     */
	@When("^application display todays hours of operation from location page$")
	public void displayHoursOperation() throws InterruptedException,FileNotFoundException{
		Weight_Watchers weightWatchers = new Weight_Watchers();
		weightWatchers.getHoursOfOperationTodays();
		Thread.sleep(3000);
	}
	
}
