import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

public class TestLogin extends BasePage {

    WebDriver driver;


    @Test
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.Login("Roman_Chelombitko", "Roman_Chelombitko");
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
    }

    @Test
    public void testLoginWrongLassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.Login("Roman_Chelombitko", "1235648");
        Assert.assertEquals(loginPage.errorMassage(), "Sorry, your username and password are incorrect - please try again.");
    }
}
