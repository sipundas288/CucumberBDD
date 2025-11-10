package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.*;

//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//features = {"C:\\cucumber\\ProjectCu\\Features\\LoginFeature.feature"},
		features = {"C:\\cucumber\\ProjectCu\\Features\\Customers.feature","C:\\cucumber\\ProjectCu\\Features\\LoginFeature.feature"},
		//features = "C:\\cucumber\\ProjectCu\\Features/",
		glue = "StepDefination",
		dryRun = false,
		monochrome=false,
		tags = "@Regression",//scenarios under sanity tag will be executed
		plugin= {"pretty","html:C:\\cucumber\\ProjectCu\\target\\cucumber-reports/reports11.html"}
		)
//plugin= {"pretty","html:C:\\cucumber\\ProjectCu\\target\\cucumber-reports/reports1.html"}
//plugin= {"pretty","json:C:\\cucumber\\ProjectCu\\target\\cucumber-reports/reports1.json"}
public class Run extends AbstractTestNGCucumberTests {
	/*class will be empty*/

}
