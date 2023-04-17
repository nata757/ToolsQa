package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DynamicProperties;
import page.ProgressBarPage;

public class TestDynamicProperties extends TestBase{

DynamicProperties dynamicProperties;
    String url = "https://demoqa.com/dynamic-properties";

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }
    @Test
    public void DynamicProperties() {
        dynamicProperties = new DynamicProperties(driver);
        dynamicProperties.clickButton();

    }
    @Test
    public void DynamicProperties2() {
        dynamicProperties = new DynamicProperties(driver);
        dynamicProperties.colorButton();

    }
    @Test
    public void DynamicProperties3() {
        dynamicProperties = new DynamicProperties(driver);
        dynamicProperties.visibleButton();

    }
}
