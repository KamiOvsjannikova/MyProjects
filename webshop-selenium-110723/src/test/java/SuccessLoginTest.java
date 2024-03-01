import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SuccessLoginTest extends  BaseTest {
    @Test
    public void successLogin ()  {
        //Check login with this user data
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        registrationPage.enterFirstName("Adriana");
        registrationPage.enterLastName("Fuchs");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com"; // dlja random email
        registrationPage.enterEmail(uniqueEmail);
//        registrationPage.enterEmail("testQA311023@gmail.com");
        registrationPage.enterPassword("test30124");
        registrationPage.enterConfirmPassword("test30124");
        registrationPage.clickOnRegisterButton();
        SuccessLoginPage successLoginPage = new SuccessLoginPage(driver);
        assertEquals("Your registration completed", successLoginPage.getSuccessCompleteText());

        HeaderPage headerPage = new HeaderPage(driver); // zavela ego potomu chto v header estj knopka log In
        headerPage.clickOnLogOutButton();
        headerPage.clickOnLogInButton();
        successLoginPage.enterEmail(uniqueEmail);
        successLoginPage.enterPassword("test30124");
        successLoginPage.clickOnLogInSubmitButton();
        //Assert that log in success
        assertEquals("Welcome to our store", successLoginPage.getSuccessLoginText());
    }
    // add all necessary tests for auth form



//    @Test
//    public void checkHomePageProductGrid ()  {
//        //Check login with this user data
//        HeaderPage headerPage = new HeaderPage(driver); // zavela ego potomu chto v header estj knopka log In
//        headerPage.clickOnLogInButton();
//
//        SuccessLoginPage successLoginPage = new SuccessLoginPage(driver);// a na etoj str. dla uzspew logina
//        successLoginPage.enterEmail("ovsj@gmail.com");
//        successLoginPage.enterPassword("test30124");
//        successLoginPage.clickOnLogInSubmitButton();
//        //proverka na otobrazenie
//        assertTrue(successLoginPage.homePageProductGridIsDisplayed()); // otobrazenie tovarov
//    }
//
//    @Test
//    public void checkWithEmail ()  {
//        //Check login with this user data
//        HeaderPage headerPage = new HeaderPage(driver); // zavela ego potomu chto v header estj knopka log In
//        headerPage.clickOnLogInButton();
//
//        SuccessLoginPage successLoginPage = new SuccessLoginPage(driver);// a na etoj str. dla uzspew logina
//        successLoginPage.enterEmail("ovsj@gmail.com");
//        successLoginPage.enterPassword("test30124");
//        successLoginPage.clickOnLogInSubmitButton();
//
//        assertEquals("ovsj@gmail.com", headerPage.getSuccessLoginAccount()); //.account
//    }
//
//    @Test
//    public void checkWithLogOut ()  {
//        //Check login with this user data
//        HeaderPage headerPage = new HeaderPage(driver); // zavela ego potomu chto v header estj knopka log In
//        headerPage.clickOnLogInButton();
//
//        SuccessLoginPage successLoginPage = new SuccessLoginPage(driver);// a na etoj str. dla uzspew logina
//        successLoginPage.enterEmail("ovsj@gmail.com");
//        successLoginPage.enterPassword("test30124");
//        successLoginPage.clickOnLogInSubmitButton();
//
//        assertEquals("ovsj@gmail.com", headerPage.getSuccessLoginAccount()); //.account
//        headerPage.clickOnLogOutButton(); //nazatj na knopku log out
//    }


}
