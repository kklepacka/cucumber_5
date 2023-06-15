Feature: An example

  Scenario: The example
    Given I am on https://www.saucedemo.com/
    When I put my login and password
    And I click on "Login"
    Then I am on inventory page
