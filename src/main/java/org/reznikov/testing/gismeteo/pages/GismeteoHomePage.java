package org.reznikov.testing.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by antonreznikov on 1/21/17.
 */
public class GismeteoHomePage {

    private static final String SEARCH = "";
    private static final String AUTOCOMPLETE = "";
    private static final String ENV = "https://www.gismeteo.ua/";
    protected WebDriver driver;
    protected WebDriverWait wait;
    private long DEFAULT_TIMEOUT = 5;

    public GismeteoHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,DEFAULT_TIMEOUT);
        driver.get(ENV);
    }

    public void searchForCity(String city){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH))).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AUTOCOMPLETE))).click();
    }

}
