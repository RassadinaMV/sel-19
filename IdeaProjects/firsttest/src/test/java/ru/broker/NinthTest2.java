package ru.broker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.fail;

public class NinthTest2  extends BaseTest {

    @Test
    public void checkSorting() {

        BaseTest.loginToAdm();

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        int hh = driver.findElements(By.xpath("//tr[contains(@class,'row')]/td[3]/a")).size();
        String ss1=new String();
        String ss2=new String();
        String[] txt = new String[hh];
        //System.out.println(ss);

        for (int i = 0; i < hh; i++) {
                String country=driver.findElements(By.xpath("//tr[contains(@class,'row')]/td[3]/a")).get(i).getText();
                driver.findElements(By.xpath("//tr[contains(@class,'row')]/td[3]/a")).get(i).click();
                int hh1 = driver.findElements(By.xpath("//table[contains(@id,'table-zones')]/tbody/tr/td[3]/select")).size();
                txt = new String[hh1];
                for (int j = 0; j < hh1; j++) {
                    txt[j]=driver.findElements(By.xpath("//table[contains(@id,'table-zones')]/tbody/tr/td[3]/select/option[contains(@selected,'selected')]")).get(j).getText();
                }
                ss1=Arrays.toString(txt);
                //Arrays.sort(txt, Collections.reverseOrder());
                Arrays.sort(txt);
                ss2=Arrays.toString(txt);
                if(!ss1.equals(ss2)){fail(country+" содержит зоны не по алфавиту");}

                driver.navigate().back();

        }
    }
}
