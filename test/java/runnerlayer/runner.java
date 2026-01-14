package runnerlayer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\java\\featurelayer\\featurea.feature",
glue = "stepdefilayer",
publish = true)
public class runner extends AbstractTestNGCucumberTests {

}
