@SmokeScnario
Feature: Feature to test password recover functionality to Nop Commerce web application

  @SmokeTest
  Scenario: SC3- User could reset his/her password successfully
    Given   user is in login page and forget password
    When    user choose forget password link and add his email
    Then    Confirmation message should appear to user to check mail