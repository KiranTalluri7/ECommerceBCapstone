package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    // Locators
    By signUpLink = By.linkText("Sign up");
    By usernameField = By.id("sign-username");
    By passwordField = By.id("sign-password");
    By signUpButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signUp(String username, String password) {
        driver.findElement(signUpLink).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signUpButton).click();
    }
}
