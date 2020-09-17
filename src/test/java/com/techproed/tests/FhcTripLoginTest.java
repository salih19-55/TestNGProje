package com.techproed.tests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {

    @Test(  groups = {"fhctrip", "login"} )
    public void aramaTesti(){
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");

        FhcTripLoginPage FhcTripLoginPage = new FhcTripLoginPage(driver);
        FhcTripLoginPage.userNameKutusu.sendKeys("manager2");
        FhcTripLoginPage.passwordKutusu.sendKeys("Man1ager2!");
        FhcTripLoginPage.loginButonu.click();
    }


}
