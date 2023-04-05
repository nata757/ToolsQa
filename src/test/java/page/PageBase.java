package page;

import io.netty.handler.codec.AsciiHeadersEncoder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class PageBase {

    WebDriver driver;
    public PageBase (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void click(WebElement element) {
        element.click();
     }
    public void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }


    public String getOriginalWindow(){
        return driver.getWindowHandle();
    }
    public void switchToNewTabOrWindow(String originalWindow){
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles){
            if(!originalWindow.equals(handle)){
                driver.switchTo().window(handle);
                break;
            }
        }
    }

   public void closeAndSwitchOriginalWindow(String originaWindow){
        driver.close();
        driver.switchTo().window(originaWindow);
   }
}

