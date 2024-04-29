package steps_Leaftaps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LoginPage extends Base {

	@And("Launch Url")
	public void launchUrl() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@And("Enter Username {string}")
	public void enterUsername(String userName) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
	}

	@And("Enter Password {string}")
	public void enterPassword(String password) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}

	@When("Click Login")
	public void clickLogin() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@When("Homepage should be displayed")
	public void verifyHomepage() {
		String verifyMsg = driver.findElement(By.xpath("//h2[contains(text(),'Welcome')]")).getText();
		System.out.println("HomePage : " + verifyMsg);
		Assert.assertTrue(verifyMsg.contains("Welcome"));
	}

}
