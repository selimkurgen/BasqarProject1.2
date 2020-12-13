@Regression @Smoke
Feature: In this feature My Subject processes are proceeds


  Scenario: Subject Categories create
    Given user navigate to basqar
    And   user loggin to basqar

    When  user navigate to Subject Categories page
    And Click to add button
    Then  user create a Subject Categories name as " art505" and code as "a505" and save
    Then  the new input should be created

  Scenario: Subjects create
    Given user click to Dashboard
    When   user navigate to Subjects page
    And Click to add button
    Then user create a new Subjects name as "history505" and code as "his505" and save and select name as "art505" and style
    Then  the new input should be created

  Scenario:Subject Categories delete test
    Given user click to Dashboard
    Then user navigate to Subject Categories page
    Then  user delete the data name as "art505"
    Then  the input should not be deleted

  Scenario: My Subjects delete
    Given user click to Dashboard
    Then   user navigate to Subjects page
    Then  user delete the data name as "history505"
    Then  the input should be deleted

  Scenario: Subject Categories delete
    Given user click to Dashboard
    Then user navigate to Subject Categories page
    Then  user delete the data name as "art505"
    Then  the input should be deleted
    And logout