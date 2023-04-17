package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class DynamicProperties extends PageBase {

    public DynamicProperties (WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@id='enableAfter']")
    private WebElement enableButton;
    @FindBy(xpath = "//button[@id='colorChange']")
    private WebElement colorButton;

    @FindBy(xpath = "//button[@id='visibleAfter']")
    private  WebElement visibleButton;



public void clickButton (){
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.elementToBeClickable(enableButton));
}
    public void colorButton (){
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.attributeToBe(colorButton,"class", "mt-4 text-danger btn btn-primary"));
    }
    public void visibleButton (){
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOf(visibleButton));
    }

}
