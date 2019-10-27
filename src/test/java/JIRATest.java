import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.LoginPage;
import utils.WebDriverFactory;

public class JIRATest extends BaseTest {

    @Feature("Login Success")
    @Test(groups = {"Smoke"})
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.Login("Roman_Chelombitko", "Roman_Chelombitko");
        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
    }

    @Feature("Login Wrong")
    @Test(groups = {"Regression", "SKIP"})
    public void testLoginWrongLassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.Login("Roman_Chelombitko", "1235648");
        Assert.assertEquals(loginPage.errorMassage(), "Sorry, your username and password are incorrect - please try again.");
    }

    @Feature("Issue")
    @Test(groups = {"Regression"})
    public void createIssurTest()  {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.Login("Roman_Chelombitko", "Roman_Chelombitko");
        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
        CreateIssuePage createIssuePage = new CreateIssuePage();
        createIssuePage.clickOnTheCreateIssueButton();
        createIssuePage.fillInProjectInput("QAAUT-8");
        createIssuePage.fillInIssueTypeInput("Test");
        createIssuePage.fillInSummary("This is an automatic test.");
        createIssuePage.fillInDescription("This is an automatic test.");
        createIssuePage.clickCreateIssue();
        Assert.assertTrue(createIssuePage.successfulMessage());
    }
}