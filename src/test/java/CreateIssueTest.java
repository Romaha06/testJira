import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CreateIssuePage;
import pages.LoginPage;

public class CreateIssueTest extends BasePage {

    WebDriver driver;



    @Test
    public void createIssurTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.Login("Roman_Chelombitko","Roman_Chelombitko");
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");

        CreateIssuePage createIssuePage = new CreateIssuePage(driver);

        createIssuePage.clickOnTheCreateIssueButton();

        createIssuePage.fillInProjectInput("QAAUT-8");

        createIssuePage.fillInIssueTypeInput("Test");

        createIssuePage.fillInSummary("This is an automatic test.");

        createIssuePage.fillInDescription("This is an automatic test.");

        createIssuePage.clickCreateIssue();

        Assert.assertTrue(createIssuePage.successfulMessage());
    }

}