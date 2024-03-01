import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    ChromeDriver driver;

    public HeaderPage (ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ico-login")
    private WebElement logInButton;
    @FindBy(className = "account")
    private WebElement successLoginAccount;
    @FindBy(className = "ico-logout")
    private WebElement logOutButton;


    public void clickOnLogInButton(){
        logInButton.click();
    }

    public String getSuccessLoginAccount(){
        return successLoginAccount.getText();
    }
    public void clickOnLogOutButton(){
        logOutButton.click();
    }

    //ico-logout
}
