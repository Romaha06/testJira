import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.LoginPage;
import utils.WebDriverFactory;

public class JIRATest extends BaseTest {


    @DataProvider(name = "data-provider")
    public Object[][] dataProviderData(){
        return new Object[][]{
                {"Roman_Chelombitko", "Roman"},
                {"Roman_Chelombitko", "Chelombitko"},
                {"Roman_Chelombitko", "Chel"},
                {"Roman_Chelombitko", "Chelom"}
        };
    }

    @Feature(" Unsuccessful lLogin Test")
    @Test(groups = {"Regression"},dataProvider="data-provider")
    public void  unsuccessfullLoginTest(String userName,String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.Login(userName, password);
        Assert.assertEquals(loginPage.errorMassage(), "Sorry, your username and password are incorrect - please try again.");
    }

    @Feature("Login Success")
    @Test(groups = {"Smoke"})
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.Login("Roman_Chelombitko", "Roman_Chelombitko");
        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
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