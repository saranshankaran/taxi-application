package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;
import com.taxi.taxi_mobile_automation.page.keys.LoginLogoutKeys;
import com.taxi.taxi_mobile_automation.page.keys.RegistrationKeys;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.NoSuchElementException;

public class LoginPage  {
    public Logger logger = Logger.getLogger(LoginPage.class);
    PropertyParser registrationPath = new PropertyParser(FilePathConstants.REGISTRATION_PATH);
    PropertyParser loginPath = new PropertyParser(FilePathConstants.LOGIN_PATH);
    PropertyParser loginDetail = new PropertyParser(FilePathConstants.LOGIN_DETAIL);
    /**
     * This method will handle the registration alert for allowing location and SMS
     * permission for taxi application.
     */

    /**
     * This method will redirect to the registration page.
     *
     * @return
     */
    public boolean clickRegisterHereLink(AppiumDriver androidDriver) {
        try {

            logger.info("Click on Register Here");
            String registerElement = registrationPath.getPropertyValue(RegistrationKeys.NEW_REGISTRATION);
            androidDriver.findElement(By.id(registerElement)).click();
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            return true;
        } catch (NoSuchElementException e) {
            logger.info("Elements are not present");
            return false;
        }
    }
    public boolean login(AppiumDriver androidDriver){
        try {
                logger.info("Click and Enter the Mobile number");
                String loginMobileNumber = loginPath.getPropertyValue(LoginLogoutKeys.LOGIN_MOBILE_NUMBER);
                androidDriver.findElement(By.xpath(loginMobileNumber)).sendKeys(loginDetail.getPropertyValue(LoginLogoutKeys.MOBILE_NUMBER_TEXT));
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

                logger.info("Click and Enter the Password");
                String loginPassword = loginPath.getPropertyValue(LoginLogoutKeys.LOGIN_PASSWORD);
                androidDriver.findElement(By.xpath(loginPassword)).sendKeys(loginDetail.getPropertyValue(LoginLogoutKeys.PASSWORD_TEXT));
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

                logger.info("Click on Login button");
                String loginButton = loginPath.getPropertyValue(LoginLogoutKeys.LOGIN_BUTTON);
                androidDriver.findElement(By.xpath(loginButton)).click();
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

                WebElement text = androidDriver.findElement(By.id("com.atmecs.taxi:id/alertTitle"));
                text.isDisplayed();
                logger.info("! Log in Failed !");
                return false;

            } catch (Exception e) {
                logger.info("(: Logged In Successfully (:");
                return true;
           }
    }
}

