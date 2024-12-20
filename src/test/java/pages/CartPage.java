package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Locators
    By cartButton = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[1]/li[4]/a[1]");
    By checkoutButton = By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/button[1]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }

    public void checkout() {
        driver.findElement(checkoutButton).click();
    }
}
