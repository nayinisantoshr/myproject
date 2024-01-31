package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.DriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        plugin = {
                "report.adapter.ExtentCucumberAdapter:"},
        glue = {"stepdefinations"},dryRun = false, tags = "@test")

public class RunTest {
    @BeforeClass
    public static void before(){
        DriverFactory.invokeDriver("Chrome");
    }

    @AfterClass
    public static void tearDown(){
        DriverFactory.getCurrentDriver().quit();
}

}
