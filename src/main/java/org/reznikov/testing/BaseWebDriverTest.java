package org.reznikov.testing;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class BaseWebDriverTest {
    public WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

//    @AfterMethod
//    public void destroyDriver() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
