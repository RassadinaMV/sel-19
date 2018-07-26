package ru.broker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;



public class ThirteenthTest extends BaseTest {


    @Test
    public void addItem() {
        BaseTest.loginToAdm();
        String desc="описание";
        String name="name999";
        driver.findElement(By.xpath("//span[text() = 'Catalog']")).click();
        driver.findElement(By.xpath("//a[. = ' Add New Product']")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.xpath("//input[@name = 'name[en]']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name = 'code']")).sendKeys("456789");
        driver.findElements(By.xpath("//input[@name = 'categories[]']")).get(1).click();
        driver.findElements(By.xpath("//input[@name = 'product_groups[]']")).get(1).click();
        driver.findElement(By.xpath("//input[@name = 'quantity']")).sendKeys("10");

        LocalDate ss= LocalDate.now();
        String ss1="10";
        String ss2="20";
        int yy=ss.getYear();
        int mm=ss.getMonthValue();
        if (mm<10){
            ss1=ss1+".0"+Integer.toString(mm)+"."+Integer.toString(yy);
            ss2=ss2+".0"+Integer.toString(mm)+"."+Integer.toString(yy);
        }

        if (mm>=10){
            ss1=ss1+"."+mm+"."+yy;
            ss2=ss2+"."+mm+"."+yy;
        }

        driver.findElement(By.xpath("//input[@name = 'date_valid_from']")).sendKeys(ss1);
        driver.findElement(By.xpath("//input[@name = 'date_valid_to']")).sendKeys(ss2);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File fl = new File("src/test/java/mess/smile.jpg");
        driver.findElement(By.name("new_images[]")).sendKeys(fl.getAbsolutePath());

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//a[text() = 'Information']")).click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select sl=new Select(driver.findElement(By.xpath("//select[@name ='manufacturer_id']")));
        sl.selectByIndex(1);
        driver.findElement(By.xpath("//input[@name = 'keywords']")).sendKeys(ss2);
        driver.findElement(By.xpath("//input[@name = 'short_description[en]']")).sendKeys(desc);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//a[text() = 'Prices']")).click();
        driver.findElement(By.xpath("//input[@name = 'purchase_price']")).sendKeys("88");

        Select sl1=new Select(driver.findElement(By.xpath("//select[@name ='purchase_price_currency_code']")));
        sl1.selectByIndex(1);

        driver.findElement(By.xpath("//input[@name = 'gross_prices[USD]']")).sendKeys("88");
        driver.findElement(By.xpath("//input[@name = 'gross_prices[EUR]']")).sendKeys("88");
        driver.findElement(By.xpath("//button[@name = 'save']")).click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.linkText(name));


    }
}
