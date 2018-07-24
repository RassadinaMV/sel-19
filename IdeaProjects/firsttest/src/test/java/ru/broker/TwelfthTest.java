package ru.broker;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.fail;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TwelfthTest extends BaseTest {


    @Test
    public void Basket() {
        driver.get("http://localhost/litecart/en/");

       // for (int i = 1; i <= 2; i++) {
            //через product поиск не отрабатывает в различных вариантах, потому используется 'box-campaigns'
            driver.findElement(By.xpath("//div[contains(@id,'box-most-popular')]//a")).click();
            //driver.findElement(By.className("product")).click();
            //driver.findElement(By.xpath("//*[contains(@class,'product')]//a")).click();
            //driver.findElement(By.xpath("//div[contains(@class,'content')]//a")).click();
           // driver.findElement(By.xpath("//div[contains(@id,'box-campaigns')]//a")).click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            driver.findElement(cssSelector("[name='add_cart_product']")).click();
            try {
            Thread.sleep(20000);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }


            driver.navigate().back();

        driver.findElement(By.xpath("//div[contains(@id,'box-campaigns')]//a")).click();


        if (isElementPresent(driver, tagName("select"))) {
            Select select = new Select(driver.findElement(tagName("select")));
            select.selectByIndex(1);
        }
        driver.findElement(cssSelector("[name='add_cart_product']")).click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.navigate().back();

        driver.findElement(By.xpath("//div[contains(@id,'cart')]//a")).click();
       try {
             Thread.sleep(20000);
             } catch (InterruptedException e) {
               e.printStackTrace();
             }


        Integer row =driver.findElements(By.xpath("//li[contains(@class,'item')]")).size();
        for (int i = 1; i <= row; i++) {
            WebElement removeButton = driver.findElement(cssSelector("[name='remove_cart_item']"));
            removeButton.click();
            //wait.until(stalenessOf(removeButton));
        }
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        org.junit.Assert.assertTrue(isElementPresent(driver, tagName("em")));
        //if (!isElementPresent(driver, tagName("em"))){fail("");};

    }

}
