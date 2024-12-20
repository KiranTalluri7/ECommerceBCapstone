package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;
import utils.AlertHandler;
import utils.CapturingScreen;
import utils.ExtentReportManager;

import java.time.Duration;

public class BlazingDemoTest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    SignUpPage signUpPage;
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    AlertHandler alertHandler;
    LogOutPage logoutPage;
    CapturingScreen snap;

    @BeforeClass
    public void setUp() {
        extent = ExtentReportManager.getExtentReports();
        test = ExtentReportManager.createTest("BlazingDemoTest");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        alertHandler = new AlertHandler(driver);
        logoutPage = new LogOutPage(driver);
        snap = new CapturingScreen(driver);
    }

    @Test
    public void testBlazingDemo() throws InterruptedException {
        test.info("Starting the test...");

        driver.get("https://www.demoblaze.com/");
        snap.takeScreenshot("HomePage");
        test.pass("Navigated to Home Page");

        // Registration
        String username = "warner" + System.currentTimeMillis();
        signUpPage.signUp(username, "Warner123");
        Thread.sleep(2000);
        alertHandler.acceptAlert();
        snap.takeScreenshot("Registration");
        test.pass("Registration completed");
        Thread.sleep(2000);


        // Login
        loginPage.login(username, "Warner123");
        snap.takeScreenshot("Login");
        test.pass("Login successful");
        Thread.sleep(2000);

        

        // Navigate through pages
        homePage.navigateToCategory("Phones");
        Thread.sleep(2000);

        snap.takeScreenshot("PhonesCategory");
        test.pass("Navigated to Phones category");
        Thread.sleep(2000);


        productPage.scrollDown();
        Thread.sleep(2000);

        productPage.selectProduct(6);
        Thread.sleep(2000);

        snap.takeScreenshot("SelectedProduct");
        test.pass("Selected product");
        Thread.sleep(2000);


        driver.navigate().back();
        Thread.sleep(2000);

        homePage.navigateToCategory("Laptops");
        snap.takeScreenshot("LaptopsCategory");
        test.pass("Navigated to Laptops category");

        homePage.navigateToCategory("Monitors");
        productPage.selectProduct(1);
        snap.takeScreenshot("MonitorsCategory");
        test.pass("Selected monitor product");
        Thread.sleep(2000);


        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();
        Thread.sleep(2000);
        alertHandler.acceptAlert();
        snap.takeScreenshot("AddToCart");
        test.pass("Added product to cart");
        Thread.sleep(2000);


        cartPage.goToCart();
        Thread.sleep(2000);

        snap.takeScreenshot("CartPage");
        test.pass("Navigated to Cart Page");
        Thread.sleep(2000);


        cartPage.checkout();
        Thread.sleep(2000);

        checkoutPage.fillAddress("warner", "India", "Vizag", "50301020", "Jan", "2020");
        snap.takeScreenshot("CheckoutPage");
        test.pass("Checkout completed");
        Thread.sleep(2000);


        checkoutPage.placeOrder();
        snap.takeScreenshot("OrderPlaced");
        test.pass("Order placed successfully");
        Thread.sleep(2000);


        checkoutPage.ClickOK();
        snap.takeScreenshot("OrderConfirmation");
        test.pass("Order confirmation received");

        logoutPage.logout();
        snap.takeScreenshot("LogoutPage");
        test.pass("Logged out successfully");
    }

    @AfterClass
    public void close() {
        ExtentReportManager.flushReports();
        driver.quit();
    }
}
