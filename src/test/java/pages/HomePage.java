package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    // Locators
    By categories = By.xpath("//*[@id=\"contcont\"]/div/div[1]/div");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCategories() {
        return driver.findElement(categories).getText();
    }

    public void navigateToCategory(String categoryName) {

        driver.findElement(By.linkText(categoryName)).click();
    }
}
