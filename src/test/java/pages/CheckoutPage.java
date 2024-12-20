package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    // Locators
    By nameField = By.xpath("//*[@id=\"name\"]");
    By countryField = By.xpath("//*[@id=\"country\"]");
    By cityField = By.xpath("//*[@id=\"city\"]");
    By cardField = By.xpath("//*[@id=\"card\"]");
    By monthField = By.xpath("//*[@id=\"month\"]");
    By yearField = By.xpath("//*[@id=\"year\"]");
    By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    By orderDetails = By.xpath("/html/body/div[10]");
    By clkok = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillAddress(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public void placeOrder() {
        driver.findElement(purchaseButton).click();
    }

    public String getOrderDetails() {
        return driver.findElement(orderDetails).getText();
    }
    public void ClickOK() {
    	driver.findElement(clkok).click();
    }
}
