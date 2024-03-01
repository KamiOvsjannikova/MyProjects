import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessLoginPage {
    ChromeDriver driver;

    public SuccessLoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='result']")
    private WebElement successCompleteText;

    @FindBy(id = "Email")
    private WebElement emailInputField;
    @FindBy(id = "Password")
    private WebElement passwordInputField;

    @FindBy (className = "login-button")
    private WebElement loginSubmitButton;

    @FindBy (xpath = "//div[@class='topic-html-content-title']")
    private WebElement successLoginText;
    @FindBy(className = "home-page-product-grid")
    private WebElement homePageProductGrid;



    public String getSuccessCompleteText() {
        return successCompleteText.getText();
    }

    public void enterEmail(String emailValue){
        emailInputField.sendKeys(emailValue);
    }
    public void enterPassword(String passwordValue) {
        passwordInputField.sendKeys(passwordValue);
    }
    public void clickOnLogInSubmitButton(){
        loginSubmitButton.click();
    }

    public String getSuccessLoginText(){
        return successLoginText.getText();
    }

    public boolean homePageProductGridIsDisplayed() { //<--boolean true-false v samom test proverka
        return homePageProductGrid.isDisplayed(); // ubezdaetsja, chto vozvrawaet true, otobraetsja na str
    }


}
