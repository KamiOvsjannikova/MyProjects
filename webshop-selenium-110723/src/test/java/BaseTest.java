import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    ChromeDriver driver;

    String BASE_URL = "https://demowebshop.tricentis.com/register";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
