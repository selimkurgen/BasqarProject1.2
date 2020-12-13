package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageModels.NavMenu;
import utilities.Buttons;
import utilities.Condition;
import utilities.ParentClass;

import static utilities.ElementClass.$;

public class _02_Country extends ParentClass {

    @When("^user navigate to Country page$")
    public void user_navigate_to_Country_page() {

        clickOnMenuTo(NavMenu.Countries);
    }

    @And("^user add a country \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userAddACountryAndCodeAs(String name, String code) {

        $(DialogInputName).shouldBe(Condition.appear).setValue(name);
        $(DialogInputCode).setValue(code);
        clickToDialogButton(Buttons.Save);

    }


}
