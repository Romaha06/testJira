import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestLogin {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Jira_Login\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    By userNameInput = By.xpath("//input[@name='os_username']");
    By passwordInput = By.xpath("//input[@name='os_password']");
    By loginButton = By.xpath("//input[@name='login']");
    By wrongPasswordLabel = By.xpath("//div[@class='aui-message aui-message-error']");
    String userName = "Roman_Chelombitko";
    String passwordWrong = "AbraKadabra";
    String passwordSuccess = "Roman_Chelombitko";


    @Test
    public void testLoginWrongLassword() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/login.jsp");
        this.driver.findElement(userNameInput).sendKeys(userName);
        this.driver.findElement(passwordInput).sendKeys(passwordWrong);
        this.driver.findElement(loginButton).click();

        Thread.sleep(2000);
        assertTrue(this.driver.findElement(wrongPasswordLabel).isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void testLoginSuccess() throws InterruptedException {

        this.driver.get("https://jira.hillel.it/login.jsp");
        this.driver.findElement(userNameInput).sendKeys(userName);
        this.driver.findElement(passwordInput).sendKeys(passwordSuccess);
        this.driver.findElement(loginButton).click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://jira.hillel.it/secure/Dashboard.jspa");

    }

}

