package org.reznikov.testing;

import org.reznikov.testing.pages.ItemsCatalog;
import org.reznikov.testing.pages.LandingPage;
import org.testng.annotations.Test;


public class MyNewTest extends BaseWebDriverTest {

    @Test
    public void testSite() {

        LandingPage page = new LandingPage(driver);
        page.openLandingPage(driver, "http://rozetka.com.ua/");
        ItemsCatalog catalog = page.getItemsCatalog();
        LandingPage itemPage = catalog.goToCategory("Сантехника и ремонт");

    }
}
