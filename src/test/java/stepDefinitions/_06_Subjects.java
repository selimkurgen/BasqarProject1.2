package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavMenu;
import utilities.Buttons;
import utilities.Condition;
import utilities.ParentClass;

import static utilities.ElementClass.$;

public class _06_Subjects extends ParentClass {

    @When("^user navigate to Subjects page$")
    public void user_navigate_to_Subjects_page() {
      clickOnMenuTo(NavMenu.Subjects);
    }

    @Then("^user create a Subjects name as \"([^\"]*)\" and code as \"([^\"]*)\" and select category and style$")
    public void userCreateASubjectsNameAsAndCodeAsAndSelectCategoryAndStyle(String name, String code) {

        $(DialogInputName).shouldBe(Condition.appear).setValue(name);
        $(DialogInputCode).setValue(code);
        $(DialogFormSubjectCategorySelect).selectOptionWithIndex(4);
        $(DialogFormStyleSelect).selectOptionWithIndex(3);
        clickToDialogButton(Buttons.Save);

    }


    @Then("^user create a new Subjects name as \"([^\"]*)\" and code as \"([^\"]*)\" and save and select name as \"([^\"]*)\" and style$")
    public void userCreateANewSubjectsNameAsAndCodeAsAndSaveAndSelectNameAsAndStyle(String name, String code, String category) {

        $(DialogInputName).shouldBe(Condition.appear).setValue(name);
        $(DialogInputCode).setValue(code);
        $(DialogFormSubjectCategorySelect).selectOptionWithText(category);
        $(DialogFormStyleSelect).selectOptionWithIndex(3);
        clickToDialogButton(Buttons.Save);
    }
}
