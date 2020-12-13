package pages;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.Driver;
import utilities.ParentClass;


public class Hooks extends ParentClass {

    @Before
    public void before(Scenario scenario) {
    }

    @After
    public void after(Scenario scenario) {

        if (scenario.isFailed()) {
            String scenarioName = scenario.getName();
            takeScreenshot(scenarioName);
        }
//        Driver.quitDriver();
    }
}
