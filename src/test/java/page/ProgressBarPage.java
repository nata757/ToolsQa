package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarPage extends PageBase {
    WebDriver driver;
    public ProgressBarPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@id='startStopButton']")
    private WebElement startStopButton;
    @FindBy(xpath = "//div[@role='progressbar']")
    private WebElement progressbar;

    private final String ATTRIBUT_NAME = "aria-valuenow";


    public void clickToStart() {
        startStopButton.click();
    }

    public void explicitWaitPercent(String percent) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.attributeToBe(progressbar, ATTRIBUT_NAME, percent));
                //sleep(3000);
    }

    public void fluentWaitPercent(String percent) {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofNanos(2000000))
                .until(ExpectedConditions.attributeToBe(progressbar, ATTRIBUT_NAME, percent));
    }
public void clickToStop(String percent) {
     // explicitWaitPercent(percent);
        fluentWaitPercent(percent);
        startStopButton.click();
}
 public String getText() {
     return progressbar.getText();
 }


}
