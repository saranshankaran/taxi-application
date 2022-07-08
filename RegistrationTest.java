package com.taxi.taxi_mobile_automation.testscripts;

import com.taxi.taxi_mobile_automation.base.TestBase;
import com.taxi.taxi_mobile_automation.pages.LoginPage;
import com.taxi.taxi_mobile_automation.pages.MenuPage;
import com.taxi.taxi_mobile_automation.pages.ProfilePage;
import com.taxi.taxi_mobile_automation.pages.RegistrationPage;
import com.taxi.taxi_mobile_automation.verify.Verify;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class RegistrationTest extends TestBase {
    public Logger logger = Logger.getLogger(RegistrationTest.class);

    Verify verify = new Verify();
    RegistrationPage registrationPage = new RegistrationPage();
    LoginPage loginPage = new LoginPage();
    MenuPage menuPage = new MenuPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    public void registrationVerification() {

        logger.info("------------Registration Test------------------");

        try {
            loginPage.clickRegisterHereLink(androidDriver);

            registrationPage.verifyFirstNamePopup(androidDriver);

            registrationPage.verifyLastNamePopup(androidDriver);

            registrationPage.verifyMobileNumberPopup(androidDriver);

            registrationPage.verifyValidNumberPopup(androidDriver);

            registrationPage.verifyEmailPopup(androidDriver);

            registrationPage.verifyPasswordPopup(androidDriver);

            registrationPage.verifyConfirmPasswordPopup(androidDriver);

            registrationPage.verifyPasswordLengthPopup(androidDriver);

            registrationPage.verifyPasswordNotMatchPopup(androidDriver);

            registrationPage.verifySuccessPopup(androidDriver);

            registrationPage.verifyAlreadyRegisteredPopup(androidDriver);

            loginPage.login(androidDriver);

            menuPage.clickMenu(androidDriver);

            menuPage.clickProfile(androidDriver);

            profilePage.verifyMobileNumber(androidDriver);

            menuPage.clickMenu(androidDriver);

            menuPage.clickLogout(androidDriver);

        } catch (NoSuchElementException noSuchElementException) {
            logger.info("Check the webelement is correct");
        }
    }
}
