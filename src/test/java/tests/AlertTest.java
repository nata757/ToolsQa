package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AlertPage;

public class AlertTest extends TestBase {
    AlertPage alertPage;
    String alertExpectedText = "This alert appeared after 5 seconds";
    String alertActualText;
    String url = "https://demoqa.com/alerts";
    @BeforeMethod
    public void openUrl(){
        driver.get(url);

        }

    @Test
    public void timerAlertTest(){
        alertPage = new AlertPage(driver);
        alertPage.clickTimerAlertButton();
        alertActualText = alertPage.getAlertText();
        Assert.assertEquals(alertActualText,alertExpectedText);

    }

}
