package runner;

import org.testng.annotations.BeforeTest;

import base.Base;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features_commerceStore/Purchase_Product.feature", glue = "steps_CommerceStore", monochrome = true, publish = true)

public class Runner_CommerceStore extends Base {

	@BeforeTest
	public void setValues() {
		testName = "Hair Beauty Product";
		testDesc = "Verify order id of Hair Beauty Product";
		testAuthor = "Ram";
		testCategory = "regression";

	}

}
