package com.techproed.pages;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage{

    public GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
   @FindBy(id= "email")
    public WebElement emailKutusu;

    @FindBy(id = "name")
    public WebElement nameKutusu;

    @FindBy(id = "mobile")
    public WebElement mobilKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id = "re_password")
    public WebElement re_passwordKutusu;

    @FindBy(name = "submit")
    public WebElement signUpKutusu;

    @FindBy ( xpath = "//div[@class='alert alert-success']") // burası eksık olmustu..
    public WebElement basariliYazisi;



}