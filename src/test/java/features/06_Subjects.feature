@Regression @Smoke
Feature: In this feature Subjects processes are proceeds

  Scenario: Subjects create
    Given user navigate to basqar
    And   user loggin to basqar

    When   user navigate to Subjects page
    And Click to add button
    Then  user create a Subjects name as "chemistry632" and code as "c632" and select category and style
    Then  the new input should be created

  Scenario: Subjects delete

    Then  user delete the data name as "chemistry632"
    Then  the input should be deleted
    And logout