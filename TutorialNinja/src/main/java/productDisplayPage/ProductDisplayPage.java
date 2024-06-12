package productDisplayPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductDisplayPage {
	WebDriver driver;
	String baseUrl = "https://tutorialsninja.com/demo/index.php?route=common/home";

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void checkSearchProductDisplay() throws InterruptedException {
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Imac");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(3000);

		WebElement productImage = driver.findElement(By.xpath("//img[@title='iMac']"));

		if (productImage.isDisplayed()) {
			System.out.println("product image is displayed");
		} else {
			System.out.println("produc image is not displayed");
		}

		WebElement productName = driver.findElement(By.xpath("//a[text()='iMac']"));

		if (productName.isDisplayed()) {
			System.out.println("product name is displayed");
		} else {
			System.out.println("produc name is not displayed");
		}

		WebElement productDescription = driver.findElement(By.xpath("//p[contains(text(),'Just when you')]"));
		System.out.println(productDescription.getText());

		if (productDescription.isDisplayed()) {
			System.out.println("product description is displayed");
		} else {
			System.out.println("produc description is not displayed");
		}

		WebElement productAmountAndTax = driver.findElement(By.xpath("//span[text()='Ex Tax:$100.00']//parent::p"));
		
		if(productAmountAndTax.isDisplayed())
		{
			System.out.println("product Amount And Tax is displayed");
		}
		else
		{
			System.out.println("product Amount And Taxis not displayed");
		}
	}

}
