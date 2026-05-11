package GauravBansal;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import gauravbansal.pageobjects.LandingPage;
import gauravbansal.pageobjects.ProductCatalogue;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		String product = "ZARA COAT 3";
		String expectedValue = "Thankyou for the order.";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LandingPage landingPage = new LandingPage(driver); // this driver will pass to LandingPage class

		landingPage.goTo();
		landingPage.loginApplication("gau123@gmail.com", "abc123@XYZ");
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver); // this driver will pass to ProductCatalogue class
		
		List<WebElement> allproductsname = productCatalogue.getProductList();

		productCatalogue.getProductByName();

		System.out.println(driver.findElement(By.id("toast-container")).getText());
		
		System.out.println(driver.findElement(By.xpath("//div[@class=\"cartSection\"]/h3")).getText());

		List<WebElement> allproductsincart = driver.findElements(By.xpath("//div[@class=\"cartSection\"]/h3"));

		for (int j = 0; j < allproductsincart.size(); j++) {
			if (allproductsincart.get(j).getText().equals(product)) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}

		driver.findElement(By.xpath("//li[@class=\"totalRow\"]/button")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("india");

		List<WebElement> allcountry = driver.findElements(By.xpath("//span[@class=\"ng-star-inserted\"]"));
		{
			for (int k = 0; k < allcountry.size(); k++)

			{
				if (allcountry.get(k).getText().equals("India")) {
					System.out.println(allcountry.get(k).getText());
					allcountry.get(k).click();
					break;
				}
			}
		}

		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
		String realValue = driver.findElement(By.xpath("//h1[@class=\"hero-primary\"]")).getText();
		Assert.assertTrue(realValue.equalsIgnoreCase(expectedValue));

		driver.close();
	}
}