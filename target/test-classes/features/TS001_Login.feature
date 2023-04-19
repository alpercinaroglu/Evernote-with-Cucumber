Feature: TS001 Login Functionality

  Background: Open the Site and Navigate to Login Page
    Given go to "BaseURL"
    When click "Log In" link
    Then page URL should be "LoginURL"

  @evernote @login @smoke
  Scenario: TC001 Successful Login
    When type login "username" into "username" box
    And click login button
    And type login "password" into "password" box
    And click login button
    Then board should be opened
    And close browser

  @evernote @login @smoke
  Scenario: TC002 Unsuccessful Login with Wrong Email
    When type login "wrongUsername" into "username" box
    And click login button
    Then error message should be visible
    And close browser

  # More negative scenarios will be added.