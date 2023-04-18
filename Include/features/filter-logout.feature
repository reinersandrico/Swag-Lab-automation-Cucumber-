Feature: filter category

  Background: 
    Given User already open swag lab website
    When User input fields username with correct credential "standard_user"
    And User input fields password with corret credential "secret_sauce"
    And User click login button

  Scenario Outline: User want filter product
    Given User already on home page
    When User click icon filter dropdown 
    And User choose what kind filter category <filter>
    
    Examples: 
    
    |filter						|
    |name Z-A					|
    |name A-Z					|
  	|price low to high|
  	|price high to low| 
  	
  	Scenario: User want to logout from account
  	Given User already login in account
  	And User already on home page
  	When User click menu bar on the top left corner
  	And User choose logout menu
  	Then User successfully logout
  	
    
