import StepObject.ShoppingSteps;
import Utils.ChromeRider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DataObject.ShoppingData.*;
import static java.lang.Thread.sleep;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Shopping extends ChromeRider {

    @Test (priority = 1)
    @Description("Searching an item")
    @Severity(SeverityLevel.NORMAL)
    public void searchItem() {
        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(searchData)
                .searchButton();

        By text = By.linkText("მოტოცელი აკუმულატორის DeWalt Flexvolt DCM571X1-QW 54V");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(text));
        String actualResult = element.getText();
        String expectedResult = "მოტოცელი აკუმულატორის DeWalt Flexvolt DCM571X1-QW 54V";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 2)
    @Description("Searching an item and then adding it to the basket")
    @Severity(SeverityLevel.NORMAL)
    public void addItemToBasket() throws InterruptedException {
        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(searchData)
                .searchButton()
                .openItem()
                .addToBasket();

        sleep(7000);

        home.basketDropdown();

        String actualResult = driver.findElement(dropdownItem).getText();
        String expectedResult = "მოტოცელი აკუმულატორის DeWalt Flexvolt DCM571X1-QW 54V";

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test (priority = 3)
    @Description("Adding an item to the basket and then going to the basket page")
    @Severity(SeverityLevel.NORMAL)
    public void openBasket() throws InterruptedException {
        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(searchData)
                .searchButton()
                .openItem()
                .addToBasket();
        sleep(7000);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try {
//            wait.until(ExpectedConditions.elemen(popupButton)).click();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        home
                .basketDropdown()
                .basketCheck();

        String actualResult = driver.findElement(basketItem).getText();
        String expectedResult = "მოტოცელი აკუმულატორის DeWalt Flexvolt DCM571X1-QW 54V";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 4)
    @Description("Increasing an item quantity with '+' button")
    @Severity(SeverityLevel.NORMAL)
    public void increaseQuantity() throws InterruptedException {
        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(searchData)
                .searchButton()
                .openItem()
                .addToBasket();

        sleep(7000);

        home
                .basketDropdown()
                .basketCheck()
                .basketIncrease();

        String actualResult = driver.findElement(itemQuantity).getAttribute("value");
        String expectedResult = "2";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 5)
    @Description("Decreasing an item quantity with '-' button")
    @Severity(SeverityLevel.NORMAL)
    public void decreaseQuantity() throws InterruptedException {
        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(searchData)
                .searchButton()
                .openItem()
                .addToBasket();

        sleep(7000);

        home
                .basketDropdown()
                .basketCheck()
                .basketDecrease();

        String actualResult = driver.findElement(itemQuantity).getAttribute("value");
        String expectedResult = "1";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 6)
    @Description("Clearing the item from the basket")
    @Severity(SeverityLevel.NORMAL)
    public void clearItem() throws InterruptedException {
        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(searchData)
                .searchButton()
                .openItem()
                .addToBasket();

        sleep(7000);

        home
                .basketDropdown()
                .basketCheck()
                .basketClear();

        String actualResult = driver.findElement(emptyBasket).getText();
        String expectedResult = "თქვენი კალათა ცარიელია";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 7)
    @Description("Clicking on continue shopping button from the basket")
    @Severity(SeverityLevel.NORMAL)
    public void continueToShop() throws InterruptedException {
        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(searchData)
                .searchButton()
                .openItem()
                .addToBasket();

        sleep(7000);

        home
                .basketDropdown()
                .basketCheck()
                .continueShopping();

        String actualResult = driver.findElement(productList).getText();
        String expectedResult = "მოტოცელები";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 8)
    @Description("Trying to place an order without sign in")
    @Severity(SeverityLevel.NORMAL)
    public void purchase() throws InterruptedException {
        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(searchData)
                .searchButton()
                .openItem()
                .addToBasket();

        sleep(7000);

        home
                .basketDropdown()
                .basketCheck()
                .placeOrder();

        sleep(5000);

        String actualResult = driver.findElement(authPopup).getText();
        String expectedResult = "შესვლა";

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (priority = 9)
    @Description("Searching a wrong item")
    @Severity(SeverityLevel.NORMAL)
    public void searchIncorrectItem() {
        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(incorrectSearchData)
                .searchButton();

        By text = By.xpath("//*[@id='products_search_11']/div");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(text));
        String actualResult = element.getText();
        String expectedResult = "შესატყვისი პროდუქტი ვერ მოიძებნა";
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (priority = 10)
    @Description("Trying to add unavailable quantity of items")
    @Severity(SeverityLevel.NORMAL)
    public void unavailableQuantity() throws InterruptedException {

        ShoppingSteps home = new ShoppingSteps(driver);
        home
                .searchInput(searchData)
                .searchButton()
                .openItem()
                .addQuantity()
                .addQuantity()
                .addToBasket();

        sleep(7000);

        WebElement message = driver.findElement(warningMsg);
        Assert.assertTrue(message.isDisplayed());
    }
}
