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

    //5. В тестовом классе объявить переменныю String expectedTextForConfirm,
    // которая будет равна "You selected Ok" и String actualTextForConfirm
    String expectedTextForConfirmOk = "You selected Ok";
    String expectedTextForConfirmCancel = "You selected Cancel";
    String actualTextForConfirmOk;
    String actualTextForConfirmCancel;
    String promptText = "Selenium Natalie";
    String expectedPromptText = "You entered " + promptText;


    @BeforeMethod
    public void openUrl(){
        driver.get(url);

        }

    @Test
    public void timerAlertTest(){
        alertPage = new AlertPage(driver);//создаем экземпляр alert Page страницы
        alertPage.clickTimerAlertButton();
        alertActualText = alertPage.getAlertText();
        Assert.assertEquals(alertActualText,alertExpectedText);
    }


    // 6.Создать тестовый метод в котором, создать экземпляр POM
    @Test
    public void confirmAlertTest1(){
        alertPage = new AlertPage(driver);//создаем экземпляр alert Page страницы
        alertPage.clickConfirmBox();//7.Вызвать метод, который кликает по кнопке
        alertPage.clickToOk();//8. Вызвать метод, который нажимает кнопку ok
        actualTextForConfirmOk= alertPage.getConfirmText(); //9.Записать в переменную actualTextForConfirm текст из веб-элемента у надписи
                                       // "On button click, confirm box will appear" (с помощью метода, который сделали на 4 шаге)

        Assert.assertEquals(actualTextForConfirmOk, expectedTextForConfirmOk);//10. Сделать проверку,
                                                                            // что actualTextForConfirm и expectedTextForConfirm равны
    }
    @Test
    public void confirmAlertTest2(){
        alertPage = new AlertPage(driver);
        alertPage.clickConfirmBox();
        alertPage.clickToCancel();
        actualTextForConfirmCancel = alertPage.getConfirmText();
        Assert.assertEquals(actualTextForConfirmCancel, expectedTextForConfirmCancel);
    }
    @Test
    public void promptAlertTest(){
        alertPage = new AlertPage(driver);
        alertPage.clickPrompt();
        alertPage.clickPromptOk(promptText);
        alertActualText = alertPage.getPromptText();
        Assert.assertEquals(alertActualText, expectedPromptText);
    }
}
