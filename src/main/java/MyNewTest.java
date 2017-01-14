import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by antonreznikov on 1/10/17.
 */
public class MyNewTest {

    public static final String INPUT_SELECTOR = "//input[contains(@class,'rz-header-search-input-text')]";
    public static final String FILTER_SELECTOR = "a.filter-active-i-link";

    private WebDriver driver;
    private long startTime;

    @BeforeMethod
    public void initDriver(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/chromedriver");
        //Navigate to rozetka
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("http://rozetka.com.ua/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        startTime = Reporter.getCurrentTestResult().getStartMillis();
    }

    @Test
    public void testSite(){

        //Search for Iphone
        /*driver.findElement(By.xpath(INPUT_SELECTOR))
                .sendKeys("Iphone"+ Keys.ENTER);*/
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys("Iphone");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        wait.until(ExpectedConditions.textToBe(By.cssSelector(FILTER_SELECTOR),"Apple"));
        /*String result = driver.findElement(By.cssSelector(FILTER_SELECTOR)).getText();
        //Verify filter is enabled
        assert result.equals("Apple");*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys("Samsung");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        wait.until(ExpectedConditions.textToBe(By.cssSelector(FILTER_SELECTOR),"Samsung"));

        System.out.println("Test Done");

    }

    @AfterMethod
    public void destroyDriver(){
        if(driver!=null) {
            driver.quit();
        }

        //Reporter.log("Elapsed time: "+(Reporter.getCurrentTestResult().getEndMillis()-startTime/1000),true);
    }
}
