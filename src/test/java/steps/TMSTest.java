package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature"},
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
)
public class TMSTest extends AbstractTestNGCucumberTests {
}
