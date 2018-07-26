package ru.broker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;

public class EighthTest  extends BaseTest {

    @Test
    public void controlDuckStickers() {

        driver.get("http://localhost/litecart/en/");
        List<WebElement> elmts= driver.findElements(By.xpath("//*[contains(@class,'product')]//div[contains(@class,'name')]"));
        int hh=elmts.size();
        String[] stckrs=new String[hh];
        //System.out.println(hh);

        for (int i=0; i<hh;i++) {

            try {

               //try {
                 //  Thread.sleep(10000);
               // } catch (InterruptedException e) {
                //    e.printStackTrace();
               // }

              // System.out.println(driver.findElements(By.xpath("//a/div[contains(@class,'name')]/../div/div[contains(@class,'sticker')]")).get(i).getText());
               stckrs[i]=driver.findElements(By.xpath("//a/div[contains(@class,'name')]/../div/div[contains(@class,'sticker')]")).get(i).getText();
            }
            catch (IndexOutOfBoundsException ignored) {System.out.println(0);stckrs[i]="NULL";}
            for (int j=0; j<i;j++)
            {
                if(elmts.get(j).getText().equals(elmts.get(i).getText())) {
                    if (!stckrs[j].equals(stckrs[i])) {
                        fail("разные стикеры на "+elmts.get(i).getText()+" "+stckrs[i]+" "+stckrs[j]);
                    }

                }

            }
        }

    }

}
