Feature: As a Admin user should be able to login


  Scenario: Admin can login with valid credentials
    Given User is able to load the application
    When user has entered user name as "admin@email.com" and password as "admin@123" and click on submit button
    Then User should be able to login
    