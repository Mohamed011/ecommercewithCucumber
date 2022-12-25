@SmokeScnario
Feature: Feature to test add different products to shopping card in Nop Commerce web application

  @SmokeTest
  Scenario: SC9- Logged user could add different products to Shopping cart
    Given   user login correctly
    When    user add one product from Notebooks in computer category to shopping card
    And     user add one product from Shoes in Apparel category to shopping card
    Then    the selected two products should added and appear correctly in shopping card