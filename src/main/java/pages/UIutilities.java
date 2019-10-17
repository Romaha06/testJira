package pages;

import org.openqa.selenium.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class UIutilities {

    WebDriver driver;

    public UIutilities(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By element, int retry, int timeoutSeconds) {
        //TODO workaround for strange glitch - we use ID selector, but see that selenium used CSS selector
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = retry; i > 0; i--) {
            try {
                System.out.println("Searching element" + element.toString() + ". Retry - " + (retry - i));
                driver.findElement(element).click();
                break;
            } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException ex) {
                try {
                    System.out.println("Searching element" + element.toString() + ". Retry - " + (retry - i));
                    Thread.sleep(TimeUnit.SECONDS.toMillis(timeoutSeconds));
                    driver.findElement(element).click();
                    break;
                } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException | InterruptedException ex2) {
                    if (i == 0) {
                        try {
                            throw new Exception("Failed to find element " + element.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    continue;
                }
            }
        }
    }

    protected void enterText(By element, String text, int retry, int timeoutSeconds) {
        //TODO workaround for strange glitch - we use ID selector, but see that selenium used CSS selector
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = retry; i > 0; i--) {
            try {
                System.out.println("Searching element" + element.toString() + ". Retry - " + (retry - i));
                driver.findElement(element).sendKeys(text);
                break;
            } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException ex) {
                try {
                    System.out.println("Searching element" + element.toString() + ". Retry - " + (retry - i));
                    Thread.sleep(TimeUnit.SECONDS.toMillis(timeoutSeconds));
                    driver.findElement(element).sendKeys(text);
                    break;
                } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException | InterruptedException ex2) {
                    if (i == 0) {
                        try {
                            throw new Exception("Failed to find element " + element.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    continue;
                }
            }
        }
    }

    protected WebElement waitFor(By element, int retry, int timeoutSeconds) {
        for (int i = retry; i > 0; i--) {
            try {
                driver.findElement(element);
            } catch (Exception ex) {
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(timeoutSeconds));
                    driver.findElement(element);
                } catch (Exception ex2) {
                    System.out.println("Searching element" + element.toString() + ". Retry - " + (retry - i));
                    continue;
                }
            }
            return driver.findElement(element);
        }
        return driver.findElement(element);
    }

}
