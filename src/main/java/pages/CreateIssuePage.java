package pages;

import org.openqa.selenium.*;


public class CreateIssuePage {

    WebDriver driver;
    CammonAction commonActions;

    //Create Issue
    private By createIssueButton = By.xpath("//a[@id='create_link']");
    private By projectInput = By.xpath("//input[@id='project-field']");
    private By issueTypeInput = By.xpath("//input[@id='issuetype-field']");
    private By summaryInput = By.xpath("//input[@id='summary']");
    private By dataModeSource = By.xpath("//li[@data-mode='source']");
    private By descriptionInput = By.xpath("//textarea[@name='description']");
    private By createButton = By.xpath("//input[@id='create-issue-submit']");
    private By issueSuccessfullyCreated = By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']");


    public CreateIssuePage(WebDriver driver) {
        this.driver = driver;
        commonActions = new CammonAction(driver);
    }

    public void clickOnTheCreateIssueButton() {
        commonActions.click(createIssueButton, 3, 10);
    }

    public void fillInProjectInput(String name) {
        commonActions.enterText(projectInput, "QAAUTO-8", 3, 10);
    }

    public void fillInIssueTypeInput(String type) {
        commonActions.enterText(issueTypeInput, type, 3, 10);
    }

    public void fillInSummary(String text) {
        commonActions.enterText(summaryInput, text, 3, 10);
    }

    public void fillInDescription(String text) {
        driver.findElement(dataModeSource);
        commonActions.enterText(descriptionInput, text, 3, 10);
    }

    public void clickCreateIssue() {
        commonActions.click(createButton, 3, 10);
    }

    public boolean successfulMessage() {
        return commonActions.waitFor(issueSuccessfullyCreated, 3, 3).isDisplayed();
    }
}
