package org.reznikov.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by antonreznikov on 1/17/17.
 */
public class ItemsCatalog extends LandingPage {

    public static final String CATEGORY_FIRST = "//*[@data-title='";
    public static final String CATEGORY_SECOND = "']";

    public ItemsCatalog(WebDriver driver) {
        super(driver);

    }

    public Actions selectCategory(String category) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(CATEGORY_FIRST + category + CATEGORY_SECOND))).click().build().perform();
        return actions;
    }

    public LandingPage goToCategory(String category) {

        Actions testAction = selectCategory(category);
        testAction.click().build().perform();
        return new LandingPage(driver);
    }
}
