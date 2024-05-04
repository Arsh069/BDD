Feature: Validating multiple Websites

  Scenario:Validate Amazon Checkbox
    Given I open the Amazon Page URL
    When I give the "Headphones" in SearchBox
    And I scroll down the Page
    And I click the Brands and select "Sony" Brand Checkbox
    Then I verify the "Results" Text
    And I switch Heroku page tab

  Scenario: Validate Heroku Dynamic Content
    Given I am already on Heroku Dynamic Page URL with Header "Dynamic Content"
    Then I fetch the text content and refresh the Heroku Page And Validate
    And I navigate to Google Page

  Scenario: Switching Between Tabs
    Given I am already on Google Page
    When I search for "Selenium" in Search box
    Then I open the first URL in search page on new Window
    And I navigate back to old search results window
    And I navigate to new Tab


  Scenario: Sorting Products
    Given I navigate to Amazon Page on a new Tab
    When I search for "Laptop" in search box
    And I sort the results by price High to Low
    Then I store the prices for first ten Products
    And I sort the list in Ascending Order
    And I navigate to Heroku table Page


  Scenario: Fetching Table
    Given I am already on Heroku Table Page
    When I fetch table details
    Then I validate Smith John jsmith@gmail.com $50.00 http://www.jsmith.com edit delete


  Scenario: Alerts Validation
    Given I am on Heroku Alerts Page
    When I Click on the JS Alerts Button
    And I click on Click JS Confirm Button
    And I click on Click JS Prompt Button
    Then I verify the Results for JS Prompt Button


  Scenario: Options Validation
    Given I am on Heroku Options Page
    When I click the Options and store it
    Then I verify all the options
