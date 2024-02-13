package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ApparelAndShoesPage {
    public SelenideElement quantityDropdown = $(byId("products-pagesize"));
    public SelenideElement quantity4 = $x("//option[@value=\"https://demowebshop.tricentis.com/apparel-shoes?pagesize=4\"]");
    public SelenideElement quantity8 = $x("//option[@value=\"https://demowebshop.tricentis.com/apparel-shoes?pagesize=8\"]");
    public SelenideElement quantity12 = $x("//option[@value=\"https://demowebshop.tricentis.com/apparel-shoes?pagesize=12\"]");
    public ElementsCollection items = $$(byClassName("product-item"));
    public ElementsCollection itemsPhoto = $$(byClassName("picture"));
    public ElementsCollection itemsRating = $$(byClassName("rating"));
    public ElementsCollection itemsTitle = $$(byTagName("h2"));
    public ElementsCollection addToCartButtons = $$x("//input[@value=\"Add to cart\"]");

}