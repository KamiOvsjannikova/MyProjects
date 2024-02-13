package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ApparelAndShoesPage;
import pages.Categories;

import static com.codeborne.selenide.Selenide.open;

public class ApparelAndShoesSteps {
    Categories categories = new Categories();
    ApparelAndShoesPage apparelAndShoesPage = new ApparelAndShoesPage();

    @Given("^I open Main page and then Apparel & Shoes page$")
    public void iOpenMainPageAndThenApparelShoesPage() {
        open("https://demowebshop.tricentis.com/");
        categories.apparelAndShoesButton.click();
    }

    @When("^I open quantity items dropdown menu$")
    public void iOpenQuantityItemsDropdownMenu() {
        apparelAndShoesPage.quantityDropdown.click();
    }


    @And("^choose option four items$")
    public void chooseOptionFourItems() {
        apparelAndShoesPage.quantity4.click();
    }

    @Then("^I see (\\d+) items on page$")
    public void iSeeItemsOnPage(int quantityValue) {
        apparelAndShoesPage.items.shouldHave(CollectionCondition.size(quantityValue));
    }

    @And("^Each item has name$")
    public void eachItemHasName() {
        for (SelenideElement title: apparelAndShoesPage.itemsTitle) {
            title.shouldBe(Condition.visible);
        }
    }

    @And("^Each item has photo$")
    public void eachItemHasPhoto() {
        for (SelenideElement photo: apparelAndShoesPage.itemsPhoto) {
            photo.shouldBe(Condition.visible);
        }
    }

    @And("^Each item has add to cart button$")
    public void eachItemHasAddToCartButton() {
        for (SelenideElement button: apparelAndShoesPage.addToCartButtons) {
            button.shouldBe(Condition.visible);
        }
    }

    @And("^Each item has rating in stars$")
    public void eachItemHasRatingInStars() {
        for (SelenideElement rating: apparelAndShoesPage.itemsRating) {
            rating.shouldBe(Condition.visible);
        }
    }

    @And("^choose option eight items$")
    public void chooseOptionEightItems() {
        apparelAndShoesPage.quantity8.click();
    }

    @And("^choose option twelve items$")
    public void chooseOptionTwelveItems() {
        apparelAndShoesPage.quantity12.click();
    }


    @And("^There are (\\d+) names$")
    public void thereAreNames(int quantityNamesValue) {
        apparelAndShoesPage.itemsTitle.shouldBe(CollectionCondition.size(quantityNamesValue));
    }

    @And("^There are (\\d+) photos$")
    public void thereArePhotos(int quantityPhotosValue) {
        apparelAndShoesPage.itemsPhoto.shouldBe(CollectionCondition.size(quantityPhotosValue));
    }

    @And("^There are (\\d+) buttons$")
    public void thereAreButtons(int quantityButtonsValue) {
        apparelAndShoesPage.addToCartButtons.shouldBe(CollectionCondition.size(quantityButtonsValue));
    }

    @And("^There are (\\d+) ratings$")
    public void thereAreRatings(int quantityRatingsValue) {
        apparelAndShoesPage.itemsRating.shouldBe(CollectionCondition.size(quantityRatingsValue));
    }
}