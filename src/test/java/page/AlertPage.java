package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.PageBase;

import java.time.Duration;

public class AlertPage extends PageBase {
    public AlertPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[@id=\"timerAlertButton\"]")
    private WebElement timerAlertButton;

// 1.В POM описать веб-элименты кнопки Click me и поля, где появляется ожидаемый текст ("You selected Ok")
    @FindBy(xpath = "//button[@id='confirmButton']")
    private WebElement confirmBox;
    @FindBy(xpath = "//span[@id='confirmResult']")
    private WebElement confirmResult;

@FindBy(xpath = "//button[@id='promtButton']")
private WebElement promptButton;
@FindBy(xpath = "//span[@id='promptResult']")
private WebElement promptResult;



    public void clickTimerAlertButton() {
        timerAlertButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.alertIsPresent());

    }
    //2.Написать метод, который кликает по кнопке Click me и ждет появления alert
    public void clickConfirmBox() {
        confirmBox.click();
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.alertIsPresent());

    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();

    }
//3.Написать метод, который нажимает на кнопку ok в alert (первая строчка в этом методе должна метод содержать переключения на alert)
   public void clickToOk(){
       Alert alert = driver.switchTo().alert();// записали метод переключения на alert
       alert.accept();// нажимает на кнопку ок

   }
   //4.Написать метод, который возвращает текст из веб-элемента, в котором появляется текст
    public String getConfirmText (){
        return confirmResult.getText();
    }

    public void clickToCancel(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void clickPrompt() {
        promptButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());

    }
    public void clickPromptOk(String text){
        Alert alert = driver.switchTo().alert();// записали метод переключения на alert
        alert.sendKeys(text);
        alert.accept();// нажимает на кнопку ок
    }
    public String getPromptText (){
        return promptResult.getText();
    }


}
