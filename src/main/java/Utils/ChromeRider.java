package Utils;

import PageObject.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ChromeRider extends ShoppingPage {
    public static WebDriver driver;
    @BeforeMethod(description = "Setting up a chrome browser before test")
    public void openChrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.domino.com.ge/");
    }

    @AfterMethod(description = "Closing the chrome browser after the test")
    public void closeChrome() {
        driver.quit();
    }
}
