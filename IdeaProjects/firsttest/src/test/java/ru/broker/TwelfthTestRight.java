package ru.broker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class TwelfthTestRight extends BaseTest {


    @Test
    public void workWithTheBasket() {
        driver.navigate().to("http://localhost/litecart/");

        for (int i = 0; i <= 2; i++) {
            driver.findElements(By.className("product")).get(i).click();
            if (isElementPresent(driver, tagName("select"))) {
                Select select = new Select(driver.findElement(tagName("select")));
                select.selectByIndex(1);
            }
            driver.findElement(cssSelector("[name='add_cart_product']")).click();
            wait.until(textToBe(cssSelector("span.quantity"), String.valueOf(i)));
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.navigate().to("http://localhost/litecart/");
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("a.link[href='http://localhost/litecart/en/checkout']")).click();



        Integer row = driver.findElements(By.cssSelector("td.item")).size();
        for (int i = 1; i <= row; i++) {
            WebElement removeButton = driver.findElement(By.cssSelector("[name='remove_cart_item']"));
            removeButton.click();
            try {
                Thread.sleep(40000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        Assert.assertTrue(isElementPresent(driver, tagName("em")));

    }

}

