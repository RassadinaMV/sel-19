package ru.broker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeventhTestV1 extends BaseTest {

    @Test
    public void leftSideClick() {

        driver.get("http://localhost/litecart/admin/");
        //driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        int hh=driver.findElement(By.id("box-apps-menu-wrapper")).findElements(By.cssSelector("a")).size();
        for (int i=0; i<hh;i++) {
            WebElement elmts2=driver.findElement(By.id("box-apps-menu-wrapper")).findElements(By.cssSelector("a")).get(i);
            int hh2=driver.findElement(By.id("box-apps-menu-wrapper")).findElements(By.cssSelector("a")).size();
            elmts2.click();
            driver.findElement(By.tagName("h1"));
            int gg=i+hh2-hh;
            for (int j=i+1;j<gg+1;j++)
            {
                WebElement elmts3=driver.findElement(By.id("box-apps-menu-wrapper")).findElements(By.cssSelector("a")).get(j);
                elmts3.click();
                driver.findElement(By.tagName("h1"));
            }
            //driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        }

    }

}
