package ru.broker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SeventhTestFailed extends BaseTest {

    @Test
    public void leftSideClick() {

        driver.get("http://localhost/litecart/admin/");
        //driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        // driver.findElement(By.xpath("//*[contains(text(),'Statistics')]"));
        List<WebElement> elmts= driver.findElement(By.id("box-apps-menu-wrapper")).findElements(By.cssSelector("a"));
        int hh=elmts.size();
        for (int i=0; i<hh;i++) {
            System.out.println(i);
            elmts.get(i).click();
            wait.until(ExpectedConditions.elementToBeClickable(elmts.get(i)));
            List<WebElement> elmts2= driver.findElements(By.cssSelector(".docs a"));
            int gg=elmts2.size();
            if (gg>0)
            {
                for (int j=0;j<gg;j++)
                {
                    elmts2.get(j).click();
                    wait.until(ExpectedConditions.elementToBeClickable(elmts2.get(j)));
                    if (j>0) {driver.navigate().back();}
                }
            }


            driver.navigate().back();
            //driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        }

    }

}
