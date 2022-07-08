package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;

import com.taxi.taxi_mobile_automation.page.keys.RideLaterKeys;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class RideLaterPage  {
    public String TIME_TEXT;
    public Logger logger = Logger.getLogger(RideLaterPage.class);
    PropertyParser rideLaterPath = new PropertyParser(FilePathConstants.RIDE_LATER_PATH);
    PropertyParser rideLaterDetails = new PropertyParser(FilePathConstants.RIDE_LATER_DETAILS);

    /**
     * This method checks that user able to successfully book ride later trip.
     */
    public void rideLater(AppiumDriver androidDriver) {

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Click on ride later button");
        String rideLaterButton = rideLaterPath.getPropertyValue(RideLaterKeys.RIDE_LATER_BUTTON);
        androidDriver.findElement(By.id(rideLaterButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click and enter the pickup location");
        String pickUpLocation = rideLaterPath.getPropertyValue(RideLaterKeys.PICK_UP_TEXT_BOX);
        androidDriver.findElement(By.id(pickUpLocation)).sendKeys(rideLaterDetails.getPropertyValue(RideLaterKeys.PICK_UP_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click and enter the drop location");
        String dropLocation = rideLaterPath.getPropertyValue(RideLaterKeys.DROP_TEXT_BOX);
        androidDriver.findElement(By.id(dropLocation)).sendKeys(rideLaterDetails.getPropertyValue(RideLaterKeys.DROP_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on date button");
        String selectDateButton = rideLaterPath.getPropertyValue(RideLaterKeys.SELECT_DATE_BUTTON);
        androidDriver.findElement(By.id(selectDateButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Select the date using Calendar");
        String dateSelection = rideLaterPath.getPropertyValue(RideLaterKeys.SELECT_DATE);
        androidDriver.findElement(By.xpath(dateSelection)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        logger.info("Click on Ok button");
        String dateOkButton = rideLaterPath.getPropertyValue(RideLaterKeys.DATE_OK_BUTTON);
        androidDriver.findElement(By.id(dateOkButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on time button");
        String timeButton = rideLaterPath.getPropertyValue(RideLaterKeys.SELECT_TIME_BUTTON);
        androidDriver.findElement(By.id(timeButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        logger.info("Select hours from the clock");
        String timeInHours = rideLaterPath.getPropertyValue(RideLaterKeys.SELECT_HOUR);
        androidDriver.findElement(By.xpath(timeInHours)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Select minutes from the clock");
        String timeInMinutes = rideLaterPath.getPropertyValue(RideLaterKeys.SELECT_MINUTE);
        androidDriver.findElement(By.xpath(timeInMinutes)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on Ok button");
        String rideLaterOkButton = rideLaterPath.getPropertyValue(RideLaterKeys.TIME_OK_BUTTON);
        androidDriver.findElement(By.id(rideLaterOkButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Read and Get the time text");
        WebElement getTimeText = androidDriver.findElement(
                By.id(rideLaterPath.getPropertyValue(RideLaterKeys.GET_TIME)));
        TIME_TEXT = getTimeText.getText();

        logger.info("Click on Confirm button");
        String confirmButton = rideLaterPath.getPropertyValue(RideLaterKeys.CONFIRM_BUTTON);
        androidDriver.findElement(By.id(confirmButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        logger.info("Click on Ok Button");
        String confirmOkButton = rideLaterPath.getPropertyValue(RideLaterKeys.OK_BUTTON);
        androidDriver.findElement(By.id(confirmOkButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Ride is Booked successfully");
    }

}
