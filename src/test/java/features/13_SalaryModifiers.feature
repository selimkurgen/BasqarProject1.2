@Regression @Smoke
Feature: In this feature Salary Modifiers processes are proceeds

  Scenario: Salary Modifiers add, update and delete
    Given user navigate to basqar
    And   user loggin to basqar

    When   user navigate to Salary Modifiers page
    And Click to add button

    Then create a Salary Modifiers
      | description          | desc0213         |
      | variable             | var298           |
      | modifierType         | Employee Tax     |
      | integrationCode      | ic199            |
      | valueType            | Formula          |
      | priority             | 055              |
      | formula              | BASE_SALARY*0.15 |
      | name                 | selim            |
      | formulaVariable      | var99            |
      | modifierVariableType | List             |

    Then  the new input should be created

  Scenario: Salary Modifiers update
    Given user click to Dashboard
    When   user navigate to Salary Modifiers page
    And Click to add button
    Then user update new form
      | description          | desc000178       |
      | variable             | var0178          |
      | modifierType         | Employee Tax     |
      | integrationCode      | ic0078           |
      | valueType            | Formula          |
      | priority             | 007              |
      | formula              | BASE_SALARY*0.15 |
      | name                 | martin           |
      | formulaVariable      | var99            |
      | modifierVariableType | List             |
    Then  the new input should be created

  Scenario: Salary Modifiers  delete
    Given user click to Dashboard
    When   user navigate to Salary Modifiers page

    Then  user delete the data name as "desc0213"
    Then  the input should be deleted
    Then  user delete the data name as "desc000178"
    Then  the input should be deleted
    And logout