package StepObject;

import PageObject.ShoppingPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ShoppingSteps extends ShoppingPage {
    WebDriver driver;

    public ShoppingSteps(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Filling an item text in the basket")
    public ShoppingSteps searchInput(String text) {
        driver.findElement(searchField).sendKeys(text);
        return this;
    }
    @Step("Clicking on a search button")
    public ShoppingSteps searchButton() {
        driver.findElement(searchIcon).click();
        return this;
    }
    @Step("Clicking on a searched item")
    public ShoppingSteps openItem() {
        driver.findElement(openItem).click();
        return this;
    }
    @Step ("Adding an item to the basket")
    public ShoppingSteps addToBasket() {
        driver.findElement(basketIcon).click();
        return this;
    }
    @Step ("Increasing item quantity")
    public ShoppingSteps addQuantity() {
        driver.findElement(addButton).click();
        return this;
    }
    @Step ("Clicking on a basket dropdown arrow")
    public ShoppingSteps basketDropdown() {
        driver.findElement(dropdown).click();
        return this;
    }
    @Step ("Entering the basket page")
    public ShoppingSteps basketCheck() {
        driver.findElement(checkIcon).click();
        return this;
    }
    @Step ("Increasing an item amount")
    public ShoppingSteps basketIncrease() {
        driver.findElement(increaseButton).click();
        return this;
    }
    @Step ("Decreasing an item amount")
    public ShoppingSteps basketDecrease() {
        driver.findElement(decreaseButton).click();
        return this;
    }
    @Step ("Clearing the items in the basket")
    public ShoppingSteps basketClear() {
        driver.findElement(clearButton).click();
        return this;
    }
    @Step ("Clicking on a continue shopping button")
    public ShoppingSteps continueShopping() {
        driver.findElement(continueButton).click();
        return this;
    }
    @Step ("Clicking on a purchase button")
    public ShoppingSteps placeOrder() {
        driver.findElement(orderButton).click();
        return this;
    }
    @Step ("Closing popup")
    public ShoppingSteps closePopup() {
        driver.findElement(closeButton).click();
        return this;
    }
}
