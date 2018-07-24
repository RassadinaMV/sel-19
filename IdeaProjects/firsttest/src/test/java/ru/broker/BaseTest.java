package ru.broker;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void setup() {
        //System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver,10);
    }

    public static void loginToAdm() {
        driver.get("http://localhost/litecart/admin/");
        //driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public static String getRandomString (int l,String basestring){
        StringBuilder b=new StringBuilder();
        for (int i=0;i<l;l++){ b.append(basestring.charAt((int)(Math.random()*basestring.length())));
            //b.append(c);

        }
        return b.toString();
    }

    public boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


    @After
    public void stop() {

        driver.quit();
        driver=null;
    }
}
