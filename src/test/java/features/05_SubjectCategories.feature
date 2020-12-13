@Regression @Smoke
Feature: In this feature Subject Categories processes are proceeds

  Scenario: Subject Categories create
    Given user navigate to basqar
    And   user loggin to basqar

    When  user navigate to Subject Categories page
    And Click to add button
    Then user create a Subject Categories name as "adjective27" and code as "ad27" and save
    Then  the new input should be created

  Scenario: Subject Categories delete
    Then  user delete the data name as "adjective27"
    Then  the input should be deleted
    And logout