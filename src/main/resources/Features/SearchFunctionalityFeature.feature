@SmokeScnario
Feature: Feature to test search functionality to Nop Commerce web application

  @SmokeTest
  Scenario: SC4- Logged User could search for any product
    Given   user login to nop commerce web application
    When    search for product
    Then    results should appear correctly