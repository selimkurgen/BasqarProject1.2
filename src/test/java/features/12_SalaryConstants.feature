@Regression @Smoke
Feature: In this feature Salary Constants processes are proceeds

  Scenario: Salary Constant create
    Given user navigate to basqar
    And   user loggin to basqar

    When  user navigate to Salary Constants page
    And Click to add button
    Then create a Salary Constants
      | name      | selim414   |
      | validFrom | 2020-12-10 |
      | key       | s113       |
      | value     | 100        |

    Then  the new input should be created

  Scenario: Salary Constant update

    Given user click to Dashboard
    When  user navigate to Salary Constants page
    Then user edit data name as "selim414"

    Then update a new Salary Constants
      | name      | selim314   |
      | validFrom | 2020-12-11 |
      | key       | s223       |
      | value     | 300        |

    Then  the input should be updated

  Scenario: Salary Constants delete
    Given user click to Dashboard
    When  user navigate to Salary Constants page
    Then  user delete the data name as "selim314"
    Then  the input should be deleted
    And logout