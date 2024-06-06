package logout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogoutFunctionalality 
{
	WebDriver driver ;
	String baseUrl = "https://tutorialsninja.com/demo/index.php?route=account/login";	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyLoggingOut() throws InterruptedException
	{
		driver.navigate().to(baseUrl);

		driver.findElement(By.id("input-email")).sendKeys("testsheik@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("8877");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.xpath("(//a[text()='Logout'])[1]")).click();
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		String expectedTitle="Your Store";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("User got logout successfully and able to navigated homePage");
	}

	@Test(priority = 2)
	public void logoutRightSideColomn() throws InterruptedException
	{
		driver.navigate().to(baseUrl);

		driver.findElement(By.id("input-email")).sendKeys("testsheik@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("8877");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//a[text()='Logout'])[2]")).click();
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		String expectedTitle="Your Store";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Logout Seccessfully");

	}

/*	@Test(priority = 3) 
	public void closeTheBrowserWithoutLogoutAndOpenTheBrowser() throws InterruptedException  //Bug
	{
		driver.navigate().to(baseUrl);

		driver.findElement(By.id("input-email")).sendKeys("testsheik@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("8877");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		driver.close();
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/account");
		
		String expectedTitle1="My Account";
		String actualTitle1=driver.getTitle();
		Assert.assertEquals(expectedTitle1, actualTitle1);
		
		System.out.println("User Still there logedIn");
		
		
	

	}*/

	@Test(priority = 3)
	public void checkLogoutOptionDisplay() throws InterruptedException
	{
		driver.navigate().to(baseUrl);

		driver.findElement(By.id("input-email")).sendKeys("testsheik@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("8877");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		WebElement logoutOption = driver.findElement(By.xpath("(//a[text()='Logout'])[1]"));
		
		Assert.assertTrue(logoutOption.isDisplayed());
		
		System.out.println("Logout Options is Displayed");
		
	}
}

