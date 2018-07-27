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

         for (int i=0;i<3;i++) {
             driver.get("http://localhost/litecart/en/");
             driver.findElements(By.xpath("//*[contains(@class,'product')]")).get(i).click();
             if (isElementPresent(driver, tagName("select"))) {
                 Select select = new Select(driver.findElement(tagName("select")));
                 select.selectByIndex(1);
             }
             driver.findElement(By.xpath("//button[contains(@name,'add_cart_product')]")).click();
             wait.until(textToBe((By.xpath("/a/span[contains(@class,'quantity')]")), String.valueOf(i)));
             try {
                 Thread.sleep(10000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]//a")).click();
       try {
             Thread.sleep(20000);
             } catch (InterruptedException e) {
               e.printStackTrace();
             }


        int h =driver.findElements(By.xpath("//input[contains(@name,'quantity')]")).size();


        for (int i=0;i<h;i++){
            WebElement b=driver.findElement(By.xpath("//button[contains(@name,'remove_cart_item')]"));
            b.click();
            wait.until(stalenessOf(b));
            

        }

        org.junit.Assert.assertTrue(isElementPresent(driver, tagName("em")));
        //if (!isElementPresent(driver, tagName("em"))){fail("");};

    }

}
