package steps_CommerceStore;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Base;
import io.cucumber.java.en.Then;

public class ConfirmationPage extends Base {

	@Then("Read the order number and print it in console")
	public void verifyOrderNumber() throws IOException {
		try {
			WebElement successMsg = driver.findElement(By.xpath("//h3[contains(text(),'Thank you')]"));
			wait.until(ExpectedConditions.visibilityOf(successMsg));

			String refNo = driver.findElement(By.xpath("//p[contains(text(),'reference:')]")).getText();
			System.out.println(refNo);
			String[] split = refNo.split(":");
			String orderNo = split[1].trim();

			System.out.println("order No :" + orderNo);

		} catch (Exception e) {
			System.out.println(e);		}

	}

}
