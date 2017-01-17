package org.reznikov.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

/**
 * Created by antonreznikov on 1/10/17.
 */
public class MyNewTest extends BaseWebDriverTest {

    public static final String INPUT_SELECTOR = "//input[contains(@class,'rz-header-search-input-text')]";
    public static final String FILTER_SELECTOR = "a.filter-active-i-link";
    public static final String IPHONE_ITEM = "//div[contains(@class,'g-i-tile g-i-tile-catalog')]//div[contains(@class,'g-i-tile-i-title')]/a[contains(text(),'Apple iPhone 7 128GB Jet Black')]";
    public static final String MEIZU_ITEM = "//div[contains(@class,'g-i-tile g-i-tile-catalog')]//div[contains(@class,'g-i-tile-i-title')]/a[contains(text(),'Meizu M2 White (Международная версия)')]";
    public static final String PUPCHASE_BUTTON = "//button[@name='topurchases']";
    public static final String CART_ITEM_LINK = "//a[@class='novisited cart-i-title-link'][@href='http://rozetka.com.ua/meizu_m2_16gb_wh_world/p6675387/']";
    public static final String CHECKOUT_BUTTON = "//button[@id='popup-checkout']";
    public static final String NEW_BUYER_LINK = "//a[@class='novisited check-tabs-m-link']";

    @Test
    public void testSite() {

        //Search for Iphone
        /*driver.findElement(By.xpath(INPUT_SELECTOR))
                .sendKeys("Iphone"+ Keys.ENTER);*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys("Iphone");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        wait.until(ExpectedConditions.textToBe(By.cssSelector(FILTER_SELECTOR), "Apple"));
        /*String result = driver.findElement(By.cssSelector(FILTER_SELECTOR)).getText();
        //Verify filter is enabled
        assert result.equals("Apple");*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys("Samsung");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        wait.until(ExpectedConditions.textToBe(By.cssSelector(FILTER_SELECTOR), "Samsung"));

        System.out.println("Test Done");

    }

    @Test
    public void testRozetka() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys("iphone 7 32gb");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IPHONE_ITEM))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PUPCHASE_BUTTON)));

//        try {
//            Thread.sleep(5000);
//        } catch (Exception e){
//
//        }


        assert driver.getCurrentUrl().equals("http://rozetka.com.ua/apple_iphone_7_128gb_jet_black/p11241577/");


    }

    @Test
    public void testRozetka2() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys("meizu");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MEIZU_ITEM))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PUPCHASE_BUTTON)));

        assert driver.getCurrentUrl().equals("http://rozetka.com.ua/meizu_m2_16gb_wh_world/p6675387/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PUPCHASE_BUTTON))).click();

        wait.until(ExpectedConditions.textToBe(By.xpath(CART_ITEM_LINK), "Meizu M2 White (Международная версия)"));

        driver.findElement(By.xpath(CHECKOUT_BUTTON)).click();


        //wait.until(ExpectedConditions.textToBe(By.cssSelector(NEW_BUYER_LINK), "Я новый покупатель"));
        assert driver.getCurrentUrl().equals("https://my.rozetka.com.ua/checkout/");


    }

}
