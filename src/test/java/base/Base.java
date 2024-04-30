package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utility.ReadExcelData;

public class Base extends AbstractTestNGCucumberTests {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public String excelFileName, sheetName;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDesc, testAuthor, testCategory;

	public static int ranNum;

	@Parameters({ "Browser", "URL" })
	@BeforeMethod
	public void startApp(String browser, String url) {

		
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");

			driver = new ChromeDriver(option);
		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		// reporter.setAppendExisting(true); // Previous History
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void assignTestDetails() {
		test = extent.createTest(testName, testDesc);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
	}

	public static int getRandomNum(int min, int max) {

		// Create an instance of Random class
		Random random = new Random();
		ranNum = random.nextInt(5) + 4;
		// Get Year
		int num = random.nextInt(max - min) + min;

		return num;

	}

	// Method to generate a random number of a given length
	public static int generateRandomNumber(int length) {
		Random random = new Random();
		int minBound = (int) Math.pow(10, length - 1);
		int maxBound = (int) Math.pow(10, length) - 1;
		return random.nextInt(maxBound - minBound + 1) + minBound;
	}

	public int takeSnap() throws IOException {
		int ranNum = (int) (Math.random() * 99999 + 99999);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/img" + ranNum + ".jpg");
		FileUtils.copyFile(src, dest);
		return ranNum;

	}

	public void reportStep(String msg, String status) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			test.pass(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".jpg").build());
		} else if (status.equalsIgnoreCase("fail")) {
			test.fail(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".jpg").build());
			throw new RuntimeException("View the Reports for more details");
		}

	}

	@AfterSuite
	public void stopReport() {
		extent.flush();

	}

	@AfterMethod
	public void closeBrowser() throws IOException {
		try {
			driver.close();
		} finally {
		//	Runtime.getRuntime().exec("taskill /f /im chromedriver.exe");
		}
	}

}
