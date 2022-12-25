#this automation script created by shady ahmed
@SmokeScnario
Feature: Feature to test login functionality to Nop Commerce web application

  @SmokeTest
  Scenario: SC2- User could log in with valid email and password
    Given   user is in login page
    When    user add valid username and password and click login button
    Then    user navigate to home page
#    And     user add invalid username and password
#            | standard_user1   | secret_sauce |
#    Then    user will not navigate to home page