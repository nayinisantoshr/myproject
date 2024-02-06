package runner;

import com.aventstack.extentreports.service.ExtentService;
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


    @AfterClass
    public static void tearDown(){
        DriverFactory.getCurrentDriver().quit();
      
}

}
