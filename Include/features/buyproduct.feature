Feature: Buy Product

  Background: 
    Given User already open swag lab website
    When User input fields username with correct credential "standard_user"
    And User input fields password with corret credential "secret_sauce"
    And User click login button

  @positive_case
  Scenario: User want to buy one of product in home page
    Given User already on home page
    When User choose random product and click add to cart
    And User click cart list on the top right corner
    And User click checkout button
    And User input first name in the fields
    And User input last name in the fields
    And User input postal code in the fields
    And User click continue button
    And User can see a list of product want to buy
    And User click finish button for to buy product
    Then User successfully buy product

  Scenario Outline: User want to buy one of product in home page from detail product
    Given User already on home page
    When User choose product <product>
    And User click add cart <cart> from details product
    And User click cart list on the top right corner
    And User click checkout button
    And User input first name in the fields <first_name>
    And User input last name in the fields <last_name>
    And User input postal code in the fields <postal_code>
    And User click continue button
    And User can see a list of product want to buy
    And User click finish button for to buy product
    Then User successfully buy product

    Examples:
    |product			|cart			|first_name	|last_name	|postal_code|
    |product1			|product1	|Tomy 			|Sandiego		|123456			|
    |product2			|product2	|random			|random			|random			|
    |product3			|product3	|Tomy 			|random			|123456			|
    |product4			|product4	|random			|Sandiego		|123456			|
    |product5			|product5	|random			|random			|123456			|
    |product6			|product6	|Tomy 			|random			|random			|
   
   
    @negative_case
  Scenario Outline: User checkout goods without information
     Given User already on home page
    When User choose random product and click add to cart
    And User click cart list on the top right corner
    And User click checkout button
    And User input first name in the fields <first_name>
    And User input last name in the fields <last_name>
    And User input postal code in the fields <postal_code>
    And User click continue button
    Then User unsuccessfully buy product and get toast message <warning>
    
    Examples: 
    |first_name  |last_name |postal_code|warning|
    |empty			 |ADA				|0222555		|empty fields first name	|
    |siapa			 |empty			|random			|empty fields last name 	|
    |empty			 |empty			|empty			|empty fields first name  |
    |random			 |random		|empty			|empty fields postal code |
    
    
    Scenario: User checkout without product
    Given User already on home page
    When User click cart list on the top right corner
    And User click checkout button
    And User input first name in the fields
    And User input last name in the fields
    And User input postal code in the fields
    And User click continue button
    And User can see a list of product want to buy
    And User click finish button for to buy product
    #Then User successfully buy product
		    
    