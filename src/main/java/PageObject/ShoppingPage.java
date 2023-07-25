package PageObject;

import org.openqa.selenium.By;

public class ShoppingPage {
    public By
            searchField = By.id("search_input"),
            searchIcon = By.className("ty-search-magnifier"),
            openItem = By.id("det_img_198626desktop"),
            basketIcon = By.id("button_cart_198626"),
            dropdown = By.id("sw_dropdown_3785"),
            dropdownItem = By.xpath("//*[@id='dropdown_3785']/div/div[1]/ul/li/div[2]/a"),
            basketItem = By.xpath("//*[@id='cart_items']/table/tbody/tr/td[2]/a[1]"),
            itemQuantity = By.id("amount_3848677336"),
            emptyBasket = By.xpath("//*[@id='tygh_main_container']/div[3]/div/div[2]/div/div/div/div/p"),
            productList = By.xpath("//*[@id='tygh_main_container']/div[3]/div/div[1]/div/div/div/div[2]/div/h1"),
            addButton = By.id("198626"),
            authPopup = By.id("ui-id-1"),
            warningMsg = By.xpath("//*[@id='tygh_container']/div[3]/div"),
            checkIcon = By.className("ty-float-left"),
            increaseButton = By.xpath("//*[@id='quantity_update_3848677336']/div/a[1]"),
            decreaseButton = By.xpath("//*[@id='quantity_update_3848677336']/div/a[2]"),
            clearButton = By.xpath("//*[@id='tygh_main_container']/div[3]/div/div[2]/div/div/div/div/div[3]/div[1]/a[2]"),
            continueButton = By.xpath("//*[@id='tygh_main_container']/div[3]/div/div[2]/div/div/div/div/div[3]/div[1]/a[1]"),
            orderButton = By.xpath("//*[@id='tygh_main_container']/div[3]/div/div[2]/div/div/div/div/div[3]/div[2]"),
            closeButton = By.xpath("//span[@class='cm-notification-close close']");
}
