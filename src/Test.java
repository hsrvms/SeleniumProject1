import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Test extends BaseDriver {

    public static void main(String[] args)  {

        driver.get("http://a.testaddressbook.com/sign_in");

        // SingIn
        WebElement email = driver.findElement(By.id("session_email"));
        email.sendKeys("hsrvms@gmail.com");
        wait(1);

        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("qwe5qweqwe");
        wait(1);

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();
        wait(1);

        // 4. step
        WebElement addressesLink = driver.findElement(By.xpath("//a[text()='Addresses']"));
        addressesLink.click();
        wait(1);
        // 5. step
        WebElement newAddressButton = driver.findElement(By.xpath("//a[text()='New Address']"));
        newAddressButton.click();
        wait(1);
        // Form filling
        WebElement firstName = driver.findElement(By.id("address_first_name"));
        firstName.sendKeys("Fernando");
        wait(1);

        // 7. step
        WebElement lastName = driver.findElement(By.id("address_last_name"));
        lastName.sendKeys("Torres");
        wait(1);

        WebElement address1 = driver.findElement(By.id("address_street_address"));
        address1.sendKeys("Anfield Rd");
        wait(1);

        WebElement address2 = driver.findElement(By.name("address[address2]"));
        address2.sendKeys("Anfield");
        wait(1);

        WebElement cityAddress = driver.findElement(By.cssSelector("#address_city"));
        cityAddress.sendKeys("Liverpool");
        wait(1);

        WebElement stateOption = driver.findElement(By.cssSelector("#address_state"));
        Select stateSelect = new Select(stateOption);
        int elementCount = stateSelect.getOptions().size();
        int randomNumber = (int) (Math.random() * elementCount);
        stateSelect.selectByIndex(randomNumber);
        wait(1);

        WebElement zipCode = driver.findElement(By.id("address_zip_code"));
        zipCode.sendKeys("L4 0TH");

        wait(1);
        WebElement unitedStatesRadioButton = driver.findElement(By.id("address_country_us"));
        unitedStatesRadioButton.click();

        // 14. step
        wait(1);
        WebElement birthDay = driver.findElement(By.id("address_birthday"));
        birthDay.sendKeys("20Mar");
        Actions action = new Actions(driver);
        action.keyDown(Keys.ARROW_RIGHT).build().perform();
        action.sendKeys("1984").build().perform();

        wait(1);
        WebElement age = driver.findElement(By.id("address_age"));
        age.sendKeys("36");

        wait(1);
        WebElement webSite = driver.findElement(By.id("address_website"));
        webSite.sendKeys("https://www.google.com/");

        WebElement phone = driver.findElement(By.id("address_phone"));
        phone.sendKeys("8625747878");
        wait(1);

        WebElement climbingCheckBox = driver.findElement(By.id("address_interest_climb"));
        climbingCheckBox.click();
        wait(1);

        WebElement dancingCheckBox = driver.findElement(By.id("address_interest_dance"));
        dancingCheckBox.click();
        wait(1);

        WebElement note = driver.findElement(By.id("address_note"));
        note.sendKeys("Never Back Down");
        wait(1);

        WebElement createAddressButton = driver.findElement(By.name("commit"));
        createAddressButton.click();
        wait(1);

        WebElement verifyFirstName = driver.findElement(By.cssSelector("span[data-test='first_name']"));
        Assert.assertEquals("Fernando", verifyFirstName.getText());

        WebElement verifyLastName = driver.findElement(By.cssSelector("span[data-test='last_name']"));
        Assert.assertEquals("Torres", verifyLastName.getText());

        WebElement addressesLink2 = driver.findElement(By.xpath("//a[text()='Addresses']"));
        addressesLink2.click();

        WebElement editButton = driver.findElement(By.xpath("//a[text()='Edit']"));
        editButton.click();


        WebElement firstName2 = driver.findElement(By.id("address_first_name"));
        firstName2.clear();
        firstName2.sendKeys("Peter");
        wait(1);

        // 7. step
        WebElement lastName2 = driver.findElement(By.id("address_last_name"));
        lastName2.clear();
        lastName2.sendKeys("Crouch");
        wait(1);

        WebElement updateAddressButton = driver.findElement(By.name("commit"));
        updateAddressButton.click();

        WebElement verifyFirstName2 = driver.findElement(By.cssSelector("span[data-test='first_name']"));
        Assert.assertEquals("Peter", verifyFirstName2.getText());


        WebElement verifyLastName2 = driver.findElement(By.cssSelector("span[data-test='last_name']"));
        Assert.assertEquals("Crouch", verifyLastName2.getText());


        WebElement addressesLink3 = driver.findElement(By.xpath("//div[@class='navbar-nav mr-auto']/a[@href='/addresses']"));
        addressesLink3.click();

        WebElement destroyButton = driver.findElement(By.xpath("//a[text()='Destroy']"));
        destroyButton.click();

        driver.switchTo().alert().accept();

        WebElement confirmDeletingAddress = driver.findElement(By.xpath("//div[text()='Address was successfully destroyed.']"));
        Assert.assertTrue(confirmDeletingAddress.getText().contains("successfully destroyed"));

        waitAndClose();
    }

}
