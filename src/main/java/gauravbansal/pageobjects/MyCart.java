package gauravbansal.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gauravbansal.AbstractComponents.AbstractClass;

public class MyCart extends AbstractClass {

	WebDriver driver;

	public MyCart(WebDriver driver) // constructor
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"cartSection\"]/h3") // Qus: How this annotation will know about driver Ans: Using
														// initElements which is mentioned in line 16th
	List<WebElement> allproductsincart;

	public List<WebElement> getallproductsincart() {
		return allproductsincart;
	}

}
