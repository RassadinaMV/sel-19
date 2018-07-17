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


    @After
    public void stop() {

        driver.quit();
        driver=null;
    }
}
