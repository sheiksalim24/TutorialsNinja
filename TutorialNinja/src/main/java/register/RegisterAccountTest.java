package register;

import java.sql.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterAccountTest
{
	@Test(priority = 0)
	public void registerAccountWithMandatoryFields()
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		
		WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccountDropMenu.click();
		
		WebElement registerOption = driver.findElement(By.linkText("Register"));
		registerOption.click();
		
		WebElement firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.sendKeys("Sheik");
		
		WebElement lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.sendKeys("Salim");
		
		
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("1234ba@gmail.com");
		
		WebElement telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.sendKeys("1234567890");
		
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("12345");
		
		WebElement passwordConfirmField = driver.findElement(By.id("input-confirm"));
		passwordConfirmField.sendKeys("12345");
		
		WebElement privacyPolicyField = driver.findElement(By.name("agree"));
		privacyPolicyField.click();
		
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		myAccountDropMenu = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccountDropMenu.click();
		
		WebElement logoutOption = driver.findElement(By.linkText("Logout"));
		
		Assert.assertTrue(logoutOption.isDisplayed());
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/success";
		Assert.assertEquals(actualURL,expectedURL);
		String expectedHeading = "Your Account Has Been Created!";
		WebElement headingElement = driver.findElement(By.xpath("//div[@id='content']/h1"));
		String actualHeading = headingElement.getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		WebElement actualCongradulationsElement = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p"));
		String actualCongradulationsText = actualCongradulationsElement.getText();
		String expectedCongradulationsText = "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(actualCongradulationsText,expectedCongradulationsText);
		WebElement actualmemberPrivilegesElement = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[2]"));
		String actualmemberPrivilegesText = actualmemberPrivilegesElement.getText();
		String expectedmemberPrivilegesText = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		Assert.assertTrue(actualmemberPrivilegesText.contains(expectedmemberPrivilegesText));
		WebElement actualmemberQuestionsElement = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[3]"));
		String actualQuestionsText = actualmemberQuestionsElement.getText();
		String expectedQuestionsText = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		Assert.assertTrue(actualQuestionsText.contains(expectedQuestionsText));
		WebElement actualConfirmationEmailElement = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[4]"));
		String actualConfirmationEmailText = actualConfirmationEmailElement.getText();
		String expectedConfirmationEmailText = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		Assert.assertTrue(actualConfirmationEmailText.contains(expectedConfirmationEmailText));
		WebElement contactUsLinkElement = driver.findElement(By.linkText("contact us"));
		Assert.assertTrue(contactUsLinkElement.isDisplayed());
		
		WebElement continueButtonElement = driver.findElement(By.xpath("//a[text()='Continue']"));
		continueButtonElement.click();
		
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "My Account";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);
	
		driver.quit();
		
	}
	
	@Test(priority = 1)
	public void registerAccounWithAllFields()
	{

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		
		WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccountDropMenu.click();
		
		WebElement registerOption = driver.findElement(By.linkText("Register"));
		registerOption.click();
		
		WebElement firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.sendKeys("Sheik");
		
		WebElement lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.sendKeys("Salim");
		
		
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("12394sa@gmail.com");
		
		WebElement telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.sendKeys("1234567890");
		
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("12345");
		
		WebElement passwordConfirmField = driver.findElement(By.id("input-confirm"));
		passwordConfirmField.sendKeys("12345");
		
		WebElement subscribeButton = driver.findElement(By.xpath("(//input[@name='newsletter'])[1]"));
		subscribeButton.click();
		
		WebElement privacyPolicyField = driver.findElement(By.name("agree"));
		privacyPolicyField.click();
		
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		myAccountDropMenu = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccountDropMenu.click();
		
		WebElement logoutOption = driver.findElement(By.linkText("Logout"));
		
		Assert.assertTrue(logoutOption.isDisplayed());
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/success";
		Assert.assertEquals(actualURL,expectedURL);
		String expectedHeading = "Your Account Has Been Created!";
		WebElement headingElement = driver.findElement(By.xpath("//div[@id='content']/h1"));
		String actualHeading = headingElement.getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		WebElement actualCongradulationsElement = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p"));
		String actualCongradulationsText = actualCongradulationsElement.getText();
		String expectedCongradulationsText = "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(actualCongradulationsText,expectedCongradulationsText);
		WebElement actualmemberPrivilegesElement = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[2]"));
		String actualmemberPrivilegesText = actualmemberPrivilegesElement.getText();
		String expectedmemberPrivilegesText = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		Assert.assertTrue(actualmemberPrivilegesText.contains(expectedmemberPrivilegesText));
		WebElement actualmemberQuestionsElement = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[3]"));
		String actualQuestionsText = actualmemberQuestionsElement.getText();
		String expectedQuestionsText = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		Assert.assertTrue(actualQuestionsText.contains(expectedQuestionsText));
		WebElement actualConfirmationEmailElement = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[4]"));
		String actualConfirmationEmailText = actualConfirmationEmailElement.getText();
		String expectedConfirmationEmailText = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		Assert.assertTrue(actualConfirmationEmailText.contains(expectedConfirmationEmailText));
		WebElement contactUsLinkElement = driver.findElement(By.linkText("contact us"));
		Assert.assertTrue(contactUsLinkElement.isDisplayed());
		
		WebElement continueButtonElement = driver.findElement(By.xpath("//a[text()='Continue']"));
		continueButtonElement.click();
		
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "My Account";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);
	
		driver.quit(); 
		}

	

	
	@Test(priority = 2)
    public void registerAccountWithoutProvidingFields()
    {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		
		WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccountDropMenu.click();
		
		WebElement registerOption = driver.findElement(By.linkText("Register"));
		registerOption.click();
		
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		String actualFirstNameWarningMessage = driver.findElement(By.xpath("//div[contains(text(),'First Name')]")).getText();
		String expectedFirstNameWarningMessage = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(actualFirstNameWarningMessage, expectedFirstNameWarningMessage);
		
		String actualLastNameWarningMessage = driver.findElement(By.xpath("//div[contains(text(),'Last Name')]")).getText();
		String expectedLastNameWarningMessage = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(actualLastNameWarningMessage, expectedLastNameWarningMessage);
		
		String actualTelePhoneWarningMessage = driver.findElement(By.xpath("//div[contains(text(),'Telephone must')]")).getText();
		String expectedTelePhoneWarningMessage = "Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(actualTelePhoneWarningMessage, expectedTelePhoneWarningMessage);
		
		String actualPasswordWarningMessage = driver.findElement(By.xpath("//div[contains(text(),'Password must ')]")).getText();
		String expectedPasswordWarningMessage = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(actualPasswordWarningMessage, expectedPasswordWarningMessage);
		
		String actualPrivacyPolicyWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedPrivacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";
		Assert.assertTrue(actualPrivacyPolicyWarningMessage.contains(expectedPrivacyPolicyWarningMessage));
		
		driver.close();
		
		
		
		
	
		
		
		
    }
		
		
		
		
		
		
		
	
		
	}

