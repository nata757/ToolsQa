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


    @FindBy(xpath = "//button[@id='confirmButton']")
    private WebElement confirmBox;



    public void clickTimerAlertButton() {
        timerAlertButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.alertIsPresent());

    }

    public void clickConfirmBox() {
        confirmBox.click();
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.alertIsPresent());

    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();

    }

   public void clickToOk(){
       Alert alert = driver.switchTo().alert();
       alert.accept();
   }
    public void clickToCancel(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
