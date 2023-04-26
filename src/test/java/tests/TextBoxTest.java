package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TextBoxPage;

public class TextBoxTest extends TestBase{

TextBoxPage textBoxPage;
    String url = "https://demoqa.com/text-box";
    String email = faker.internet().emailAddress();
    String name = faker.name().fullName();
    String currentPermanent = faker.address().fullAddress();
    String permanentAddress = faker.address().fullAddress();


    @BeforeMethod
    public void openUrl(){
        driver.get(url);

    }
    @Test
    public void  textBoxTest() {
        textBoxPage = new TextBoxPage(driver); //создает экземпляр класса
        textBoxPage.fillTextBox(name, email, currentPermanent, permanentAddress);
        Assert.assertTrue(textBoxPage.getResultText("name").contains(name));
        Assert.assertEquals(textBoxPage.getResultText("name"), "Name:"+ name);


    }
}

