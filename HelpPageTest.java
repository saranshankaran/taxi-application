package com.taxi.taxi_mobile_automation.testscripts;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;
import com.taxi.taxi_mobile_automation.pages.LoginPage;
import com.taxi.taxi_mobile_automation.pages.MenuPage;
import com.taxi.taxi_mobile_automation.pages.RegistrationPage;
import com.taxi.taxi_mobile_automation.pages.HelpPage;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import com.taxi.taxi_mobile_automation.verify.Verify;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.taxi.taxi_mobile_automation.base.TestBase;

import java.time.Duration;

public class HelpPageTest extends TestBase {
    public Logger logger = Logger.getLogger(HelpPageTest.class);
    LoginPage loginPage = new LoginPage();
    MenuPage menuPage = new MenuPage();
    Verify verify = new Verify();
    RegistrationPage registrationPage = new RegistrationPage();
    HelpPage helpPage = new HelpPage();


    @Test
    public void popUpVerification() {

        logger.info("------------HelpPage Test------------------");

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        loginPage.clickRegisterHereLink(androidDriver);

        registrationPage.registerUser(androidDriver);

        loginPage.login(androidDriver);

        menuPage.clickMenu(androidDriver);

        menuPage.clickHelp(androidDriver);

        verify.verifyBoolean(helpPage.verifyHelpPopup(androidDriver), true, "Verify help page popup :");

        menuPage.clickMenu(androidDriver);

        menuPage.clickLogout(androidDriver);
    }
}
