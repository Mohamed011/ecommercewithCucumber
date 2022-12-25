@SmokeScnario
Feature: Feature to test add different products to Compare List in Nop Commerce web application

  @SmokeTest
  Scenario: SC11- Logged user could add different products to compare list
    Given   user login Successfully
    When    user add one product from Notebooks in computer category to Compare List
    And     user add one product from Shoes in Apparel category to Compare List
    Then    the selected two products should added and appear correctly