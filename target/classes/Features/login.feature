Feature: Swag Labs Login

 Scenario: Successful login with valid credentials
 
 Given the user is on the login page
 When the user enters valid username "standard_user" and valid password "secret_sauce"
 And the user clicks the login button
 Then the user should be redirected to the dashboard
    