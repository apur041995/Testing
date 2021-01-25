package resources;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportNG {
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeTest
	public void beforeTest() {
		reports=new ExtentReports(System.getProperty("user.dir")+"\\reports\\ExtentReport.html",true);
		test=reports.startTest("LandingPageTest");
	}
	
	@AfterTest
	public void afterTest() {
		reports.endTest(test);
		reports.flush();
	}

}
