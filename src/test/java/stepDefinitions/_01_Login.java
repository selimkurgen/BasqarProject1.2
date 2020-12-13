package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageModels.NavMenu;
import utilities.*;

import static utilities.ElementClass.$;
import static utilities.ElementsClass.$$;


public class _01_Login extends ParentClass {
    @Given("^user navigate to basqar$")
    public void userNavigateToBasqar() {
        getHomePage();
    }

    @When("^user loggin to basqar$")
    public void userLogginToBasqar() {
        login();
    }

    @Then("^login should be successfull$")
    public void loginShouldBeSuccessfull() {
        Assert.assertTrue($$(DashBoard).getElements().size()>0);
    }

    @Then("^the new input should be created$")
    public void theNewInputShouldBeCreated() {
        verifyNotificationAs(NotificationResults.created);
    }

    @Then("^the input should be updated$")
    public void theInputShouldBeUpdated() {
        verifyNotificationAs(NotificationResults.updated);
    }

    @Then("^the input should be deleted$")
    public void theInputShouldBeDeleted() {
        verifyNotificationAs(NotificationResults.deleted);
    }

    @Then("^the new input should not be created$")
    public void theNewInputShouldNotBeCreated() {
        clickToDialogButton(Buttons.Close);
        verifyNotificationAs(NotificationResults.Error);
    }
    @Then("^the input should not be deleted$")
    public void theInputShouldNotBeDeleted() {
        verifyNotificationAs(NotificationResults.Error);
    }
    @When("^user click to Dashboard$")
    public void userClickToDashboard() {
        clickOnMenuTo(NavMenu.Dashboard);
    }

    @When("^Click to add button$")
    public void click_to_add_button()  {
        $(PageButtonAdd).shouldBe(Condition.appear).click();

    }  @Then("^user edit data name as \"([^\"]*)\"$")
    public void userEditDataNameAs(String data) {
        editTableData(data);
    }

    @When("^user delete the data name as \"([^\"]*)\"$")
    public void user_delete_the_data_name_as(String data){
        deleteTableData(data);


    }
    @And("^logout$")
    public void logout() {
        Driver.quitDriver();
    }

}
