package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;

import com.taxi.taxi_mobile_automation.page.keys.CommonKeys;
import com.taxi.taxi_mobile_automation.page.keys.RideNowKeys;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

public class BookTaxiPage  {

    public Logger logger = Logger.getLogger(BookTaxiPage.class);
    PropertyParser rideNowPath = new PropertyParser(FilePathConstants.RIDE_NOW_PATH);
    PropertyParser rideNowDetails = new PropertyParser(FilePathConstants.RIDE_NOW_DETAILS);

    /**
     * This method checks that user able to enter the details for book a ride now.
     */
    public void rideNowDetails(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Enter the pickup Location");
        String pickUpLocation = rideNowPath.getPropertyValue(RideNowKeys.PICK_UP_TEXT_BOX);
        androidDriver.findElement(By.id(pickUpLocation)).sendKeys(rideNowDetails.getPropertyValue(RideNowKeys.PICK_UP_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Enter the Destination location");
        String dropLocation = rideNowPath.getPropertyValue(RideNowKeys.DROP_TEXT_BOX);
        androidDriver.findElement(By.id(dropLocation)).sendKeys(rideNowDetails.getPropertyValue(RideNowKeys.DROP_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on Ride Now button");
        String rideNowButton = rideNowPath.getPropertyValue(RideNowKeys.RIDE_NOW_BUTTON);
        androidDriver.findElement(By.id(rideNowButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        logger.info("Click on Ok Button");
        String confirmOkButton = rideNowPath.getPropertyValue(CommonKeys.OK_BUTTON);
        androidDriver.findElement(By.id(confirmOkButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    public void bookRide(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        for (int index = 1; index <= 5; index++) {
            logger.info("Trip Detail : " + index + ".........");

            logger.info("Enter the pickup Location");
            String pickUpLocation = rideNowPath.getPropertyValue(RideNowKeys.PICK_UP_TEXT_BOX);
            androidDriver.findElement(By.id(pickUpLocation)).sendKeys(rideNowDetails.getPropertyValue(RideNowKeys.PICK_UP_TEXT));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("Enter the Destination location");
            String dropLocation = rideNowPath.getPropertyValue(RideNowKeys.DROP_TEXT_BOX);
            androidDriver.findElement(By.id(dropLocation)).sendKeys(rideNowDetails.getPropertyValue(RideNowKeys.DROP_TEXT));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("Click on Ride Now button");
            String rideNowButton = rideNowPath.getPropertyValue(RideNowKeys.RIDE_NOW_BUTTON);
            androidDriver.findElement(By.id(rideNowButton)).click();
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


            logger.info("Click on Ok Button");
            String confirmOkButton = rideNowPath.getPropertyValue(CommonKeys.OK_BUTTON);
            androidDriver.findElement(By.id(confirmOkButton)).click();
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        }
    }

}

