package com.taxi.taxi_mobile_automation.testscripts;

import com.taxi.taxi_mobile_automation.base.TestBase;
import com.taxi.taxi_mobile_automation.pages.*;
import com.taxi.taxi_mobile_automation.verify.Verify;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.time.Duration;

public class RideNowTest extends TestBase {
    public Logger logger = Logger.getLogger(RideNowTest.class);
    LoginPage loginPage = new LoginPage();
    MenuPage menuPage = new MenuPage();
    Verify verify = new Verify();
    RegistrationPage registrationPage = new RegistrationPage();
    YourTripPage yourTripPage = new YourTripPage();
    BookTaxiPage rideNowPage = new BookTaxiPage();

    @Test
    public void verifyRideNowdetails() {

        logger.info("------------RideNow Test------------------");

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage.clickRegisterHereLink(androidDriver);

        registrationPage.registerUser(androidDriver);

        loginPage.login(androidDriver);

        rideNowPage.rideNowDetails(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickYourTrip(androidDriver);

        yourTripPage.rideNowTripDetails(androidDriver);

        yourTripPage.verifyfromAndTo(androidDriver);

        yourTripPage.verifyRideNowTripTime(androidDriver);

        yourTripPage.verifyRideNowTripStatus(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickLogout(androidDriver);
    }
}
