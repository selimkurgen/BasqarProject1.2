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

public class _13_SalaryModifiers extends ParentClass {

    @When("^user navigate to Salary Modifiers page$")
    public void user_navigate_to_Salary_Modifiers_page() {
        clickOnMenuTo(NavMenu.SalaryModifiers);
    }



    @Then("^create a Salary Modifiers$")
    public void create_a_Salary_Modifiers(DataTable dataTable) {
        Map<String, String> salaryModifiers=dataTable.asMap(String.class,String.class);
        String description=salaryModifiers.get("description");
        String variable=salaryModifiers.get("variable");
        String modifierType=salaryModifiers.get("modifierType");
        String integrationCode=salaryModifiers.get("integrationCode");
        String valueType   =salaryModifiers.get("valueType");
        String priority=salaryModifiers.get("priority");
        String formula=salaryModifiers.get("formula");
        String name=salaryModifiers.get("name");
        String formulaVariable =salaryModifiers.get("formulaVariable");
        String modifierVariableType=salaryModifiers.get("modifierVariableType");

        $(PageFormDescriptionInput).shouldBe(Condition.appear).setValue(description);
        $(PageFormVariableInput).setValue(variable);
        $(PageFormModifierTypeSelect).selectOptionWithText(modifierType);
        $(PageFormIntegrationCodeInput).setValue(integrationCode);
        $(PageFormValueTypeSelect).selectOptionWithText(valueType);
        $(PageFormPriorityIntInput).setValue(priority);
        $(PageFormFormulaInput).setValue(formula);
        $(PageButtonAdd).click();
        $(SalaryModifiersNewFormNameInput1).setValue(name);
        $(DialogFormFormulaVariableInput).setValue(formulaVariable);
        $(DialogFormModifierVariableTypeSelect).selectOptionWithText(modifierVariableType);
        clickToDialogButton(Buttons.Apply);
       $(SalaryModifiersFormSaveButton).shouldBe(Condition.clickable).click();

    }


    @Then("^user update new form$")
    public void user_update_new_form(DataTable dataTable) {
        Map<String, String> salaryModifiers=dataTable.asMap(String.class,String.class);
        String description=salaryModifiers.get("description");
        String variable=salaryModifiers.get("variable");
        String modifierType=salaryModifiers.get("modifierType");
        String integrationCode=salaryModifiers.get("integrationCode");
        String valueType   =salaryModifiers.get("valueType");
        String priority=salaryModifiers.get("priority");
        String formula=salaryModifiers.get("formula");
        String name=salaryModifiers.get("name");
        String formulaVariable =salaryModifiers.get("formulaVariable");
        String modifierVariableType=salaryModifiers.get("modifierVariableType");


        $(PageFormDescriptionInput).shouldBe(Condition.appear).setValue(description);
        $(PageFormVariableInput).setValue(variable);
        $(PageFormModifierTypeSelect).selectOptionWithText(modifierType);
        $(PageFormIntegrationCodeInput).setValue(integrationCode);
        $(PageFormValueTypeSelect).selectOptionWithText(valueType);
        $(PageFormPriorityIntInput).setValue(priority);
        $(PageFormFormulaInput).setValue(formula);
        $(PageButtonAdd).click();
        $(SalaryModifiersNewFormNameInput1).setValue(name);
        $(DialogFormFormulaVariableInput).setValue(formulaVariable);
        $(DialogFormModifierVariableTypeSelect).selectOptionWithText(modifierVariableType);
        clickToDialogButton(Buttons.Apply);
        $(SalaryModifiersFormSaveButton).shouldBe(Condition.clickable).click();
    }




}
