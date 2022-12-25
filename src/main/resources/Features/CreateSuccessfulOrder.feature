@SmokeScnario
Feature: Feature to Create Successful Order in Nop Commerce web application

  @SmokeTest
  Scenario: SC12- Create successful Order
    Given   user login Successfully to Nop Commerce App
    When    user click go to card button and complete checkout
    Then    order should created successfully