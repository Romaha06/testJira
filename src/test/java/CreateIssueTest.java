import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateIssueTest {

    WebDriver driver;
    CreateIssuePage createIssuePage;
    LoginPage loginPage;
    String userName = "Roman_Chelombitko";
    String passwordSuccess = "Roman_Chelombitko";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Jira_Login\\chromedriver.exe");
        this.driver = new ChromeDriver();
        createIssuePage = new CreateIssuePage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


    @Test
    public void createIssurTest() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/login.jsp");
        loginPage.inputData(userName, passwordSuccess);
        Thread.sleep(3000);
        createIssuePage.clickOnTheCreateIssueButton();
        Thread.sleep(5000);
        createIssuePage.fillInProjectInput();
        Thread.sleep(3000);
        createIssuePage.fillInIssueTypeInput();
        Thread.sleep(3000);
        createIssuePage.fillInSummary();
        Thread.sleep(3000);
        createIssuePage.fillInDescription();
        Thread.sleep(3000);
        createIssuePage.createIssue();
        Thread.sleep(2000);
        Assert.assertTrue(createIssuePage.successfulMessage());
    }
    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}