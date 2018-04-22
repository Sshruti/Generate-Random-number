# Run Selenium Test using cucumber feature file - Run as Cucumber feature

Feature: Schedule, location and timings at weightwatchers.com

  Scenario Outline: Get schedules and time near zipcode 10011 for weightloss program at weightwatchers.com
    Given the user navigate to weightwatechers website
    And application verify page loaded'Weight Loss Program,Recipes & Help Weight Watchers'title
    When user click on 'Find a Meeting'
    And application verify page loaded 'Get Schedules & Times Near You' title
    And user enter <zipcode> in search field
    Then application display title for first result and distance
    And application display Loacation for first results
    When user click on first displayed result
    And application display location of the first result and verified location name
    Then application display todays hours of operation from location page

    Examples: 
      | zipcode |
      |   10011 |
