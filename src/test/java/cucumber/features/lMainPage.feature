Feature: Loading Main Page
  Scenario: user can log in to the system

    Given an open browser with kpfu.ru
    When  click on the button to open the login form
    And   enter a login in input field
    And   enter a password in input field
    And   click login button
    Then  the personal account page be shown