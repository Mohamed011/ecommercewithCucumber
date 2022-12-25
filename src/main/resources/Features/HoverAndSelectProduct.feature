@SmokeScnario
Feature: Feature to test Hover and Select Product functionality in Nop Commerce web application

  @SmokeTest
  Scenario: SC6- Logged user could select different Categories
    Given   user login to Application
    When    Hover over any category and select subcategory
    Then    the sub category page should appear correctly