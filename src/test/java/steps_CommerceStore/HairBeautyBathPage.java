package steps_CommerceStore;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Base;
import io.cucumber.java.en.And;

public class HairBeautyBathPage extends Base {

	@And("Click Add to cart")
	public void clickAddToCart() throws IOException {
		try {
			WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add to cart']"));
			wait.until(ExpectedConditions.visibilityOf(addToCart));
			addToCart.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@And("Verify Cart Count")
	public void verifyCartCount() throws IOException {
		try {
			WebElement cartCount = driver.findElement(By.xpath("//div[text()='1'][contains(@class,'cart-count')]"));
			wait.until(ExpectedConditions.visibilityOf(cartCount));
		} catch (Exception e) {
			System.out.println(e);		}

	}

	@And("Click Cart")
	public void clickCart() throws IOException {
		try {
			driver.findElement(By.xpath("//div[@class='cart-animation']")).click();
		} catch (Exception e) {
			System.out.println(e);		}

	}

}
