package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;
import com.taxi.taxi_mobile_automation.page.keys.ChangePasswordKeys;
import com.taxi.taxi_mobile_automation.page.keys.DeleteAccountKeys;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

public class SettingsPage {

    public Logger logger = Logger.getLogger(SettingsPage.class);
    PropertyParser changePassword = new PropertyParser(FilePathConstants.CHANGE_PASSWORD);
    PropertyParser deletePath = new PropertyParser(FilePathConstants.DELETE_PATH);


    /**
     * This method checks that user able to click change password.
     */
    public void clickChangePassword(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Click on Change Password");
        String changePasswordButton = changePassword.getPropertyValue(ChangePasswordKeys.CHANGE_PASSWORD_BUTTON);
        androidDriver.findElement(By.xpath(changePasswordButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    /**
     * This method checks that user able to click delete my account.
     */
    public void clickDeleteMyAccount(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Click on Delete My Account");
        String deleteAccountElement = deletePath.getPropertyValue(DeleteAccountKeys.DELETE_BUTTON);
        androidDriver.findElement(By.xpath(deleteAccountElement)).click();

    }
}

