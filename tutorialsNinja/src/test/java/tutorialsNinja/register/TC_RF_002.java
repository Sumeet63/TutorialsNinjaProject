package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_002 {
	/*
	 * Verify Registering an Account by providing all the fields
	 * 1. Click on 'My Account' Drop menu
2. Click on 'Register' option 
3. Enter new Account Details into all the Fields (First Name, Last Name, E-Mail,Telephone, Password, Password Confirm, Newsletter and  Privacy Policy Fields)
4. Click on 'Continue' button (ER-1)
5. Click on 'Continue' button that is displayed in the 'Account Success' page (ER-2)
	 */
	WebDriver driver;
	public String generateEmail() {
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
	}
	public void launchBrowserAndRegister() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

	}

	@Test(priority = 1)
	public void  verifyRegisteringAccountByProvidingAllTheFields() {
		launchBrowserAndRegister();		
		driver.findElement(By.id("input-firstname")).sendKeys("Sumeet");
		driver.findElement(By.id("input-lastname")).sendKeys("Padekar");
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed());
		driver.quit();

	}
	/*
	 * Verify proper notification messages are displayed for the mandatory fields, when you don't provide any fields in the 'Register Account' page and submit
	 */
	@Test(priority = 2)
	public void  verifyProperNotificationMessagesAreDisplayedForMandatoryFields() {
		launchBrowserAndRegister();

		driver.findElement(By.id("input-firstname")).sendKeys("");
		driver.findElement(By.id("input-lastname")).sendKeys("");
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-telephone")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.id("input-confirm")).sendKeys("");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.quit();
	}

	@Test(priority = 3)
	public void verifyRegisteringAccountWhen_Yes_optionSelectedForNNewsletterfield() {
		launchBrowserAndRegister();
		driver.findElement(By.id("input-firstname")).sendKeys("");
		driver.findElement(By.id("input-lastname")).sendKeys("");
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-telephone")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.id("input-confirm")).sendKeys("");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.quit();

	}
	@Test(priority = 4)
	public void verifyRegisteringAccountWhen_NO_optionSelectedForNNewsletterfield() {
		launchBrowserAndRegister();
		driver.findElement(By.id("input-firstname")).sendKeys("");
		driver.findElement(By.id("input-lastname")).sendKeys("");
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-telephone")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.id("input-confirm")).sendKeys("");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.quit();

	}

	@Test(priority = 5)
	public void verifyDifferentWaysofNavigatingToRegisterAccountPage() {
		launchBrowserAndRegister();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
		String ExpectedMsg="Register Account";
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()=\"Register Account\"]")).getText(), ExpectedMsg,"all");
		driver.quit();

	}
	@Test(priority = 6)
	public void verifyRegisteringAccountByEnteringDifferentPasswordsInto_Password_Password_Confirm_fields() {
		launchBrowserAndRegister();
		driver.findElement(By.id("input-firstname")).sendKeys("Sumeet");
		driver.findElement(By.id("input-lastname")).sendKeys("Summmet");
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("12345566789");
		driver.findElement(By.id("input-password")).sendKeys("asdfg");
		driver.findElement(By.id("input-confirm")).sendKeys("gfdsa");
		//String ExpectedMsg=driver.findElements(By.xpath("//div[text()=\"Password confirmation does not match password!\"]"));

		//Assert.assertEquals("Password confirmation does not match password!", ExpectedMsg);
		

	}
}


