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

public class _14_CostCenters extends ParentClass {
    @When("^user navigate to Cost Center$")
    public void user_navigate_to_Cost_Center()  {
       clickOnMenuTo(NavMenu.CostCenters);
    }

    @Then("^create a Cost Center$")
    public void create_a_Cost_Center(DataTable dataTable)  {
        Map<String,String> costCenters=dataTable.asMap(String.class,String.class);
        String name = costCenters.get("name");
        String code = costCenters.get("code");
        String type = costCenters.get("type");
        String orderNo = costCenters.get("orderNo");
        String expenseAccoutCodePrefixes = costCenters.get("expenseAccoutCodePrefixes");
        $(DialogInputName).setValue(name);
        $(DialogInputCode).setValue(code);
        $(DialogFormTypeSelect).selectOptionWithText(type);
        $(DialogFormOrderInput).setValue(orderNo);
        $(DialogFormExpenseAccoutMultiSelect).click().selectOptionWithIndex(3);
        clickToDialogButton(Buttons.Save);
    }



    @Then("^user  edit form$")
    public void user_edit_form(DataTable dataTable) {
        Map<String,String> costCenters=dataTable.asMap(String.class,String.class);
        String name = costCenters.get("name");
        String code = costCenters.get("code");
        String type = costCenters.get("type");
        String orderNo = costCenters.get("orderNo");
        String expenseAccoutCodePrefixes = costCenters.get("expenseAccoutCodePrefixes");

        $(DialogInputName).clear().shouldBe(Condition.appear).setValue(name);
        $(DialogInputCode).clear().setValue(code);
        $(DialogFormTypeSelect).selectOptionWithText(type);
        $(DialogFormOrderInput).clear().setValue(orderNo);
        $(ExpenseAccoutCodePrefixesDelete).click();
        $(DialogFormExpenseAccoutMultiSelect).selectOptionWithIndex(5);
        clickToDialogButton(Buttons.Save);
    }




}
