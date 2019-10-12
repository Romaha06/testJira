package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static pages.PageURLs.loginPage;


public class LoginPage {

    WebDriver driver = null;


    //login
    private By userNameInput = By.xpath("//input[@name='os_username']");
    private By passwordInput = By.xpath("//input[@name='os_password']");
    private By loginButton = By.xpath("//input[@name='login']");
    private By wrongPasswordLabel = By.xpath("//div[@class='aui-message aui-message-error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(loginPage);
    }

    public void enterUserName(String name) {
        driver.findElement(userNameInput).sendKeys(name);
    }

    public void enterPasswordName(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void Login(String name, String password) {
        enterUserName(name);
        enterPasswordName(password);
        clickLogin();
    }

    public String errorMassage(){
        return driver.findElement(wrongPasswordLabel).getText();
    }
}
