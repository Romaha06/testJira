import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameInput = By.xpath("//input[@name='os_username']");
    private By passwordInput = By.xpath("//input[@name='os_password']");
    private By loginButton = By.xpath("//input[@name='login']");
    private By wrongPasswordLabel = By.xpath("//div[@class='aui-message aui-message-error']");


    private void setUserName (String userName){
        driver.findElement(userNameInput).sendKeys(userName);
    }
    private void setPasswordWrong (String passwordWrong){
        driver.findElement(passwordInput).sendKeys(passwordWrong);
    }
    private void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void inputData(String userName, String passwordWrong){
        setUserName(userName);
        setPasswordWrong(passwordWrong);
        clickLoginButton();
    }
    public String errorMassage(){
        return driver.findElement(wrongPasswordLabel).getText();
    }
}
