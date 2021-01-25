package pageObjects;
#Heel
#hello
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Practice']")
	public WebElement PracticePageClick;
	
	
	public WebElement PracticeButton() {
		return PracticePageClick;
	}
	
	
	
}
