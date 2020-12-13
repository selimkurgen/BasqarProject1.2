package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavMenu;
import utilities.Buttons;
import utilities.Condition;
import utilities.ParentClass;

import static utilities.ElementClass.$;

public class _11_SalaryTypes extends ParentClass {
    @When("^user navigate to Salary Types  page$")
    public void user_navigate_to_Salary_Types_page()  {
        clickOnMenuTo(NavMenu.SalaryTypes);
    }

    @Then("^Create a Salary Type name as \"([^\"]*)\" and User Type as \"([^\"]*)\"$")
    public void create_a_Salary_Type_name_as_and_User_Type_as(String name, String type)  {

        $(DialogInputName).shouldBe(Condition.appear).setValue(name);
        $(DialogFormUserTypeMultiSelect).click().selectOptionWithText(type);
        clickToDialogButton(Buttons.Save);
    }


    @Then("^create  a  new Salary Type name as  \"([^\"]*)\" save$")
    public void createANewSalaryTypeNameAsSave(String name) {
        $(DialogInputName).shouldBe(Condition.appear).clear().setValue(name);
        clickToDialogButton(Buttons.Save);
    }




}
