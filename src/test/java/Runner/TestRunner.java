package Runner;

import io.cucumber.testng.CucumberOptions;
import Tests.TestBase;

@CucumberOptions(features = "src/test/java/features",
        glue = ("Steps"),plugin = {"pretty", "html:target/cucumber-reports"},monochrome = true,dryRun = false
       )
public class TestRunner extends TestBase {



}
