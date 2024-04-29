package steps_CommerceStore;

import java.io.IOException;

import org.openqa.selenium.By;

import base.Base;
import io.cucumber.java.en.And;

public class CartPage extends Base {

	@And("Click Checkout")
	public void clickCheckout() throws IOException {
		try {
			driver.findElement(By.xpath("//a[text()='Checkout']")).click();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
