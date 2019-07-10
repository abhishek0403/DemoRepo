Feature: FM Assist

@TechnicalSprint
Scenario: To verify whether the user is able to login with valid credentials

Given Login page for CWOA is opened
When The user enter’ s the valid login credentials
Then User click on the Login button
Then Landing page should be opened successfully


@TechnicalSprint
Scenario: To verif1y whether the user is able to login with invalid credentials

Given Login page for CWOA is opened
When The user enter’ s the invalid login credentials
Then  User click on the Login button
Then Error page should be displayed

@TechnicalSprint
Scenario: To verify whether the user is able to view the work orders in the landing page

Given Login page for CWOA is opened
When The user enter’ s the valid login credentials
Then  User click on the Login button
Then Landing page should be opened successfully
And The user clicks Fetch Info from Verisae button
Then All the work orders are displayed in the landing page
