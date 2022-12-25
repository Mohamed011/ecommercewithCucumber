@SmokeScnario
Feature: Feature to test registration functionality to Nop Commerce web application

  @SmokeTest
  Scenario: SC1- User could register with valid data
    Given   user is in main page
    When    user choose register tap
    And     fill all data and click register button
    Then    user navigate to user page