package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavMenu;
import utilities.Buttons;
import utilities.Condition;
import utilities.ParentClass;

import static utilities.ElementClass.$;

public class _10_ExcelTemplate extends ParentClass {
    @When("^user navigate to Excel Template page$")
    public void user_navigate_to_Excel_Template_page() {
        clickOnMenuTo(NavMenu.ExcelTemplate);
    }

    @Then("^Create a Excel Template name as \"([^\"]*)\" period count as \"([^\"]*)\" and save$")
    public void create_a_Excel_Template_name_as_period_count_as_and_save(String name, String count) {
        $(DialogInputName).shouldBe(Condition.appear).setValue(name);
        $(DialogFormPeriodCountInput).setValue(count);
        clickToDialogButton(Buttons.Save);


    }

    @Then("^create versions row size as\"([^\"]*)\" and column size as \"([^\"]*)\" and save and close$")
    public void create_versions_row_size_as_and_column_size_as_and_save_and_close(String row, String column)  {
        $(DialogFormRowSizeCountInput).shouldBe(Condition.appear).setValue(row);
        $(DialogFormColumnSizeCountInput).setValue(column);
        clickToDialogButton(Buttons.Save);
        $(DialogContainerButtonClose).click();
    }

    @Then("^create a new Excel Template name as \"([^\"]*)\" and period count as \"([^\"]*)\" and save$")
    public void createANewExcelTemplateNameAsAndPeriodCountAsAndSave(String name, String count)  {

        $(DialogInputName).shouldBe(Condition.appear).clear().setValue(name);
        $(DialogFormPeriodCountInput).clear().setValue(count);
        clickToDialogButton(Buttons.Save);
        $(DialogContainerButtonClose).click();
    }


}
