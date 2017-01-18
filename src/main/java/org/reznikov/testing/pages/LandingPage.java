package org.reznikov.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by antonreznikov on 1/17/17.
 */
public class LandingPage {


    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public ItemsCatalog getItemsCatalog() {
        return new ItemsCatalog(driver);
    }

    public void openLandingPage(WebDriver driver, String url) {
        this.driver.get(url);
    }
}
