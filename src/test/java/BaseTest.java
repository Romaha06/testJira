import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.WebDriverFactory;

public class BaseTest {


    @BeforeTest(groups = "Regression")
    public void setUp() {
            WebDriverFactory.createInstance("chrome");

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @AfterTest(groups = "Regression")
    public void tearDown() {
        WebDriverFactory.getDriver().quit();
        // Close the driver
        //this.driver.quit();
    }
}
