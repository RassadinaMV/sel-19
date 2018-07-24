package ru.broker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

import static junit.framework.TestCase.fail;

public class EleventhTest extends BaseTest  {

    @Test
    public void userAuth() {
        java.lang.String ss1=new java.lang.String();
        java.lang.String ss2=new java.lang.String();
        int r=Math.max((int)(Math.random()*10),5);
        ss1= UUID.randomUUID().toString().replace("-","").substring(0,r);
        ss2= UUID.randomUUID().toString().replace("-","").substring(0,5);
        java.lang.String email = ss1+"@" + ss2 + ".com";
        //2й вариант получения рандомной строки
        //ss1=Long.toHexString(Double.doubleToLongBits(Math.random())).substring(0,r);
        //3й вариант рандомной строки - описание класса RandomString скачано с qaru.site
        // RandomString ss=new RandomString(5);
        //java.lang.String email = "" + ss + ".com";

        driver.get("http://localhost/litecart/en/");

        java.lang.String firstName = "Кофе";
        java.lang.String lastName = "Крепкий";
        java.lang.String adress = "adress";
        java.lang.String Code = "123456";
        java.lang.String city = "Новосибирск";
        java.lang.String country = "Russian Federation";
        java.lang.String phone = "9139297451";
        String password = "password";


        driver.get("http://localhost/litecart/en/");

        WebElement w1 = driver.findElement( By.xpath( ".//a[text() = 'Create Account']" ) );
        w1.click();

        WebElement wfirstName = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//input[contains(@name,'firstname')]"));
        wfirstName.sendKeys(firstName);

        WebElement wlastName = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//input[contains(@name,'lastname')]"));
        wlastName.sendKeys(lastName);

        WebElement wadress = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//input[contains(@name,'address1')]"));
        wadress.sendKeys(adress);

        WebElement wpostcode = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//input[contains(@name,'postcode')]"));
        wpostcode.sendKeys(Code);

        WebElement wcity = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//input[contains(@name,'city')]"));
        wcity.sendKeys(city);

        WebElement wcntrCode = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//select[contains(@name,'country_code')]"));
        new Select( wcntrCode ).selectByVisibleText(java.lang.String.valueOf(country));

        WebElement wemail = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//input[contains(@name,'email')]"));
        wemail.sendKeys( email );

        WebElement wphone = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//input[contains(@name,'phone')]"));
        wphone.sendKeys(phone);

        WebElement wpswd = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//input[contains(@name,'password')]"));
        wpswd.sendKeys( password );

        WebElement wconfirm = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//input[contains(@name,'confirmed_password')]"));
        wconfirm.sendKeys(password);

        WebElement button = driver.findElement(By.xpath("//div[contains(@id,'create-account')]//button[contains(@name,'create_account')]"));
        button.click();

        driver.findElement( By.xpath( "//a[contains(text(),'Logout')]" ) ).click();

        /*try {
             Thread.sleep(20000);
             } catch (InterruptedException e) {
               e.printStackTrace();
             }*/

        driver.findElement( By.name( "email" ) ).sendKeys(email);
        driver.findElement( By.name( "password" ) ).sendKeys(password);
        driver.findElement( By.name( "login" ) ).click();

        driver.findElement( By.xpath("//a[contains(text(),'Logout')]")).click();

        }
}

