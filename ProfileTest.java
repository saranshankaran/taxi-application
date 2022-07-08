package com.taxi.taxi_mobile_automation.testscripts;

import com.taxi.taxi_mobile_automation.base.TestBase;
import com.taxi.taxi_mobile_automation.pages.LoginPage;
import com.taxi.taxi_mobile_automation.pages.MenuPage;
import com.taxi.taxi_mobile_automation.pages.RegistrationPage;
import com.taxi.taxi_mobile_automation.pages.ProfilePage;
import com.taxi.taxi_mobile_automation.verify.Verify;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTest extends TestBase {
    public Logger logger = Logger.getLogger(ProfileTest.class);
    LoginPage loginPage = new LoginPage();
    MenuPage menuPage = new MenuPage();
    Verify verify = new Verify();
    RegistrationPage registrationPage = new RegistrationPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    public void updateProfileVerification() {


        logger.info("------------ProfileUpdate Test------------------");
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage.clickRegisterHereLink(androidDriver);

        registrationPage.registerUser(androidDriver);

        loginPage.login(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickProfile(androidDriver);

        profilePage.updateProfile(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickLogout(androidDriver);

        loginPage.login(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickProfile(androidDriver);

        profilePage.verifyProfileUpdate(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickLogout(androidDriver);
    }
}
