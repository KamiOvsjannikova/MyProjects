import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    ChromeDriver driver;

    public LoginPage (ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (className = "login-button")
    private WebElement loginSubmitButton;
    public void clickOnLogInSubmitButton(){
        loginSubmitButton.click();
    }

    @FindBy(className = "validation-summary-errors")
    private WebElement validationError;

    public String getValidationError() {
        return validationError.getText();
    }
}
