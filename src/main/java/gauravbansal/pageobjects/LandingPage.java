package gauravbansal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gauravbansal.AbstractComponents.AbstractClass;

public class LandingPage extends AbstractClass{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)  //constructor
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//Above WebElement we can also write using PageFactory
	
	@FindBy(id="userEmail") //Qus: How this annotation will know about driver Ans: Using initElements which is mentioned in line 16th
	WebElement emailElement;
	
	@FindBy(id="userPassword")
	WebElement passwordElement;
	
	@FindBy(id="login")
	WebElement loginButtonElement;

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	public void loginApplication(String email, String password) {
		emailElement.sendKeys(email);
		passwordElement.sendKeys(password);
		loginButtonElement.click();
	}
}
