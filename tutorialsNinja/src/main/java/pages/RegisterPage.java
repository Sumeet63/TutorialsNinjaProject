package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage() {
        this.driver = utils.DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By myAccount = By.xpath("//span[text()='My Account']");
    private By registerLink = By.linkText("Register");

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By passwordConfirm = By.id("input-confirm");

    private By privacyPolicy = By.name("agree");
    private By continueButton = By.cssSelector("input[type='submit']");

    private By successHeading =
            By.xpath("//h1[contains(text(),'Your Account Has Been Created')]");

    private By successContinue =
            By.linkText("Continue");

    private By emailAlreadyRegisteredMessageDisplayed =
            By.xpath("//*[contains(text(),'Warning: E-Mail Address is already registered')]");
    // Methods

    public void openApplication() {
        driver.get("https://tutorialsninja.com/demo/");
    }

    public void clickMyAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
    }

    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public void enterFirstName(String value) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(value);
    }

    public void enterTelephone(String value) {
        driver.findElement(telephone).clear();
        driver.findElement(telephone).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);
    }

    public void enterPasswordConfirm(String value) {
        driver.findElement(passwordConfirm).clear();
        driver.findElement(passwordConfirm).sendKeys(value);
    }

    public void selectPrivacyPolicy() {
        driver.findElement(privacyPolicy).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isAccountSuccessPageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successHeading)
        ).isDisplayed();
    }

    public void clickSuccessContinue() {
        driver.findElement(successContinue).click();
    }

    public boolean isAccountPageDisplayed() {
        return driver.getCurrentUrl().contains("account/account");
    }

    public void selectNewsletter(String option) {

        if (option.equalsIgnoreCase("Yes")) {
            driver.findElement(By.cssSelector("input[name='newsletter'][value='1']")).click();
        } else {
            driver.findElement(By.cssSelector("input[name='newsletter'][value='0']")).click();
        }
    }

    public String getSelectedNewsletterOption() {

        if (driver.findElement(
                By.cssSelector("input[name='newsletter'][value='1']")
        ).isSelected()) {
            return "Yes";
        }

        return "No";
    }

    public boolean isEmailAlreadyRegisteredMessageDisplayed() {

        return driver.findElements(emailAlreadyRegisteredMessageDisplayed).size() > 0;
    }

    public boolean isEmailValidationDisplayed() {

        return driver.findElements(
                By.xpath("//*[contains(text(),'E-Mail Address does not appear to be valid')]")
        ).size() > 0;
    }

    public boolean isTelephoneValidationDisplayed() {

        return driver.findElements(
                By.xpath("//*[contains(@class,'text-danger') and contains(text(),'Telephone')]")
        ).size() > 0;
    }

    public boolean isPasswordConfirmValidationDisplayed() {

        return driver.findElements(
                By.xpath("//*[contains(@class,'text-danger') and contains(text(),'Password confirmation')]")
        ).size() > 0;
    }

    public boolean isPrivacyPolicyValidationDisplayed() {

        return driver.findElements(
                By.xpath("//*[contains(@class,'alert-danger')]")
        ).size() > 0;
    }

    public boolean isPrivacyPolicySelected() {
        return driver.findElement(privacyPolicy).isSelected();
    }

    public boolean isFirstNameValidationDisplayed() {
        return driver.findElements(
                By.xpath("//*[contains(text(),'First Name must be between')]")
        ).size() > 0;
    }

    public boolean isLastNameValidationDisplayed() {
        return driver.findElements(
                By.xpath("//*[contains(text(),'Last Name must be between')]")
        ).size() > 0;
    }

    public boolean isPasswordValidationDisplayed() {
        return driver.findElements(
                By.xpath("//*[contains(text(),'Password must be between')]")
        ).size() > 0;
    }
}