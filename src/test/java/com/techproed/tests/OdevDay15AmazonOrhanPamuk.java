package com.techproed.tests;
/*
1)Amazon.com a git
2)Searchbox in hemen yanında bir drop down var ona tıkla. (burada Select kullanmalı)
3)Icinden "Books" u seç.
4)Arama kutusuna (search box) "orhan pamuk beyaz kale" yaz
5)Aramayı yap
---Buradan sonrası optional, isteyen devam edebilir---
6)ilk çıkan kitap seçeneğine tıkla
7)Girilen sayfanin title ını al
8)Title da "Beyaz" kelimesi geçiyor mu diye Assert le kontrol et.
DropDowns dersinin notlarına bakıp konuyu hatırlamamız gerekebilir.
Eger şu iki günün pratikleri fazla uzunsa/zorsa/kolaysa/karmaşıksa yazın. Ona göre değiştiririz.
2 files
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class OdevDay15AmazonOrhanPamuk {

    private WebDriver driver;
    WebElement dropDown;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }
 @Test

    public void test01 (){

        driver.get("https://amazon.com");
        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropDownMenu);

        select.selectByVisibleText("Books");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Orhan Pamuk Beyaz Kale" + Keys.ENTER);

        WebElement beyazKale = driver.findElement(By.partialLinkText("Kale"));
        beyazKale.click();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("kale"));
        softAssert.assertAll();


 }







}
