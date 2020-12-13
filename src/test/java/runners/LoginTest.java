package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(

        features = {"src/test/java/features/01_Login.feature"},
        glue = {"stepDefinitions"},
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:" +
                        "target/ExtentReport/LoginTest.html"
        }
)
public class LoginTest extends AbstractTestNGCucumberTests {


    }

