package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        tags = ("@positive or @negative"),
        plugin = {
            "pretty",
            "html:target/cucumber-reports/cucumber-pretty.html",
            "json:target/cucumber-reports/CucumberTestReport.json",
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
