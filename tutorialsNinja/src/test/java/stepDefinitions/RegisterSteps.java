package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.RegisterPage;

import java.util.Map;

public class RegisterSteps {

    private RegisterPage registerPage;

    public RegisterSteps() {
        registerPage = new RegisterPage();
    }

    @Given("the user opens the TutorialsNinja application")
    public void userOpensTutorialsNinjaApplication() {
        registerPage.openApplication();
    }

    @Given("the user navigates to the Register Account page")
    public void userNavigatesToRegisterAccountPage() {
        registerPage.clickMyAccount();
        registerPage.clickRegister();
    }

    @When("the user enters valid mandatory registration details")
    public void userEntersValidMandatoryRegistrationDetails() {

        registerPage.enterFirstName("Sumeet");
        registerPage.enterLastName("Test");
        registerPage.enterEmail("sumeet" + System.currentTimeMillis() + "@gmail.com");
        registerPage.enterTelephone("9876543210");
        registerPage.enterPassword("Test@123");
        registerPage.enterPasswordConfirm("Test@123");
    }

    @When("the user enters valid details into all registration fields")
    public void userEntersValidDetailsIntoAllRegistrationFields() {

        registerPage.enterFirstName("Sumeet");
        registerPage.enterLastName("Test");
        registerPage.enterEmail("sumeet" + System.currentTimeMillis() + "@gmail.com");
        registerPage.enterTelephone("9876543210");
        registerPage.enterPassword("Test@123");
        registerPage.enterPasswordConfirm("Test@123");
    }

    @When("the user agrees to the Privacy Policy")
    public void userAgreesToPrivacyPolicy() {
        registerPage.selectPrivacyPolicy();
    }

    @When("the user clicks the Continue button")
    public void userClicksContinueButton() {
        registerPage.clickContinue();
    }

    @Then("the Account Success page should be displayed")
    public void accountSuccessPageShouldBeDisplayed() {
        Assert.assertTrue(
                registerPage.isAccountSuccessPageDisplayed(),
                "Account Success page was not displayed"
        );
    }
    @Then("the account registration should be successful")
    public void accountRegistrationShouldBeSuccessful() {

        Assert.assertTrue(
                registerPage.isAccountSuccessPageDisplayed(),
                "Account registration was not successful"
        );
    }

    @When("the user clicks the Continue button on the Account Success page")
    public void userClicksContinueOnAccountSuccessPage() {
        registerPage.clickSuccessContinue();
    }

    @Then("the user should be navigated to the Account page")
    public void userShouldBeNavigatedToAccountPage() {
        Assert.assertTrue(
                registerPage.isAccountPageDisplayed(),
                "Account page was not displayed"
        );
    }

    @When("the user enters the following registration details:")
    public void userEntersRegistrationDetails(DataTable dataTable) {

        Map<String, String> data = dataTable.asMap(String.class, String.class);

        registerPage.enterFirstName(data.get("First Name"));
        registerPage.enterLastName(data.get("Last Name"));
        registerPage.enterEmail(data.get("Email"));
        registerPage.enterTelephone(data.get("Telephone"));
        registerPage.enterPassword(data.get("Password"));
        registerPage.enterPasswordConfirm(data.get("Password Confirm"));
    }

    @Then("the email already registered warning message should be displayed")
    public void emailAlreadyRegisteredWarningShouldBeDisplayed() {

        Assert.assertTrue(
                registerPage.isEmailAlreadyRegisteredMessageDisplayed(),
                "Existing email warning was not displayed"
        );
    }

    @Then("the account should not be created")
    public void accountShouldNotBeCreated() {

        Assert.assertFalse(
                registerPage.isAccountSuccessPageDisplayed(),
                "Account should not have been created"
        );
    }

    @When("the user enters {string} in the Email field")
    public void userEntersInEmailField(String email) {
        registerPage.enterEmail(email);
    }

    @Then("the invalid email validation message should be displayed")
    public void invalidEmailValidationMessageShouldBeDisplayed() {

        Assert.assertTrue(
                registerPage.isEmailValidationDisplayed(),
                "Invalid email validation message was not displayed"
        );
    }

    @When("the user enters {string} in the Telephone field")
    public void userEntersInTelephoneField(String telephone) {
        registerPage.enterTelephone(telephone);
    }

    @Then("the telephone validation message should be displayed")
    public void telephoneValidationMessageShouldBeDisplayedin() {

        Assert.assertTrue(
                registerPage.isTelephoneValidationDisplayed(),
                "Telephone validation message was not displayed"
        );
    }

    @When("the user selects {string} for Newsletter")
    public void userSelectsNewsletter(String option) {

        registerPage.selectNewsletter(option);
    }

    @Then("the Newsletter option {string} should be selected")
    public void newsletterOptionShouldBeSelected(String option) {

        Assert.assertEquals(
                registerPage.getSelectedNewsletterOption(),
                option
        );
    }

    @When("the user enters {string} in the Password field")
    public void userEntersPassword(String password) {
        registerPage.enterPassword(password);
    }

    @When("the user enters {string} in the Password Confirm field")
    public void userEntersPasswordConfirm(String password) {
        registerPage.enterPasswordConfirm(password);
    }

    @Then("the password confirmation validation message should be displayed")
    public void passwordConfirmationValidationMessageShouldBeDisplayed() {

        Assert.assertTrue(
                registerPage.isPasswordConfirmValidationDisplayed(),
                "Password confirmation validation was not displayed"
        );
    }

    @When("the user does not select the Privacy Policy checkbox")
    public void userDoesNotSelectPrivacyPolicy() {
        // Intentionally left unchecked
    }

    @Then("the Privacy Policy validation message should be displayed")
    public void privacyPolicyValidationMessageShouldBeDisplayed() {

        Assert.assertTrue(
                registerPage.isPrivacyPolicyValidationDisplayed(),
                "Privacy Policy validation message was not displayed"
        );
    }

    @Then("the Privacy Policy checkbox should not be selected by default")
    public void privacyPolicyCheckboxShouldNotBeSelectedByDefault() {

        Assert.assertFalse(
                registerPage.isPrivacyPolicySelected(),
                "Privacy Policy checkbox is selected by default"
        );
    }

    @When("the user enters valid registration details")
    public void userEntersValidRegistrationDetails() {

        registerPage.enterFirstName("Sumeet");
        registerPage.enterLastName("Test");
        registerPage.enterEmail("sumeet" + System.currentTimeMillis() + "@gmail.com");
        registerPage.enterTelephone("9876543210");
        registerPage.enterPassword("Test@123");
        registerPage.enterPasswordConfirm("Test@123");
    }

    @Then("the First Name validation message should be displayed")
    public void firstNameValidationMessageShouldBeDisplayed() {
        Assert.assertTrue(registerPage.isFirstNameValidationDisplayed());
    }

    @Then("the Last Name validation message should be displayed")
    public void lastNameValidationMessageShouldBeDisplayed() {
        Assert.assertTrue(registerPage.isLastNameValidationDisplayed());
    }

    @Then("the Email validation message should be displayed")
    public void emailValidationMessageShouldBeDisplayed() {
        Assert.assertTrue(registerPage.isEmailValidationDisplayed());
    }

    @Then("the Telephone validation message should be displayed")
    public void telephoneValidationMessageShouldBeDisplayed() {
        Assert.assertTrue(registerPage.isTelephoneValidationDisplayed());
    }

    @Then("the Password validation message should be displayed")
    public void passwordValidationMessageShouldBeDisplayed() {
        Assert.assertTrue(registerPage.isPasswordValidationDisplayed());
    }
}
