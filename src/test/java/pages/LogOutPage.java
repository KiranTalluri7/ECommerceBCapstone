package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {
	WebDriver driver;
	
	//locators
	By LogoutButton=By.id("logout2");
	
	public LogOutPage(WebDriver driver) {
		this.driver=driver;
		
	}
	public void logout() {
		driver.findElement(LogoutButton).click();
	}

}
