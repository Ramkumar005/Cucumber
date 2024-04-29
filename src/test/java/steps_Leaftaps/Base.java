package steps_Leaftaps;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class Base extends AbstractTestNGCucumberTests {

	public static ChromeDriver driver;

	@BeforeMethod
	public void startBrowser() {
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
