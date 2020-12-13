@Regression @Smoke
Feature: In this feature Cost Center processes are proceeds

  Scenario: Cost Center create

    Given user navigate to basqar
    And   user loggin to basqar
    When user navigate to Cost Center
    And Click to add button

    Then create a Cost Center
      | name                      | selim91  |
      | code                      | code119    |
      | type                      | Production |
      | orderNo                   | 11         |
      | expenseAccoutCodePrefixes | 3          |

    Then  the new input should be created

  Scenario: Cost Center update
    Given user click to Dashboard
    When user navigate to Cost Center
    Then user edit data name as "selim91"
    Then user  edit form
      | name                      | selim32 |
      | code                      | code29    |
      | type                      | Service   |
      | orderNo                   | 22        |
      | expenseAccoutCodePrefixes | 5         |

  Scenario: Cost Center
    Given user click to Dashboard
    When user navigate to Cost Center
    Then  user delete the data name as "selim32"
    Then  the input should be deleted
    And logout