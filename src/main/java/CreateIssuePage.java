import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CreateIssuePage {

    private WebDriver driver;

    public CreateIssuePage(WebDriver driver) {
        this.driver = driver;
    }

    private By createIssueButton = By.id("create_link");
    private By projectInput = By.cssSelector("#project-field");
    private By issueTypeInput = By.cssSelector("#issuetype-field");
    private By summaryInput = By.cssSelector("#summary");
    private By dataModeSource = By.xpath("//li[@data-mode='source']");
    private By descriptionInput = By.xpath("//textarea[@name='description']");
    private By createButton = By.cssSelector("#create-issue-submit");
    private By issueSuccessfullyCreated = By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']");

    public void clickOnTheCreateIssueButton(){
        driver.findElement(createIssueButton).click();
    }

    private void clearProject() {
        driver.findElement(projectInput).clear();
    }

    public void fillInProjectInput(){
        clearProject();
        driver.findElement(projectInput).sendKeys("QAAUTO-8", Keys.ENTER);
    }

    private void clearissueType(){
        driver.findElement(issueTypeInput).clear();
    }

    public void fillInIssueTypeInput(){
        clearissueType();
        driver.findElement(issueTypeInput).sendKeys("Test", Keys.ENTER);
    }
    public void fillInSummary(){
        driver.findElement(summaryInput).sendKeys("This is an automatic test.");
    }
    private void switchToText(){
        driver.findElement(dataModeSource);
    }

    public void fillInDescription(){
        switchToText();
        driver.findElement(descriptionInput).sendKeys("This is an automatic test.");
    }
    public void createIssue(){
        driver.findElement(createButton).click();
    }

    public boolean successfulMessage(){
       return driver.findElement(issueSuccessfullyCreated).isDisplayed();
    }
}
