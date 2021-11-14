Feature: Picture upload
  Scenario: user can upload picture

    Given the user is logged in
    When  click on the button to open the page with lk info
    And click on the button to put picture
    Then the picture must be shown