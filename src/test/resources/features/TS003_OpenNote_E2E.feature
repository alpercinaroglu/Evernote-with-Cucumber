Feature: TS003 Open Note E2E Functionality

  @evernote @openBoard @e2e
  Scenario: TC001 Open the Site and Navigate to Login Page
    Given go to "BaseURL"
    When click "Log In" link
    And type login "username" into "username" box
    And click login button
    And type login "password" into "password" box
    And click login button
    Then board should be opened

  @evernote @note @e2e
  Scenario: TC002 Open the Note that Added from File
    Given select "Notes" option on the left panel
    When select the note added from file
    And go to the Editor frame
    Then the note should be opened

  @evernote @logout @e2e
  Scenario: TC003 Logout
    Given go to the main frame
    When open the "Account" menu on the left panel
    And select "Logout" option in the menu
    Then URL should contain "LogoutParam"
    And close browser