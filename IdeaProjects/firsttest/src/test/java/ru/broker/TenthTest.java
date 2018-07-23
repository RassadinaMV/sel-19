package ru.broker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.fail;

public class TenthTest extends BaseTest {

    @Test
    public void controlSale() {

        driver.get("http://localhost/litecart/en/");
        WebElement w1 = driver.findElement(By.xpath("//div[contains(@id,'box-campaigns')]/div//div[contains(@class,'name')]"));
        WebElement w2 = driver.findElement(By.xpath("//div[contains(@id,'box-campaigns')]//s[contains(@class,'regular-price')]"));
        WebElement w3 = driver.findElement(By.xpath("//div[contains(@id,'box-campaigns')]//strong[contains(@class,'campaign-price')]"));

        String wname = w1.getText();
        String wpricereg = w2.getText();
        String wpricesale = w3.getText();

        String[] regClr=w2.getCssValue("color").replace("rgba(","").replace(")","").replace(" ","").split(",");
        String[] saleClr=w3.getCssValue("color").replace("rgba(","").replace(")","").replace(" ","").split(",");;
        String regTdl=w2.getCssValue("text-decoration-line");
        String bold=w3.getCssValue("font-weight");
        Double size2=Double.parseDouble(w3.getCssValue("font-size").replace("px",""));
        Double size1=Double.parseDouble(w2.getCssValue("font-size").replace("px",""));

        driver.findElement(By.xpath("//div[contains(@id,'box-campaigns')]//a")).click();

        w1 = driver.findElement(By.xpath("//div[contains(@id,'box-product')]//h1[contains(@itemprop,'name')]"));
        w2 = driver.findElement(By.xpath("//div[contains(@id,'box-product')]//s[contains(@class,'regular-price')]"));
        w3 = driver.findElement(By.xpath("//div[contains(@id,'box-product')]//strong[contains(@class,'campaign-price')]"));

        String wname2 = w1.getText();
        String wpricereg2 = w2.getText();
        String wpricesale2 = w3.getText();

        //проверка совпадения цены и названия

        if (!wname.equals(wname2)) {
            fail("на главной и регулярной названия не совпадают");
        }

        if (!wpricereg.equals(wpricereg2)) {
            fail("на главной и регулярной цены не совпадают");
        }

        if (!wpricesale.equals(wpricesale2)) {
            fail("на главной и регулярной цены не совпадают");
        }

        //проверки на главной

        if (!regClr[0].equals(regClr[1])) {
            fail("на главной регулярная цена не серого цвета1");
        }
        else {
            if (!regClr[1].startsWith(regClr[2])){
                fail("на главной регулярная цена не серого цвета1");
            }

        }

        if (!regTdl.equals("line-throught")){

        }
        else {fail("на главной регулярная цена не зачеркнута");}

        if (size1>=size2){
            fail("на главной размер шрифта регулярной цены не меньше акционной");
        }

        if (saleClr[1].equals(saleClr[2])){
            if (!bold.equals("700")){
                fail("на главной акционная цена не жирная");
            }
        }
        else {fail("на главной акционная цена не красная");}

        regClr=w2.getCssValue("color").replace("rgba(","").replace(")","").replace(" ","").split(",");
        saleClr=w3.getCssValue("color").replace("rgba(","").replace(")","").replace(" ","").split(",");;
        regTdl=w2.getCssValue("text-decoration-line");
        bold=w3.getCssValue("font-weight");
        size2=Double.parseDouble(w3.getCssValue("font-size").replace("px",""));
        size1=Double.parseDouble(w2.getCssValue("font-size").replace("px",""));

        //проверки на странице товара

        if (!regClr[0].equals(regClr[1])) {
            fail("регулярная цена не серого цвета");
        }
        else {
            if (!regClr[1].startsWith(regClr[2])){
                fail("регулярная цена не серого цвета");
            }

        }

        if (!regTdl.equals("line-throught")){

        }
        else {fail("регулярная цена не зачеркнута");}

        if (size1>=size2){
            fail("размер шрифта регулярной цены не меньше акционной");
        }

        if (saleClr[1].equals(saleClr[2])){
            if (!bold.equals("700")){
                fail("акционная цена не жирная");
            }
        }
        else {fail("акционная цена не красная");}


    }
}
