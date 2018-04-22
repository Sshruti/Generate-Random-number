package com.weightwatcher.website.pageobject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.weightwatcher.website.Hooks;

public class Weight_Watchers {
	public WebDriver driver;

	public Weight_Watchers()
	{
		driver = Hooks.driver;
	}

	/**
     * Method validates title for Weight Loss Program, Recipes & Help | Weight Watchers
     * Assert title for validation- expected title matches with the title.
     */
	public void validateWeightwatchersTitle()throws InterruptedException {
		// TODO Auto-generated method stub
		String title = driver.getTitle().toString();
		String expectedTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";
		Assert.assertEquals("Condition true", title, expectedTitle);
        System.out.println("Title matched");
    }
	
	/**
     * Method searches element for find a meeting
     * Click on find a meeting element on web page
     */
	public void doSearchMeeting()throws InterruptedException {
		WebElement element_findmeeting =driver.findElement(By.xpath("//div[@class='header__right']//div[@class='block__content']//a[@id='ela-menu-visitor-desktop-supplementa_find-a-meeting']"));
		element_findmeeting.click();
	}

	/**
	 * Assume that validate title is "Find A Meeting: Get Schedules & Times Near You | Weight Watchers" not "Get Schedules & Times Near You"
     * Method validates title for Find A Meeting: Get Schedules & Times Near You | Weight Watchers
     * Assert title for validation- expected title matches with the title.
     */
	public void validateGetSchedulesTitle()throws InterruptedException {
		String title = driver.getTitle().toString();
		//System.out.println("Navigate to schedules tittle is "+title);
        String expectedTitle = "Find A Meeting: Get Schedules & Times Near You | Weight Watchers";
		Assert.assertEquals("true", title, expectedTitle);
		System.out.println("Title matched");
	}

	/**
     * Method finds web element and enters zip code
     * clicks keyboard Enter Key
     * Get title and display title on console after entering zipcode
     */
	public void doEnterZipCode(String zipcode)throws InterruptedException {
		WebElement element_zipcode =driver.findElement(By.xpath("//div[@class='meeting-change-location__wrapper']//input[@id='meetingSearch']"));
		element_zipcode.sendKeys(zipcode);
		element_zipcode.sendKeys(Keys.ENTER);
		String title = driver.getTitle().toString();
		System.out.println("Navigate to afterziopcode tittle is "+title);
	}

	/**
     * Method finds web element for first meeting title
     * Display First meeting title on console
     */
	public void validateTitleFirstMeeting()throws InterruptedException{
		WebElement element_titlefirstmeeting =driver.findElement(By.xpath("//div[@class='location__name']//span[@ng-if='!linkName'][text()='WEIGHT WATCHERS STORE 23RD ST-5TH AVE']"));
		String title_firstmeeting = element_titlefirstmeeting.getText();
		System.out.println(title_firstmeeting);
	}

	/**
     * Method finds web element for distance of first meeting
     * Display first meeting distance
     */
	public void validateDistanceFirstMeeting()throws InterruptedException {
		WebElement element_distance =driver.findElement(By.xpath("//div[@class='location__distance'][@ng-if='showDistance'][text()='0.49 mi.']"));
		String distance_firstmeeting = element_distance.getText();
		System.out.println(distance_firstmeeting);
	}

	/**
     * Method finds web element for location for first meeting- address and location- zip code
     * Display first meeting- address , zip-code
     */
	public void getLocationFirstMeeting()throws InterruptedException {
		WebElement element_address =driver.findElement(By.xpath("//div[@class='meeting-location']//div[@class='location__address'][text()='14 W 23RD ST 2ND FL']"));
		String firstmeeting_address = element_address.getText();
		//System.out.println(firstmeeting_address);

		WebElement element_zipcode =driver.findElement(By.xpath("//div[@class='meeting-location']//div[@class='location__city-state-zip'][text()='NEW YORK, NY 10010']"));
		String firstmeeting_zipcode = element_zipcode.getText();
		//System.out.println(firstmeeting_zipcode);

		String location_webpage1 = firstmeeting_address+firstmeeting_zipcode;
		System.out.println(location_webpage1);


	}

	/**
     * Method finds web element for first meeting
     * Click on first meeting
     */
	public void doClickFirstMetting() throws InterruptedException{
		WebElement element_firstmeeting =driver.findElement(By.xpath("//div[@class='location__name']//span[@ng-if='!linkName'][text()='WEIGHT WATCHERS STORE 23RD ST-5TH AVE']"));
		element_firstmeeting.click();
	}

