package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ProgressBarPage;

import java.sql.SQLOutput;

public class ProgressBarTest extends TestBase{
    ProgressBarPage progressBarPage;

    String url = "https://demoqa.com/progress-bar";
    String percent = Integer.toString(faker.number().numberBetween(10, 99));

    String expectedprogressValue = percent + "%";
    String actvalProgressValue;
    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }
@Test
    public void progressBarTest() {
        progressBarPage = new ProgressBarPage(driver);
        progressBarPage.clickToStart();
        progressBarPage.clickToStop(percent);
        actvalProgressValue = progressBarPage.getText();
    Assert.assertEquals(actvalProgressValue, expectedprogressValue);
    System.out.println(percent);
}


}
