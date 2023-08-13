Feature: Swag Labs Login

 Scenario: Successful login with valid credentials
 
 Given the user is on the login page
 When the user enters valid username "user123" and valid password "password123"
 And the user clicks the login button
 Then the user should be redirected to the dashboard
    