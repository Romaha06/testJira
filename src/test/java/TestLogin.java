import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin {

    WebDriver driver;
    LoginPage loginPage;
    String userName = "Roman_Chelombitko";
    String passwordWrong = "AbraKadabra";
    String passwordSuccess = "Roman_Chelombitko";

    @BeforeTest
    public void LoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Jira_Login\\chromedriver.exe");
        this.driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginSuccess() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/login.jsp");
        loginPage.inputData(userName, passwordSuccess);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
    }
    @AfterTest
    public void tearDownSuccessTest() {
        this.driver.quit();
    }

    @Test
    public void testLoginWrongLassword() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/login.jsp");
        loginPage.inputData(userName, passwordWrong);
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.errorMassage(), "Sorry, your username and password are incorrect - please try again.");
    }
    @AfterTest
    public void tearDownWrongTest() {
        this.driver.quit();
    }
}
