package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.page.keys.DeleteAccountKeys;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import com.taxi.taxi_mobile_automation.constants.FilePathConstants;

import com.taxi.taxi_mobile_automation.utils.PropertyParser;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;


public class DeleteAccountPage{
    public Logger logger = Logger.getLogger(DeleteAccountPage.class);
    PropertyParser deletePath = new PropertyParser(FilePathConstants.DELETE_PATH);

    /**
     * This method will delete the account performed by the user.
     */
    public void deleteAccount(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Click on Ok button");
        String deleteOkButton = deletePath.getPropertyValue(DeleteAccountKeys.DELETE_OK_BUTTON);
        androidDriver.findElement(By.xpath(deleteOkButton)).click();

    }

    /**
     * This method verifies that the account is deleted or not.
     *
     * @return true or false
     */
    public boolean deleteAccountVerify(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        try {
            logger.info("Home Page is entered");
            logger.info("Account is not Deleted");
            WebElement homePage = androidDriver.findElement(By.xpath(deletePath.getPropertyValue(DeleteAccountKeys.HOME_PAGE)));
            Assert.assertFalse(homePage.isDisplayed());

            return true;
        } catch (Exception e) {
            System.err.println("deleted");
            return false;
        }
    }
}
