package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavMenu;
import utilities.Buttons;
import utilities.Condition;
import utilities.ParentClass;

import java.util.Map;

import static utilities.ElementClass.$;

public class _12_SalaryConstants extends ParentClass {
    @When("^user navigate to Salary Constants page$")
    public void user_navigate_to_Salary_Constants_page()
    {
       clickOnMenuTo(NavMenu.SalaryConstants);

    }

    @Then("^create a Salary Constants$")
    public void create_a_Salary_Constants(DataTable dataTable) {
        Map<String, String> salaryCostants=dataTable.asMap(String.class,String.class);
        String name=salaryCostants.get("name");
        String validFrom=salaryCostants.get("validFrom");
        String key=salaryCostants.get("key");
        int value=Integer.parseInt(salaryCostants.get("value"));

        $(salaryConstantsFormNameInput).shouldBe(Condition.appear).setValue(name);
        $(DialogFormValidFormInput).click();
        setCalenderDate(validFrom);
        $(DialogFormKeyInput).shouldBe(Condition.appear).setValue(key);
        $(DialogFormValueIntInput).shouldBe(Condition.appear).setValue(value+"");
        clickToDialogButton(Buttons.Save);



    }

    @Then("^update a new Salary Constants$")
    public void update_a_new_Salary_Constants(DataTable dataTable){
        Map<String, String> salaryCostants=dataTable.asMap(String.class,String.class);
        String name=salaryCostants.get("name");
        String validFrom=salaryCostants.get("validFrom");
        String key=salaryCostants.get("key");
        int value=Integer.parseInt(salaryCostants.get("value"));

        $(salaryConstantsFormNameInput).shouldBe(Condition.appear).clear().setValue(name);
        $(DialogFormValidFormInput).click();
        setCalenderDate(validFrom);
        $(DialogFormKeyInput).shouldBe(Condition.appear).clear().setValue(key);
        $(DialogFormValueIntInput).shouldBe(Condition.appear).clear().setValue(value+"");
        clickToDialogButton(Buttons.Save);
    }




}
