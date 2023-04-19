Feature: TS002 Write Note E2E Functionality

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
  Scenario: TC002 Write a Note
    Given open the "New" menu on the left panel
    When select "Note" option in the menu
    And go to the Editor frame
    And write note title from file
    And write note body from file
    And go to the main frame
    Then the last note should be saved

  @evernote @logout @e2e
  Scenario: TC003 Logout
    Given open the "Account" menu on the left panel
    When select "Logout" option in the menu
    Then URL should contain "LogoutParam"
    And close browser