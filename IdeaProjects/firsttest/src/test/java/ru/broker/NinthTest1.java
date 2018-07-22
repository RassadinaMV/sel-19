package ru.broker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.fail;

public class NinthTest1  extends BaseTest {

    @Test
    public void checkSorting() {

        BaseTest.loginToAdm();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> elmts = driver.findElements(By.xpath("//tr[contains(@class,'row')]/td[5]/a"));
       // String ss = driver.findElements(By.xpath("//tr[contains(@class,'row')]/td[5]/a/text()")).toString();
        int hh = elmts.size();
        String ss1=new String();
        String ss2=new String();
        String[] txt = new String[hh];
        //System.out.println(ss);
        for (int i = 0; i < hh; i++) {
            txt[i]=elmts.get(i).getText();
                    }
        ss1=Arrays.toString(txt);
        //Arrays.sort(txt, Collections.reverseOrder());
        Arrays.sort(txt);
        ss2=Arrays.toString(txt);
        if(!ss1.equals(ss2)){fail("страны - не по алфавиту");}

        //проверка (б)

        for (int i = 0; i < hh; i++) {
           if (!driver.findElements(By.xpath("//tr[contains(@class,'row')]/td[6]")).get(i).getAttribute("textContent").equals("0"))
           {
               String country=driver.findElements(By.xpath("//tr[contains(@class,'row')]/td[5]/a")).get(i).getText();
               driver.findElements(By.xpath("//tr[contains(@class,'row')]/td[5]/a")).get(i).click();
               int hh1 = driver.findElements(By.xpath("//table[contains(@id,'table-zones')]/tbody/tr/td[3]")).size();
               txt = new String[hh1-1];
               for (int j = 0; j < hh1-1; j++) {
                   txt[j]=driver.findElements(By.xpath("//table[contains(@id,'table-zones')]/tbody/tr/td[3]")).get(j).getText();
               }
               ss1=Arrays.toString(txt);
               //Arrays.sort(txt, Collections.reverseOrder());
               Arrays.sort(txt);
               ss2=Arrays.toString(txt);
               //System.out.println(ss1);
               //System.out.println(ss2);
               if(!ss1.equals(ss2)){fail(country+" содержит зоны не по алфавиту");}

               driver.navigate().back();
           }
        }


    }
}

