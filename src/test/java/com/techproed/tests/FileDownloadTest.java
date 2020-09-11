package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class FileDownloadTest extends TestBase {
    @Test
    public void dosyaVarMi(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        String kullaniciDosyaYolu = System.getProperty("user.dir");
        //C:/Users/lenov/IdeaProjects/TestNGProje/pom.xml
        String pomXmlDosyaYolu = kullaniciDosyaYolu +"/pom.xml";
        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        System.out.println(varMi);
        Assert.assertTrue(varMi);
    }
    @Test
    public void dosyaUpload(){ // bilgisayardan websayfasına doysa yükleme
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dosyaSecmeButonu = driver.findElement(By.id("file-upload"));

        // yüklemek istediğimiz dosyanın, path(dosya yolunu) ekleyelim.
        dosyaSecmeButonu.sendKeys("C:/Users/lenov/OneDrive/Escritorio/logo.png/logo.png");
       // dosyaSecmeButonu.sendKeys("C:/Users/lenov/OneDrive/Escritorio/logo.png");

        WebElement uploadButonu = driver.findElement(By.id("file-submit"));
        uploadButonu.click();

         WebElement fileUploadedYazisi = driver.findElement(By.tagName("h3"));
         Assert.assertTrue(fileUploadedYazisi.isDisplayed());
    }
    @Test
    public void dosyaDownload(){
        // C:\Users\lenov\Downloads
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement penguinsLinki = driver.findElement(By.partialLinkText("Penguins.jpg"));
        penguinsLinki.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean varMi = Files.exists(Paths.get("C:\\Users\\lenov\\Downloads\\Penguins.jpg"));
        Assert.assertTrue(varMi);
    }
}