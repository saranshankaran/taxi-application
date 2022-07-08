package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.actions.ElementAction;
import com.taxi.taxi_mobile_automation.constants.FilePathConstants;

import com.taxi.taxi_mobile_automation.page.keys.ChangePasswordKeys;
import com.taxi.taxi_mobile_automation.page.keys.CommonKeys;
import com.taxi.taxi_mobile_automation.page.keys.LoginLogoutKeys;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import com.taxi.taxi_mobile_automation.verify.Verify;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ChangePasswordPage {
    public Logger logger = Logger.getLogger(ChangePasswordPage.class);
    ElementAction action =new ElementAction();
    static AndroidDriver androidDriver;

    PropertyParser changePassword = new PropertyParser(FilePathConstants.CHANGE_PASSWORD);
    PropertyParser changePasswordDetail = new PropertyParser(FilePathConstants.CHANGE_PASSWORD_DETAILS);
    PropertyParser menuPagePath = new PropertyParser(FilePathConstants.MENU_PAGE_PATH);
    PropertyParser loginPath = new PropertyParser(FilePathConstants.LOGIN_PATH);
    PropertyParser loginDetail = new PropertyParser(FilePathConstants.LOGIN_DETAIL);
    Verify verify = new Verify();

    /**
     * This method will perform changing the existing password with the new
     * password.
     */
    public void changePassword(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Enter the Old Password");
        String oldPassword = changePassword.getPropertyValue(ChangePasswordKeys.OLD_PASSWORD_TEXT_BOX);
        androidDriver.findElement(By.xpath(oldPassword)).sendKeys(changePasswordDetail.getPropertyValue(ChangePasswordKeys.OLD_PASSWOR_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Enter the New Password");
        String newPassword = changePassword.getPropertyValue(ChangePasswordKeys.NEW_PASSWORD_TEXT_BOX);
        androidDriver.findElement(By.xpath(newPassword)).sendKeys(changePasswordDetail.getPropertyValue(ChangePasswordKeys.NEW_PASSWORD_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Enter the Password again to confirm");
        String reEnterPassword = changePassword.getPropertyValue(ChangePasswordKeys.REENTER_TEXT_BOX);
        androidDriver.findElement(By.xpath(reEnterPassword)).sendKeys(changePasswordDetail.getPropertyValue(ChangePasswordKeys.REENTER_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on Change Button");
        String changeButton = changePassword.getPropertyValue(ChangePasswordKeys.CHANGE_BUTTON);
        androidDriver.findElement(By.xpath(changeButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on Ok button");
        String okButton = changePassword.getPropertyValue(ChangePasswordKeys.PASSWORD_OK_BUTTON);
        androidDriver.findElement(By.xpath(okButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.info("Check the click menu");
        }
        logger.info("Click on Back button");
        String backElement = menuPagePath.getPropertyValue(CommonKeys.BACK_BUTTON);

        androidDriver.findElement(By.xpath(backElement)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.info("Check the click menu");
        }
    }

    /**
     * This method will verify that the new password is changed by the user is able
     * to log in to the application.
     */

    public void verifyChangePassword(AppiumDriver androidDriver) {
        try {
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            logger.info("Enter the mobile number");
            String loginMobileNumber = loginPath.getPropertyValue(LoginLogoutKeys.LOGIN_MOBILE_NUMBER);
            androidDriver.findElement(By.xpath(loginMobileNumber)).sendKeys(loginDetail.getPropertyValue(LoginLogoutKeys.MOBILE_NUMBER_TEXT));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("Enter the New password");
            String loginPassword = loginPath.getPropertyValue(LoginLogoutKeys.LOGIN_PASSWORD);
            androidDriver.findElement(By.xpath(loginPassword)).sendKeys(changePasswordDetail.getPropertyValue(ChangePasswordKeys.NEW_PASSWORD_TEXT));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("Click on login Button");
            String loginElement = loginPath.getPropertyValue(LoginLogoutKeys.LOGIN_BUTTON);
            androidDriver.findElement(By.xpath(loginElement)).click();
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("Home Page is entered");
            WebElement homePage = androidDriver.findElement(By.xpath(changePassword.getPropertyValue(ChangePasswordKeys.HOME_PAGE)));
            Boolean isDisplayed = action.isElementPresent(homePage);

            logger.info("Verify Home is entered");

            verify.verifyBoolean(isDisplayed, homePage.isDisplayed(), "Verify Home page is Displayed : ");
            logger.info("Password Changed successfull!!");

        } catch (Exception e) {
            System.out.println("Password is not changed");

        }
    }
}
