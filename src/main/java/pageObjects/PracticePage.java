package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePage {
	
	
	public WebDriver driver;
	public PracticePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"checkBoxOption1\"]")
	public WebElement checkClick;
	
	public WebElement CheckBoxClick() {
		return checkClick;
	}

}
