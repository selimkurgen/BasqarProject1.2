package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavMenu;
import utilities.Buttons;
import utilities.Condition;
import utilities.ParentClass;

import static utilities.ElementClass.$;

public class _05_SubjectCategories extends ParentClass {

    @When("^user navigate to Subject Categories page$")
    public void user_navigate_to_Subject_Categories_page() {
        clickOnMenuTo(NavMenu.SubjectCategories);

    }

    @Then("^user create a Subject Categories name as \"([^\"]*)\" and code as \"([^\"]*)\" and save$")
    public void user_create_a_Subject_Categories_name_as_and_code_as_and_save(String name, String code) {
        $(DialogInputName).shouldBe(Condition.appear).setValue(name);
        $(DialogInputCode).setValue(code);
        clickToDialogButton(Buttons.Save);

    }


}
