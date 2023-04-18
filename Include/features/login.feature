Feature: Feature Login Logout

  Scenario: Login with correct credential
    Given User already open swag lab website
    When User input fields username with correct credential "standard_user"
    And User input fields password with corret credential "secret_sauce"
    And User click login button
    Then User susccesfully login account
	
	
	Scenario: User want logout from account
		Given