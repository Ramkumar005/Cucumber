package steps_CommerceStore;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;
import io.cucumber.java.en.Given;

public class HomePage extends Base {

	@Given("Click Shop now")
	public void clickShopNow() throws IOException {
		try {
			WebElement shopNow = driver.findElement(By.xpath("(//a[text()='Shop now'])[1]"));
			driver.executeScript("arguments[0].click();", shopNow);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
