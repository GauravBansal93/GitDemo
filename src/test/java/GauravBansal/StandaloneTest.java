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

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		String product = "ZARA COAT 3";
		String expectedValue = "Thankyou for the order.";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		System.out.println(driver.getTitle());
		System.out.println("Git testing1");
		System.out.println("Git testing2");
		System.out.println("Git testing3");
		System.out.println("Git testing4");
		System.out.println("Git testing5");
		
		System.out.println("Git develop branch 1");
		System.out.println("Git develop branch 2");
		
		LandingPage landingPage = new LandingPage(driver); //this driver will pass to LandingPage class
		
		driver.findElement(By.id("userEmail")).sendKeys("gau123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("abc123@XYZ");
		driver.findElement(By.id("login")).click();

		// driver.findElement(By.xpath("//*[text()='ZARA COAT
		// 3']/parent::h5/parent::div/button[2]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"card-body\"]/h5/b")));

		List<WebElement> allproductsname = driver.findElements(By.xpath("//div[@class=\"card-body\"]/h5/b"));

		for (int i = 0; i < allproductsname.size(); i++)

		{
			// System.out.println(allproductsname.get(i).getText());
			if (allproductsname.get(i).getText().equals("ZARA COAT 3")) {
				System.out.println(allproductsname.get(i).getText());
				driver.findElements(By.xpath("//div[@class=\"card-body\"]/button[2]")).get(i).click();
				break;
			}

		}

		WebElement messageAfterProductAddedtoCart = driver.findElement(By.id("toast-container"));

		wait.until(ExpectedConditions.visibilityOf(messageAfterProductAddedtoCart));

		System.out.println(driver.findElement(By.id("toast-container")).getText());

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class=\".ng-animating\"]")));
		driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();

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