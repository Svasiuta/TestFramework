package org.reznikov.testing.pages;


import org.openqa.selenium.WebDriver;


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
