package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavMenu;
import utilities.Buttons;
import utilities.Condition;
import utilities.ParentClass;

import static utilities.ElementClass.$;

public class _08_Positions extends ParentClass {
    @When("^user navigate to Positions page$")
    public void user_navigate_to_Positions_page()  {
      clickOnMenuTo(NavMenu.Positions);
    }

    @Then("^Create a Positions name as \"([^\"]*)\" short name as \"([^\"]*)\"$")
    public void create_a_Positions_name_as_short_name_as(String name, String shortName)  {

        $(DialogInputName).shouldBe(Condition.appear).setValue(name);
        $(DialogInputShortName).setValue(shortName);
        clickToDialogButton(Buttons.Save);
    }

    @Then("^User create a new name as  \"([^\"]*)\" and short name as \"([^\"]*)\"$")
    public void userCreateANewNameAsAndShortNameAs(String name, String shortName) {

        $(DialogInputName).shouldBe(Condition.appear).clear().setValue(name);
        $(DialogInputShortName).clear().setValue(shortName);
        clickToDialogButton(Buttons.Save);
    }



}
