import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class AuthWrongPassword extends BaseTest{
    @Test
    public void loginWithUppercasePassword(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        registrationPage.enterFirstName("Adriana");
        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com"; // dlja random email
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("test30124");
        registrationPage.enterConfirmPassword("test30124");
        registrationPage.clickOnRegisterButton();
        //assert that text "Your registration completed" is displayed
        SuccessLoginPage successLoginPage = new SuccessLoginPage(driver);
        assertEquals("Your registration completed", successLoginPage.getSuccessCompleteText());
        //logout
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnLogOutButton();
        //login with exist user
        headerPage.clickOnLogInButton();
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("test30124");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLogInSubmitButton();
        assertEquals("Login was unsuccessful. Please correct the errors and try again.",loginPage.getValidationError());
    }
}
