@Regression @Smoke
Feature:Position Salary functionality


  Scenario: Position Salary create
    Given user navigate to basqar
    And   user loggin to basqar
    When  user navigate to Position Salary page
    And Click to add button
    Then Create a Position Salary name as "selim408"
    Then  the new input should be created

  Scenario: Position Salary update
    Given user click to Dashboard
    When  user navigate to Position Salary page
    Then user edit data name as "selim408"
    Then User create a new name as "selim401"
    Then  the input should be updated

  Scenario: Position Salary delete
    Given user click to Dashboard
    When  user navigate to Position Salary page
    Then  user delete the data name as "selim401"
    Then  the input should be deleted
    And logout