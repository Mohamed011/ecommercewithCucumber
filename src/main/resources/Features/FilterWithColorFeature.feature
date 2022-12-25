@SmokeScnario
Feature: Feature to test filter Products with color functionality in Nop Commerce web application

  @SmokeTest
  Scenario: SC7- Logged user could filter with color
    Given   user login to the application
    When    user select subcategory and filter with specific color
    Then    filtered results should appear correctly