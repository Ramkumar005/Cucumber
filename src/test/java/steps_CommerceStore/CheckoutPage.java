package steps_CommerceStore;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CheckoutPage extends Base {

	@And("Click the Shipping Method dropdown and select {string}")
	public void selectShippingMethod(String dd) throws IOException {
		try {
			driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
			WebElement shippingMethod = driver
					.findElement(By.xpath("//p[contains(text(),'Shipping method')]/following::select"));
			Select select = new Select(shippingMethod);
			select.selectByVisibleText(dd);
			
		} catch (Exception e) {
			System.out.println(e);		}

	}

	@When("Click Make payment")
	public void clickMakePayment() throws IOException {
		try {
			driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
			driver.findElement(By.xpath("//button[text()='Make payment']")).click();
		} catch (Exception e) {
			System.out.println(e);		}

	}

}
