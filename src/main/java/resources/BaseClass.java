package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	
	
	public WebDriver driver;
	public Properties prop=null;
	
	public WebDriver initialization (WebDriver driver) throws IOException {
		this.driver=driver;
		
		prop=new Properties();
		FileInputStream f=new FileInputStream("C:\\Users\\ME\\eclipse-workspace\\MavenProject\\E2EProjectUdemy\\src\\main\\java\\resources\\data.properties");
		prop.load(f);
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Work2\\chromedriver.exe");
			ChromeOptions op=new ChromeOptions();
			op.addArguments("headless");
			driver= new ChromeDriver(op);
		}else if(browser.equals("firefox")) {
			
		}else if(browser.equals("ie")) {
			
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	public String getScreenshotpath(String testcasename,WebDriver driver) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		
		FileUtils.copyFile(src,new File(destination));
		return "";
	}

}
