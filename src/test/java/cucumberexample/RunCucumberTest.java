package cucumberexample;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-reports"},
                 glue = "cucumberexample",
                 features = "src\\test\\resources\\cucumberexample",
                 monochrome = true)
public class RunCucumberTest {
}
