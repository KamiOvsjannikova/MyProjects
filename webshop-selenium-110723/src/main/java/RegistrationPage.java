import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    ChromeDriver driver;

    public RegistrationPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy( id = "gender-male")
    private WebElement genderMale;

    @FindBy (id = "FirstName") // naxozu po id
    private WebElement firstNameInputFiled;

    @FindBy (id = "LastName") // naxozu po id
    private WebElement lastNameInputFiled;

    @FindBy (id = "Email") // naxozu po id
    private WebElement emailInputFiled;


    @FindBy (id = "Password")
    private WebElement passwordInputField;

    @FindBy (id = "ConfirmPassword")
    private WebElement confirmPasswordInputField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(className = "result")
    private WebElement resultText;

    //najti tekst chto pole objazatelnoje dlja zapolnenija ili chto ne sovpadaet password

    @FindBy(xpath = "//span[@class='field-validation-error']/span")
    private WebElement validationError;





    public void choseGenderMale() {
        genderMale.click();
    }
    public void enterFirstName(String firstNameValue){
        firstNameInputFiled.sendKeys(firstNameValue);
    }
    public void enterLastName(String lastNameValue){
        lastNameInputFiled.sendKeys(lastNameValue);
    }
    public void enterEmail(String emailValue){
        emailInputFiled.sendKeys(emailValue);
    }

    public void enterPassword(String passwordValue){
        passwordInputField.sendKeys(passwordValue);
    }
    public void enterConfirmPassword(String confirmPasswordValue) {
        confirmPasswordInputField.sendKeys(confirmPasswordValue);
    }
    public void clickOnRegisterButton() { // nazatj knopku Register
        registerButton.click();
    }

    public String registerResultText() {
        return resultText.getText();
    }

    public String getValidationError() {
        return validationError.getText();
    }
}