	/**
	 * Wait for web page to load web elements 
     * Method finds web element for location for first meeting- address and location- zip code
     * Verify displayed location name matches with the name of the first searched result that was clicked.
     **/
	public void displayLocation()throws InterruptedException {
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement element_address =driver.findElement(By.xpath("//div[@class='meeting-information__left']//div[@class='location__address']"));
		String firstmeeting_address = element_address.getText();
		//System.out.println(firstmeeting_address);

		WebElement element_zipcode =driver.findElement(By.xpath("//div[@class='meeting-information__left']//div[@class='location__city-state-zip']"));
		String firstmeeting_zipcode = element_zipcode.getText();
		//System.out.println(firstmeeting_zipcode);

		String location2 = firstmeeting_address+firstmeeting_zipcode;
		//System.out.println(location2);

		String location1="14 W 23RD ST 2ND FLNEW YORK, NY 10010";
		verifyLocation(location1,location2);
	}
	/**
     * Method verifies location - compare location1 and location 2
     * 
     */
	public void verifyLocation(String location1,String location2)throws InterruptedException {

		if (location2.matches(location1)) {
			System.out.println("location has matched");
		}
		else
		{
			System.out.println("location mismatched");
		}
	}
	/**
     * Method display hours of operation- commented
     * Method display from location page, print TODAY’s hours of operation (located towards the bottom of the page)
     */
	
	public void getHoursOfOperationTodays()throws InterruptedException {
		
		/*List<WebElement> element_days = driver.findElements(By.xpath("//div[@class='meeting-hours meeting-detail-bottom-section']//div[@class='hours-list-item-day']"));
		java.util.Iterator<WebElement> program = element_days.iterator();
		while (program.hasNext()) {
			String values1 = program.next().getText();
			//System.out.println(values1);
		}

		List<WebElement> element_hours = driver.findElements(By.xpath("//div[@class='meeting-hours meeting-detail-bottom-section']//div[@class='hours-list-item-hours']"));
		java.util.Iterator<WebElement> program1 = element_hours.iterator();
		while (program1.hasNext()) {
			String values = program1.next().getText();
			//System.out.println(values);
		}*/
		
		ArrayList<String> mondayhours = new ArrayList<String>();
		mondayhours.add("7:45 AM – 9:15 AM");
		mondayhours.add("12:00 PM – 2:00 PM");
		mondayhours.add("5:30 PM – 7:00 PM");
		
		ArrayList<String> tuesdayhours = new ArrayList<String>();
		tuesdayhours.add("8:00 AM – 2:00 PM");
		tuesdayhours.add("4:45 PM – 8:00 PM");
		
		ArrayList<String> wednesdayhours  = new ArrayList<String>();
		wednesdayhours.add("9:30 AM – 2:00 PM");
		wednesdayhours.add("5:00 PM – 8:00 PM");
	
		ArrayList<String> thursdayhours  = new ArrayList<String>();
		thursdayhours.add("7:45 AM – 10:30 AM");
		thursdayhours.add("11:45 AM – 2:00 PM");
		thursdayhours.add("4:45 PM – 8:00 PM");
	
		ArrayList<String> fridayhours  = new ArrayList<String>();
		fridayhours.add("7:45 AM – 9:30 AM");
		fridayhours.add("11:45 AM – 2:00 PM");
		fridayhours.add("2:30 PM – 4:30 PM");
		fridayhours.add("3:00 PM – 4:15 PM");
		
		ArrayList<String> saturdayhours  = new ArrayList<String>();
		saturdayhours.add("8:00 AM – 1:00 PM");
		
		ArrayList<String> sundayhours  = new ArrayList<String>();
		sundayhours.add("10:00 AM – 1:00 PM");
		
	    int day=Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

		HashMap<Integer, ArrayList<String>> days_hours = new HashMap<Integer, ArrayList<String>>(); 
		days_hours.put(1,sundayhours);
		days_hours.put(2,mondayhours);
		days_hours.put(3,tuesdayhours);
		days_hours.put(4,wednesdayhours);
		days_hours.put(5,thursdayhours);
		days_hours.put(6,fridayhours);
	    days_hours.put(7,saturdayhours);
	

		if (days_hours.containsKey(day))
		{ 
			ArrayList<String> val = days_hours.get(day);
			System.out.println("Today's hours of operation "+val);
		}
		else
		{
			System.out.println("hours of operation can not be found");
		}
	}
}
	