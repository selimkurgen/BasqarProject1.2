@Regression @Smoke
Feature: Salary Types functionality

  Scenario: Salary Types create
    Given user navigate to basqar
    And   user loggin to basqar
    When  user navigate to Salary Types  page
    And Click to add button
    Then Create a Salary Type name as "selim14" and User Type as "Student"
    Then  the new input should be created


  Scenario: Salary Types update
    Given user click to Dashboard
    When  user navigate to Salary Types  page
    Then user edit data name as "selim14"
    Then create  a  new Salary Type name as  "ali12" save
    Then  the input should be updated


  Scenario: Salary Types delete
    Given user click to Dashboard
    When  user navigate to Salary Types  page
    Then  user delete the data name as "ali12"
    Then  the input should be deleted
    And logout