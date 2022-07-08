package com.taxi.taxi_mobile_automation.testscripts;

import com.taxi.taxi_mobile_automation.base.TestBase;
import com.taxi.taxi_mobile_automation.pages.*;
import com.taxi.taxi_mobile_automation.verify.Verify;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.time.Duration;

public class TripDriverTest extends TestBase {
    public Logger logger = Logger.getLogger(TripDriverTest.class);
    LoginPage loginPage = new LoginPage();
    MenuPage menuPage = new MenuPage();
    Verify verify = new Verify();
    RegistrationPage registrationPage = new RegistrationPage();
    BookTaxiPage rideNowPage = new BookTaxiPage();
    YourTripPage tripPage = new YourTripPage();

    @Test
    public void tripDriverVerification() throws InterruptedException {


        logger.info("------------Trip Driver Test------------------");
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        loginPage.clickRegisterHereLink(androidDriver);

        registrationPage.registerUser(androidDriver);

        loginPage.login(androidDriver);

        rideNowPage.bookRide(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickYourTrip(androidDriver);

        tripPage.verifyDriverDetails(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickLogout(androidDriver);
    }

}