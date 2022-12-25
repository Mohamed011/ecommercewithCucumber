@SmokeScnario
Feature: Feature to test Change Currency functionality to Nop Commerce web application

  @SmokeTest
  Scenario: SC5- Logged User could switch between currencies US-Euro
    Given   user login to nop commerce
    When    change current currency to another
    Then    currency should changed correctly