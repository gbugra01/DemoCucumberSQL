package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/json-report/cucumber.json",
                "junit:target/resources/features",
      },
        features = "src/test/resources/features",
        glue = {"stepDefinations","hook/Hooks.java"},
       tags = " @DemoPractice1",
        dryRun = true
)

public class Runner extends AbstractTestNGCucumberTests {
}
