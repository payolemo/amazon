Feature: As Amazon user I want to validate if total amount
  is greater or less than ten thousand ten thousand

  Background:
    Given I navigate to Amazon
    When I search for "refrigerator"
    And I select the first Samsung product
    And I add the item to the cart
    And I click to "don't add protection"
    And I go back to the search page
    And I select the first Mabe product
    And I add the item to the cart
    And I click to "don't add protection"

  Scenario: Validate if total amount is bigger than ten thousand
    Then I verify total amount is greater than 10000


  Scenario: Validate if total amount is less than ten thousand
    Then I verify total amount is less than 10000