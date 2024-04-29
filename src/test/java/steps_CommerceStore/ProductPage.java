package steps_CommerceStore;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Base;
import io.cucumber.java.en.And;

public class ProductPage extends Base {

	@And("Click Products under Hair Products section")
	public void clickHairProduct() throws IOException {
		try {
			WebElement hairProduct = driver
					.findElement(By.xpath("//p[text()='Hair Products']/following::p[text()='Products'][1]"));
			wait.until(ExpectedConditions.visibilityOf(hairProduct));
			hairProduct.click();
			
		} catch (Exception e) {
			
		}

	}

	@And("Click Hair Beauty Bath")
	public void clickHairBeautyBath() throws IOException {
		try {
			driver.findElement(By.xpath("//p[text()='Hair Beauty Bath']")).click();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
