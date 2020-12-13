package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavMenu;
import utilities.Buttons;
import utilities.Condition;
import utilities.ParentClass;

import static utilities.ElementClass.$;

public class _09_PositionSalary extends ParentClass {
    @When("^user navigate to Position Salary page$")
    public void user_navigate_to_Position_Salary_page()  {
       clickOnMenuTo(NavMenu.PositionSalary);
    }

    @Then("^Create a Position Salary name as \"([^\"]*)\"$")
    public void create_a_Position_Salary_name_as(String name)  {

        $(NewPositionSalaryNameInput).shouldBe(Condition.appear).setValue(name);
        clickToDialogButton(Buttons.Save);

    }

    @Then("^User create a new name as \"([^\"]*)\"$")
    public void userCreateANewNameAs(String name){

        $(NewPositionSalaryNameInput).shouldBe(Condition.appear).clear().setValue(name);
        clickToDialogButton(Buttons.Save);

    }



}
