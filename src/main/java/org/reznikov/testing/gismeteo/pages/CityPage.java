package org.reznikov.testing.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by antonreznikov on 1/21/17.
 */
public class CityPage extends GismeteoHomePage {
    private static final String THREE_DAYS_VIEW_TAB = " ";
    private static final String MONTH_VIEW_TAB = " ";
    private static final String TWO_WEEKS_VIEW_TAB = " ";

    public CityPage(WebDriver driver) {
        super(driver);
    }

    public ThreeDaysView switchToThreeDayView(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(THREE_DAYS_VIEW_TAB))).click();
        return new ThreeDaysView(driver);
    }

    public MonthView swithchToMonthView(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MONTH_VIEW_TAB))).click();
        return new MonthView(driver);
    }
    public TwoWeeksView swithchToTwoWeeksViewView(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TWO_WEEKS_VIEW_TAB))).click();
        return new TwoWeeksView(driver);
    }
}
