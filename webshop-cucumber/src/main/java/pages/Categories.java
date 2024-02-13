package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class Categories {
    public SelenideElement apparelAndShoesButton = $$x("//a[@href=\"/apparel-shoes\"]").get(0);
}