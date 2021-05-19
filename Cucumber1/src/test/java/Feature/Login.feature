Feature: Facebook login validation

Scenario: Make sure user is not able to login with valid credentials
Given browser is open
And facebook login page is open
When user enters valid credentials with "vicky_sturd@hotmail.com" and password "Vivek123"
Then user should not be able to login successfully

Scenario: Make sure user is not able to login with valid credentials
Given browser is open
And facebook login page is open
When user enters valid credentials with "vicky_stud@hotmail.com" and password "Vicky123"
Then user should not be able to login successfully