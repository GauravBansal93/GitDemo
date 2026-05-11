package gauravbansal.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gauravbansal.AbstractComponents.AbstractClass;

public class ProductCatalogue extends AbstractClass {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)  //constructor
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//Above WebElement we can also write using PageFactory
	
	@FindBy(xpath="//div[@class=\"card-body\"]/h5/b") //Qus: How this annotation will know about driver Ans: Using initElements which is mentioned in line 16th
	List<WebElement> allproductsname;
	
	By productsBy = By.xpath("//div[@class=\"card-body\"]/h5/b");
	
	By toastContainer = By.id("toast-container");
	
	By animating = By.xpath("//*[@class=\".ng-animating\"]");
	
	By Cart = By.xpath("//button[@routerlink=\"/dashboard/cart\"]");
	
	@FindBy(xpath="//button[@routerlink=\"/dashboard/cart\"]")
	WebElement cartElement;
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy)	;
		return allproductsname;
	}
	
	public void getProductByName()
	{
		for (int i = 0; i < allproductsname.size(); i++)

		{
			// System.out.println(allproductsname.get(i).getText());
			if (allproductsname.get(i).getText().equals("ZARA COAT 3"))  {
				System.out.println(allproductsname.get(i).getText());
				driver.findElements(By.xpath("//div[@class=\"card-body\"]/button[2]")).get(i).click();
				break;
			}

		}
		
		waitForElementToAppear(toastContainer);
		waitForElementToDisAppear(animating);
		cartElement.click();
		
	}


}
