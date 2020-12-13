@Regression @Smoke
Feature: In this feature SomeCountry processes are proceeds

  Scenario: SomeCountry add
    Given user navigate to basqar
    And   user loggin to basqar

    When  user navigate to Country page
    And Click to add button
    And   user add a country "Country46" and code as "Code46"
    Then  the new input should be created

  Scenario: city create
    Given user click to Dashboard
    And   user navigate to city page
    And Click to add button
    When  user create a city to the country "Country46" city name is "Antalya"
    Then  the new input should be created

  Scenario: country delete
    Given user click to Dashboard
    When  user navigate to Country page
    Then  user delete the data name as "Country46"
    Then  the input should not be deleted


  Scenario: city delete
    Given user click to Dashboard
    And   user navigate to city page
    When  user delete the data name as "Antalya"
    Then  the input should be deleted

  Scenario: country delete
    Given user click to Dashboard
    When  user navigate to Country page
    Then  user delete the data name as "Country46"
    Then  the input should be deleted
    And logout