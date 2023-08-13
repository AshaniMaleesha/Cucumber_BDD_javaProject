Feature: Swag Labs Login

Scenario: Successful login with valid credentials
 
 Given the user is on the login page
 When the user enters valid username "standard_user" and valid password "secret_sauce"
 And the user clicks the login button
 Then the user should be redirected to the dashboard
 Then close browser
 
 Scenario Outline: Successful login with valid credentials
 
 Given the user is on the login page
 When the user enters valid username "<username>" and valid password "<password>"
 And the user clicks the login button
 Then the user should be redirected to the dashboard
 Then close browser
 
 Examples:
 |username|password|
 |standard_user|secret_sauce|
 
 Scenario Outline: unsuccessful login with invalid credentials
 Given the user is on the login page
 When When the user enters invalid username "<username>" and valid password "<password>"
 And the user clicks the login button
 Then the user should be displayed error message
 Then close browser
 
 Examples:
 |username|password|
 |locked_out_user|secret_sauce|
 