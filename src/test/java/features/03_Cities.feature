@Smoke @Regression
Feature: In this feature Cities processes are proceeds

  Scenario: City create
    Given user navigate to basqar
    And   user loggin to basqar

    When  user navigate to city page
    And Click to add button
    When  user create a city to the country "Turkey" city name is "Antalya"
    Then  the new input should be created

  Scenario: City delete
    Given user click to Dashboard
    And   user navigate to city page
    Then  user delete the data name as "Antalya"
    Then  the input should be deleted
    And logout