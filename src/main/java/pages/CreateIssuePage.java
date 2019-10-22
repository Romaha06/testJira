package pages;

import org.openqa.selenium.*;


public class CreateIssuePage {

    WebDriver driver;
    UIutilities uIutilities;

    //Create Issue
    private By createIssueButton = By.id("create_link");
    private By projectInput = By.cssSelector("#project-field");
    private By issueTypeInput = By.id("issuetype-field");
    private By summaryInput = By.id("summary");
    private By dataModeSource = By.xpath("//li[@data-mode='source']");
    private By descriptionInput = By.xpath("//textarea[@name='description']");
    private By createButton = By.cssSelector("#create-issue-submit");
    private By issueSuccessfullyCreated = By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']");


    public CreateIssuePage(WebDriver driver) {
        this.driver = driver;
        uIutilities = new UIutilities(driver);
    }

    public void clickOnTheCreateIssueButton()  {
        uIutilities.click(createIssueButton, 3, 3);

    }

    public void fillInProjectInput(String name) {
        uIutilities.enterText(projectInput, "QAAUTO-8", 3, 3);
    }

    public void fillInIssueTypeInput(String type) {
        uIutilities.enterText(issueTypeInput, type, 3, 3);
    }

    public void fillInSummary(String text) {
        uIutilities.enterText(summaryInput, text, 3, 3);
    }

    public void fillInDescription(String text) {
        driver.findElement(dataModeSource);
        uIutilities.enterText(descriptionInput, text, 3, 3);
    }

    public void clickCreateIssue() {
        uIutilities.click(createButton, 3, 3);
    }

    public boolean successfulMessage() {
        return uIutilities.waitFor(issueSuccessfullyCreated, 3, 3).isDisplayed();
    }
}
