package stepDefinitions;

import cucumber.api.java.en.When;
import pageModels.NavMenu;
import utilities.Buttons;
import utilities.ParentClass;

import static utilities.ElementClass.$;

public class _03_Cities extends ParentClass {
    @When("^user navigate to city page$")
    public void user_navigate_to_city_page()  {
       clickOnMenuTo(NavMenu.Cities);
    }

    @When("^user create a city to the country \"([^\"]*)\" city name is \"([^\"]*)\"$")
    public void user_create_a_city_to_the_country_city_name_is(String country, String name) {

        $(DialogFormCountrySelect).selectOptionWithText(country);
        $(DialogInputName).setValue(name);
        clickToDialogButton(Buttons.Save);
    }




}
