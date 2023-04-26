package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SelectPage;

public class SelectTest extends TestBase{
    SelectPage selectPage;
    String selectValue = "Blue";
    String url = "https://demoqa.com/select-menu";
    @BeforeMethod
    public void openUrl(){
        driver.get(url);

    }
    @Test
    public void setSelectTest(){
        selectPage = new SelectPage(driver);
        selectPage.getSelect(selectValue);
        System.out.println("Natawka");

    }
}
