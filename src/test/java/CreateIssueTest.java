import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateIssueTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Jira_Login\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    By userNameInput = By.xpath("//input[@name='os_username']");
    By passwordInput = By.xpath("//input[@name='os_password']");
    By loginButton = By.xpath("//input[@name='login']");
    By createIssueButton = By.id("create_link");
    By projectInput = By.cssSelector("#project-field");
    By issueTypeInput = By.cssSelector("#issuetype-field");
    By summaryInput = By.cssSelector("#summary");
    By descriptionInput = By.xpath("//textarea[@name='description']");
    By createbutton = By.cssSelector("#create-issue-submit");
    By issueSuccessfullyCreated = By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']");
    String userName = "Roman_Chelombitko";
    String password = "Roman_Chelombitko";

    @Test
    public void createIssurTest() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/login.jsp");
        this.driver.findElement(userNameInput).sendKeys(userName);
        this.driver.findElement(passwordInput).sendKeys(password);
        this.driver.findElement(loginButton).click();
        Thread.sleep(2000);
        this.driver.findElement(createIssueButton).click();
        Thread.sleep(2000);
        this.driver.findElement(projectInput);
        this.driver.findElement(issueTypeInput);
        this.driver.findElement(summaryInput).sendKeys("This is an automatic test.");
        Thread.sleep(5000);
        this.driver.findElement(By.xpath("//Li[@data-mode='source']")).click();
        Thread.sleep(3000);
        this.driver.findElement(descriptionInput).sendKeys("This is an automatic test.");
        this.driver.findElement(createbutton).click();

        Thread.sleep(3000);
        assertTrue(this.driver.findElement(issueSuccessfullyCreated).isDisplayed());
    }
    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}