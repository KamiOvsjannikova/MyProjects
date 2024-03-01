import org.junit.Test;
import java.util.UUID;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends  BaseTest {
    @Test
    public void successRegistration() {
        //assert that text "Your registration completed" is displayed
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        //zavozu dannie

        registrationPage.enterFirstName("Adriana");
        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com"; // dlja random email
        registrationPage.enterEmail(uniqueEmail);
//        registrationPage.enterEmail("testQA311023@gmail.com");
        registrationPage.enterPassword("test30124");
        registrationPage.enterConfirmPassword("test30124");
        registrationPage.clickOnRegisterButton();
        //assert that text "Your registration completed" is displayed
        SuccessLoginPage successLoginPage = new SuccessLoginPage(driver);
        assertEquals("Your registration completed", successLoginPage.getSuccessCompleteText());
    }

    @Test
    public void registrationWithoutFirstName() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();

        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("test30124");
        registrationPage.enterConfirmPassword("test30124");
        registrationPage.clickOnRegisterButton();
        //assert that text "First name is required." is displayed
        assertEquals("First name is required.", registrationPage.getValidationError());
    }

    @Test
    public void registrationWithoutLastName() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();

        registrationPage.enterFirstName("Adriana");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("test30124");
        registrationPage.enterConfirmPassword("test30124");
        registrationPage.clickOnRegisterButton();
        //assert that text "Last name is required." is displayed
        assertEquals("Last name is required.", registrationPage.getValidationError());
    }


    @Test
    public void registrationWithInvalidEmail() {
        //assert that text "Your registration completed" is displayed
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        //zavozu dannie
        registrationPage.enterFirstName("Adriana");
        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID();
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("test30124");
        registrationPage.enterConfirmPassword("test30124");
        registrationPage.clickOnRegisterButton();
        //assert that text "Wrong email." is displayed
        assertEquals("Wrong email", registrationPage.getValidationError());
    }

    //Password section

    //The password and confirmation password do not match.
    @Test
    public void registrationWithInvalidConfPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        //zavozu dannie
        registrationPage.enterFirstName("Adriana");
        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com"; // dlja random email
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("test30124");
        registrationPage.enterConfirmPassword("test301245");
        registrationPage.clickOnRegisterButton();
        //assert that text "The password and confirmation password do not match." is displayed
        assertEquals("The password and confirmation password do not match.", registrationPage.getValidationError());
    }
    //The password should have at least 6 characters
    @Test
    public void registrationMinValuePassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        //zavozu dannie
        registrationPage.enterFirstName("Adriana");
        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com"; // dlja random email
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("124");
        registrationPage.enterConfirmPassword("124");
        registrationPage.clickOnRegisterButton();
        //assert that text "The password should have at least 6 characters." is displayed
        assertEquals("The password should have at least 6 characters.", registrationPage.getValidationError());
    }

    @Test
    public void registrationDifferentPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        //zavozu dannie
        registrationPage.enterFirstName("Adriana");
        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com"; // dlja random email
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("test124");
        registrationPage.enterConfirmPassword("TEST124");
        registrationPage.clickOnRegisterButton();
        //assert that text "The password and confirmation password do not match." is displayed
        assertEquals("The password and confirmation password do not match.", registrationPage.getValidationError());
    }
//    @Test
//
//    public void registrationMaxValuePassword() {
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//        registrationPage.choseGenderMale();
//        //zavozu dannie
//        registrationPage.enterFirstName("Adriana");
//        registrationPage.enterLastName("Fuchs");
//        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com"; // dlja random email
//        registrationPage.enterEmail(uniqueEmail);
//        registrationPage.enterPassword("");
//        registrationPage.enterConfirmPassword("124");
//        registrationPage.clickOnRegisterButton();
//        //assert that text "" is displayed
//        assertEquals("", registrationPage.getValidationError());
//    }

    @Test
    public void registrationEmptyPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        //zavozu dannie
        registrationPage.enterFirstName("Adriana");
        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com"; // dlja random email
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("");
        registrationPage.enterConfirmPassword("");
        registrationPage.clickOnRegisterButton();
        //assert that text "Password is required." is displayed
        assertEquals("Password is required.", registrationPage.getValidationError());
    }
    @Test
    public void registrationEmptyConfirmPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        //zavozu dannie
        registrationPage.enterFirstName("Adriana");
        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com"; // dlja random email
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("test12345");
        registrationPage.enterConfirmPassword("");
        registrationPage.clickOnRegisterButton();
        //assert that text "Password is required." is displayed
        assertEquals("Password is required.", registrationPage.getValidationError());
    }
}

