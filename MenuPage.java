package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;
import com.taxi.taxi_mobile_automation.page.keys.*;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

public class MenuPage  {
    public Logger logger = Logger.getLogger(MenuPage.class);
    PropertyParser registrationPath = new PropertyParser(FilePathConstants.REGISTRATION_PATH);
    PropertyParser menuPagePath = new PropertyParser(FilePathConstants.MENU_PAGE_PATH);
    PropertyParser rideNowPath = new PropertyParser( FilePathConstants.RIDE_NOW_PATH);
    PropertyParser helpPath = new PropertyParser(FilePathConstants.HELP_PATH);
    PropertyParser deletePath = new PropertyParser(FilePathConstants.DELETE_PATH);
    PropertyParser logoutPath = new PropertyParser(FilePathConstants.LOGOUT_PATH);

    /**
     * This method will perform clicking the menu option.
     */
    public void clickMenu(AppiumDriver androidDriver) {

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Click on the Menu Dashboard");
        String menuElement = menuPagePath.getPropertyValue(MenuKeys.MENU_SCROLL_BAR);

        androidDriver.findElement(By.xpath(menuElement)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    /**
     * This method checks that user able to click the profile.
     */
    public void clickProfile(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.info("Check the click menu");
        }
        logger.info("Click on the Profile button");
        String profileElement = registrationPath.getPropertyValue(MenuKeys.PROFILE_BUTTON);
        androidDriver.findElement(By.xpath(profileElement)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    /**
     * This method checks that user able to click the your trip.
     */
    public void clickYourTrip(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on the Your Trip button");
        String yourTripElement = rideNowPath.getPropertyValue(MenuKeys.YOUR_TRIP_BUTTON);
        androidDriver.findElement(By.xpath(yourTripElement)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    /**
     * This method checks that user able to click the help support.
     */
    public void clickHelp(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on the Help button");
        String helpContactElement = helpPath.getPropertyValue(MenuKeys.HELP_BUTTON);
        androidDriver.findElement(By.xpath(helpContactElement)).click();

    }

    /**
     * This method checks that user able to click the settings.
     */
    public void clickSettings(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on the Settings button");
        String settingsButton = deletePath.getPropertyValue(MenuKeys.SETTINGS_BUTTON);
        androidDriver.findElement(By.xpath(settingsButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    /**
     * This method is used to logout from taxi app.
     *
     * @return true or false
     */
    public boolean clickLogout(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        try {

            logger.info("Click on the Logout button");
            String logoutElement = logoutPath.getPropertyValue(MenuKeys.LOGOUT);
            androidDriver.findElement(By.xpath(logoutElement)).click();
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            logger.info("(: User logged Out Successfully (:");

            logger.info("Page returned to Login Page");

            return true;
        } catch (Exception e) {
            logger.info("!Logout Failed!");
            return false;
        }
    }
}


