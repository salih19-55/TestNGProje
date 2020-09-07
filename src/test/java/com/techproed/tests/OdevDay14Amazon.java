package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class OdevDay14Amazon {
    // Bugünkü ödevimiz:
//1)Amazon.com a gidin
//2)sol üstte menü seçeneği var ona tıklayın (3 çizgi şeklinde)
//3) oradan "Software" I seçin
//4) sonra "Programming & Web Development" i seçin
//5) açılan yeni sayfada sol alt kısımda "Price" yeri var. Orada min ve max kutucuklarına 10 ve 20 yazın.
//6) kutuları doldurduktan sonra hemen yanındaki "Go" butonuna tıklayın.
//7) son olarak da açılan sayfanın URL ini alıp ekrana yazdıralım
    private WebDriver driver;
    WebElement dropDown;
    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void amazon() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement amaz = driver.findElement(By.id("nav-hamburger-menu"));
        Actions actions = new Actions(driver);
        actions.doubleClick(amaz).perform();
        WebElement softWare=driver.findElement(By.xpath("//a[@data-menu-id='22']"));
        actions.doubleClick(softWare).perform();

        WebElement prog_Web=driver.findElement(By.xpath("//*[.='Programming & Web Development']"));
        Thread.sleep(2000);
        actions.doubleClick(prog_Web).perform();

        Thread.sleep(1000);
        WebElement lowPrice=driver.findElement(By.id("low-price"));
        lowPrice.sendKeys("10");

        Thread.sleep(1000);
        WebElement highPrice=driver.findElement(By.id("high-price"));
        highPrice.sendKeys("20");

        WebElement go=driver.findElement(By.id("a-autoid-1"));
        go.submit();

        String sayfUrl= driver.getCurrentUrl();
        System.out.println(sayfUrl);

    }



}