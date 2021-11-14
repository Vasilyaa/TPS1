Feature: Document
  Scenario: documents download

    Given the user is logged in
    When  press the button to open the centre page
    And press the button to open the page with docs
    And press the button to open the page with examples of documents
    And download the document
    Then name must be open in the document