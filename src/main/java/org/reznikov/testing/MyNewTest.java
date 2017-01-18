package org.reznikov.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.reznikov.testing.pages.ItemsCatalog;
import org.reznikov.testing.pages.LandingPage;
import org.testng.annotations.Test;

/**
 * Created by antonreznikov on 1/10/17.
 */
public class MyNewTest extends BaseWebDriverTest {

    @Test
    public void testSite() {

        LandingPage page = new LandingPage(driver);
        ItemsCatalog catalog = page.getItemsCatalog();
        LandingPage itemPage = catalog.goToCategory("Сантехника и ремонт");
    }
}
