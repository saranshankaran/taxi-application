package com.taxi.taxi_mobile_automation.testscripts;

import com.taxi.taxi_mobile_automation.base.TestBase;
import com.taxi.taxi_mobile_automation.pages.*;
import com.taxi.taxi_mobile_automation.verify.Verify;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.time.Duration;

public class RideLaterTest extends TestBase {
    public Logger logger = Logger.getLogger(RideLaterTest.class);
    LoginPage loginPage = new LoginPage();
    MenuPage menuPage = new MenuPage();
    RegistrationPage registrationPage = new RegistrationPage();
    Verify verify = new Verify();
    RideLaterPage rideLaterPage = new RideLaterPage();
    YourTripPage yourTripPage = new YourTripPage();

    @Test
    public void rideNowdetailsVerification() {

        logger.info("------------RideLater Test------------------");

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        loginPage.clickRegisterHereLink(androidDriver);

        registrationPage.registerUser(androidDriver);

        loginPage.login(androidDriver);

        rideLaterPage.rideLater(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickYourTrip(androidDriver);

        yourTripPage.rideLaterTripDetails(androidDriver);

        yourTripPage.verifyFromAndToLocation(androidDriver);

        yourTripPage.verifyRideLaterTripTime(androidDriver);

        yourTripPage.verifyRideLaterTripStatus(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickLogout(androidDriver);
    }
}