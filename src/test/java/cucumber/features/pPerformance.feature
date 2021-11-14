Feature: Study info browse
  Scenario: user can view information about study in the personal account

    Given the user is logged in
    When  click on the button to open the page with study info
    Then  the study info page be shown