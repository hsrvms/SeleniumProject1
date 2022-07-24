

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Proje2 extends BaseDriver {
    public static void main(String[] args) {

        driver.get("http://a.testaddressbook.com/sign_in");

        WebElement userName = driver.findElement(By.id("session_email"));
        WebElement password = driver.findElement(By.id("session_password"));
        WebElement singIn = driver.findElement(By.cssSelector("[value='Sign in']"));

        userName.sendKeys("group18@technostudy.com");
        wait(1);
        password.sendKeys("12345678");
        wait(1);
        singIn.click();
        wait(1);

        WebElement adress = driver.findElement(By.xpath("//*[text()='Addresses']"));
        adress.click();
        wait(1);
        WebElement newAdress = driver.findElement(By.xpath("//*[text()='New Address']"));
        newAdress.click();
        wait(1);
        WebElement firstName = driver.findElement(By.id("address_first_name"));
        firstName.sendKeys("Fernando");
        wait(1);
        WebElement lastName = driver.findElement(By.id("address_last_name"));
        lastName.sendKeys("Torres");
        wait(1);
        WebElement adres1 = driver.findElement(By.cssSelector("[id='address_street_address']"));
        adres1.sendKeys("Anfield Rd");
        wait(1);
        WebElement adres2 = driver.findElement(By.id("address_secondary_address"));
        adres2.sendKeys("Anfield");
        wait(1);
        WebElement city = driver.findElement(By.cssSelector("[id='address_city']"));
        city.sendKeys("Liverpool");
        wait(1);

        WebElement state = driver.findElement(By.id("address_state"));
        Actions aksiyonlar = new Actions(driver);
        Action aksiyon = aksiyonlar.moveToElement(state).click().build();
        aksiyon.perform();
        wait(1);
        aksiyon = aksiyonlar.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build();
        aksiyon.perform();

        wait(1);

        WebElement zipCode = driver.findElement(By.id("address_zip_code"));
        zipCode.sendKeys("L4 0TH");
        wait(1);

        WebElement country = driver.findElement(By.id("address_country_us"));
        country.click();

        WebElement birtday = driver.findElement(By.id("address_birthday"));
        birtday.sendKeys("20031984");
        wait(1);

        WebElement age = driver.findElement(By.id("address_age"));
        age.sendKeys("36");
        wait(1);

        WebElement webSite = driver.findElement(By.id("address_website"));
        webSite.sendKeys("https://www.google.com/");
        wait(1);

        WebElement phone = driver.findElement(By.id("address_phone"));
        phone.sendKeys("8625747878");
        wait(1);

        WebElement climb = driver.findElement(By.id("address_interest_climb"));
        climb.click();
        wait(1);

        WebElement dancing = driver.findElement(By.id("address_interest_dance"));
        dancing.click();
        wait(1);

        WebElement note = driver.findElement(By.id("address_note"));
        note.sendKeys("Never Back Down");
        wait(1);

        WebElement commit = driver.findElement(By.cssSelector("[name='commit']"));
        commit.click();
        wait(1);


        WebElement ctrlName = driver.findElement(By.xpath("//*[@data-test='first_name']"));
        Assert.assertTrue(ctrlName.getText().contains("Fernando"));
        WebElement ctrlSName = driver.findElement(By.xpath("//*[@data-test='last_name']"));
        Assert.assertTrue(ctrlSName.getText().contains("Torres"));
        wait(1);

        WebElement adresses2 = driver.findElement(By.xpath("//*[text()='Addresses']"));
        adresses2.click();
        wait(1);

        WebElement edit = driver.findElement(By.xpath("//*[text()='Edit']"));
        edit.click();
        wait(1);

        WebElement firstName2 = driver.findElement(By.id("address_first_name"));
        firstName2.clear();
        wait(1);
        firstName2.sendKeys("Peter");
        wait(1);
        WebElement lastName2 = driver.findElement(By.id("address_last_name"));
        lastName2.clear();
        wait(1);
        lastName2.sendKeys("Crouch");
        wait(1);

        WebElement updateAdress = driver.findElement(By.xpath("//*[@data-test='submit']"));
        updateAdress.click();
        wait(1);

        WebElement ctrlName2 = driver.findElement(By.xpath("//*[@data-test='first_name']"));
        Assert.assertTrue(ctrlName2.getText().contains("Peter"));
        WebElement ctrlSName2 = driver.findElement(By.xpath("//*[@data-test='last_name']"));
        Assert.assertTrue(ctrlSName2.getText().contains("Crouch"));
        wait(1);

        WebElement adresses3 = driver.findElement(By.xpath("//*[text()='Addresses']"));
        adresses3.click();
        wait(1);

        WebElement destroy = driver.findElement(By.xpath("//*[text()='Destroy']"));
        destroy.click();
        wait(1);

        driver.switchTo().alert().accept();

        WebElement confirmation = driver.findElement(By.xpath("//*[@data-test='notice']"));
        Assert.assertTrue(confirmation.getText().contains("Address was successfully destroyed."));
        wait(1);

        waitAndClose();
    }
}
