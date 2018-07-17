package ru.broker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MFTest {private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        //DesiredCapabilities caps= new DesiredCapabilities();
        //caps.setCapability(FirefoxDriver.MARIONETTE, false);
        driver=new FirefoxDriver();
        wait=new WebDriverWait(driver,10);

    }

    @Test
    public void loginLitecardAdminMF() {

        driver.navigate().to("http://localhost/litecart/admin/");
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
