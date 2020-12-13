@Regression @Smoke
Feature:Positions functionality

  Scenario: Position create
    Given user navigate to basqar
    And   user loggin to basqar
    When user navigate to Positions page
    And Click to add button
    Then Create a Positions name as "doctor209" short name as "dr209"
    Then  the new input should be created

  Scenario: Position update
    Given user click to Dashboard
    When user navigate to Positions page
    Then user edit data name as "doctor209"
    Then User create a new name as  "teacher209" and short name as "tch209"
    Then  the input should be updated

  Scenario: Position delete
    Given user click to Dashboard
    When user navigate to Positions page
    Then  user delete the data name as "teacher209"
    Then  the input should be deleted
    And logout