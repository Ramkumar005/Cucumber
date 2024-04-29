package runner;

import io.cucumber.testng.CucumberOptions;
import steps_Leaftaps.Base;

@CucumberOptions(features = "src/test/java/features/Login.feature", 
                 glue = "stepDef", 
                 monochrome = true, 
                 publish = true)

public class Runner_Leaftaps extends Base {

}
