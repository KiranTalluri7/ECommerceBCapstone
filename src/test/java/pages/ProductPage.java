package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    // Locators
    By productList = By.xpath("//*[@id=\"tbodyid\"]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductDetails() {
        return driver.findElement(productList).getText();
    }

    public void selectProduct(int productIndex) {
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[" + productIndex + "]/div/div/h4/a")).click();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 450)", "");
    }
}
