package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasePage {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Fix for - The path to the driver executable must be set by the webdriver.chrome.driver system property
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Test\\chromedriver.exe");
        // Create a new instance of the Chrome driver
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        // Close the driver
        this.driver.quit();
    }
}
