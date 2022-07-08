package com.taxi.taxi_mobile_automation.testscripts;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;
import com.taxi.taxi_mobile_automation.pages.*;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import com.taxi.taxi_mobile_automation.verify.Verify;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.taxi.taxi_mobile_automation.base.TestBase;

import java.time.Duration;

public class DeleteAccountTest extends TestBase {
    public Logger logger = Logger.getLogger(DeleteAccountTest.class);
    LoginPage loginPage = new LoginPage();

    MenuPage menuPage = new MenuPage();
    SettingsPage settingsPage = new SettingsPage();
    Verify verify = new Verify();
    RegistrationPage registrationPage = new RegistrationPage();
    SettingsPage settingsPage2 = new SettingsPage();
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage();

    @Test
    public void deleteVerification() {
        System.out.println();
        logger.info("------------DeleteAccount Test------------------");
        System.out.println();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        loginPage.clickRegisterHereLink(androidDriver);

        registrationPage.registerUser(androidDriver);

        loginPage.login(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickSettings(androidDriver);

        settingsPage2.clickDeleteMyAccount(androidDriver);

        deleteAccountPage.deleteAccount(androidDriver);

        loginPage.login(androidDriver);

        verify.verifyBoolean(deleteAccountPage.deleteAccountVerify(androidDriver), false, "Verify account is deleted : ");

        menuPage.clickMenu(androidDriver);

        menuPage.clickLogout(androidDriver);

    }
}
