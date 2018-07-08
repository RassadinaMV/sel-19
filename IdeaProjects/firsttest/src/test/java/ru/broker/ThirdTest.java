package ru.broker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class ThirdTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
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
         driver.findElement(By.xpath("//*[contains(text(),'Statistics')]"));

    }

    @After
    public void stop() {

        driver.quit();
        driver = null;

    }
}
