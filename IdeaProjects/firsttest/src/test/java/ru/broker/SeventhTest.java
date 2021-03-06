package ru.broker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class SeventhTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
//        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
       driver=new ChromeDriver();
        wait=new WebDriverWait(driver,10);
    }

    @Test
    public void loginLitecardAdmin() {

        driver.get("http://localhost/litecart/admin/");
        //driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
       // driver.findElement(By.xpath("//*[contains(text(),'Statistics')]"));
        //List<WebElement> elmts= driver.findElement(By.id("box-apps-menu-wrapper")).findElements(By.cssSelector("a"));
        int hh=driver.findElement(By.id("box-apps-menu-wrapper")).findElements(By.cssSelector("a")).size();
        System.out.println(hh);
        for (int i=0; i<hh;i++) {
            System.out.println(i);
            WebElement elmts2=driver.findElement(By.id("box-apps-menu-wrapper")).findElements(By.cssSelector("a")).get(i);
            elmts2.click();
            //wait.until(ExpectedConditions.elementToBeClickable(elmts.get(i)));
            //elmts.get(i).click();
            //List<WebElement> elmts4= driver.findElements(By.cssSelector(".docs a"));
            int gg=driver.findElements(By.cssSelector(".docs a")).size();
            if (gg>0)
            {  System.out.println(gg);
                for (int j=0;j<gg;j++)
                {
                    //elmts4.get(j).click();
                    WebElement elmts3=driver.findElements(By.cssSelector(".docs a")).get(j);
                    elmts3.click();
                    if (j>0) {driver.navigate().back();}
                }
            }
            driver.navigate().back();
            //driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        }

    }

    @After
    public void stop() {

        driver.quit();
        driver = null;

    }
}
