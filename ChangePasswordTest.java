package com.taxi.taxi_mobile_automation.testscripts;

import com.taxi.taxi_mobile_automation.base.TestBase;
import com.taxi.taxi_mobile_automation.constants.FilePathConstants;
import com.taxi.taxi_mobile_automation.pages.*;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import com.taxi.taxi_mobile_automation.verify.Verify;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChangePasswordTest extends TestBase {
    /**
     * Change password verification class will verifies after changing the existing
     * password User able to login with the new password credentials.
     *
     * @author saran
     * @exception InterruptedException
     * @throws InterruptedException
     */

    public Logger logger = Logger.getLogger(ChangePasswordTest.class);
    LoginPage loginPage = new LoginPage();
    MenuPage menuPage = new MenuPage();
    SettingsPage settingsPage = new SettingsPage();
    Verify verify = new Verify();
    RegistrationPage registrationPage = new RegistrationPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void changePasswordVerification() throws InterruptedException {
        logger.info("------------ChangePassword Test------------------");

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        loginPage.clickRegisterHereLink(androidDriver);

        registrationPage.registerUser(androidDriver);

        loginPage.login(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickSettings(androidDriver);

        settingsPage.clickChangePassword(androidDriver);

        changePasswordPage.changePassword(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickLogout(androidDriver);

        changePasswordPage.verifyChangePassword(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickLogout(androidDriver);
    }
}


