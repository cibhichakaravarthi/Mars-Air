package runner;

import org.testng.annotations.Listeners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import util.MyListener;

@Listeners(MyListener.class)
@CucumberOptions(
        tags = "@tw",
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions"},
        monochrome = true,
        publish = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",                                        // Console output
                "html:report/html-report.html", // HTML report
                "json:report/Cucumber.json",    // JSON report
                "junit:report/Cucumber.xml"     // JUnit XML report
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
	
}
