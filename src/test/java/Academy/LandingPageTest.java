package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LandingPage;
import pageObjects.PracticePage;
import resources.BaseClass;
import resources.ExtentReportNG;

public class LandingPageTest extends BaseClass{

	public WebDriver driver;
	
	public static ExtentReports reports;
	public static ExtentTest test;
	public static Logger Log=LogManager.getLogger(BaseClass.class.getName());
	@BeforeClass
	public void BeforeTestM() throws IOException {
		driver=initialization(driver);
		reports=new ExtentReports(System.getProperty("user.dir")+"\\reports\\ExtentReport.html",true);
		test=reports.startTest("LandingPageTest");
		Log.info("Driver initialised");
		test.log(LogStatus.PASS, "Driver initialised");
		
	}
	@Test
	public void FirstTest() throws IOException {
		
		
		LandingPage po=new LandingPage(driver);
		po.PracticeButton().click();
		test.log(LogStatus.PASS, "Clicked on Practice Button");
		Log.info("Clicked on Practice Button");
		PracticePage pp=new PracticePage(driver);
		pp.CheckBoxClick().click();
		Log.info("Clicked on Checkbox Button");
		test.log(LogStatus.PASS, "Clicked on Checkbox Button");
		
	}
	
	@AfterClass
	public void AfterTest() {
		reports.endTest(test);
		reports.flush();
		driver.close();
		Log.info("Driver closed");
		test.log(LogStatus.PASS, "Driver closed");
	}
}
