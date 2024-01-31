package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.DriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"stepdefinations"},dryRun = false, tags = "@test")


public class RunTest {
    @BeforeClass
    public static void before(){
        if(System.getProperty("browser")==null)
        DriverFactory.invokeDriver("Chrome");
        else
            DriverFactory.invokeDriver(System.getProperty("browser"));
    }

    @AfterClass
    public static void tearDown(){
        DriverFactory.getCurrentDriver().quit();
}

}
