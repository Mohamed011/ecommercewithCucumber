@SmokeScnario
Feature: Feature to test select different tags in Nop Commerce web application

  @SmokeTest
  Scenario: SC8- Logged user could select different tags
    Given   user login to the app
    When    user select hover Computers categories and select Notebooks sub category
    Then    Notebooks page should start correctly
    And     user select hover Apparel categories and select Shoes sub category
    Then    Shoes page should appear correctly