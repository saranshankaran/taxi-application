package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;
import com.taxi.taxi_mobile_automation.page.keys.CommonKeys;
import com.taxi.taxi_mobile_automation.page.keys.RideLaterKeys;
import com.taxi.taxi_mobile_automation.page.keys.RideNowKeys;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import com.taxi.taxi_mobile_automation.verify.Verify;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class YourTripPage  {

    String DATE_TO_FORMAT, DATE_STRING;
    String TRIP_TEXT;
    List<String> RIDE_NOW_TEXT_VERIFY;
    String TRIP_DETAILS_RIDE_LATER;
    List<String> RIDE_LATER_TEXT_VERIFY;
    public Logger logger = Logger.getLogger(YourTripPage.class);
    PropertyParser rideNowPath = new PropertyParser(FilePathConstants.RIDE_NOW_PATH);
    PropertyParser rideNowDetails = new PropertyParser(FilePathConstants.RIDE_NOW_DETAILS);
    PropertyParser rideLaterPath = new PropertyParser(FilePathConstants.RIDE_LATER_PATH);
    PropertyParser rideLaterDetails = new PropertyParser(FilePathConstants.RIDE_LATER_DETAILS);
    PropertyParser menuPagePath = new PropertyParser(FilePathConstants.MENU_PAGE_PATH);
    Verify verify = new Verify();
    RideLaterPage rideLaterPage = new RideLaterPage();

    public void rideNowTripDetails(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Read and get te details of the trip");
        WebElement verifytext = androidDriver.findElement(By.xpath(
                rideNowPath.getPropertyValue(RideNowKeys.VERIFY_TRIP_BUTTON)));
        TRIP_TEXT = verifytext.getText();
    }

    public void verifyfromAndTo(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Verify From and To details are Matching");
        RIDE_NOW_TEXT_VERIFY = new ArrayList<String>();

        Scanner textCheck = new Scanner(TRIP_TEXT);
        while (textCheck.hasNextLine()) {
            String eachLineCheck = textCheck.nextLine();
            RIDE_NOW_TEXT_VERIFY.add(eachLineCheck);
        }

        String fromToString = RIDE_NOW_TEXT_VERIFY.get(0); // getting the first index in the trip details page.

        String[] splitFromToWords = fromToString.split("\\s"); // split the words in the from and To

        String fromText = splitFromToWords[0];

        String toText = splitFromToWords[2];

        logger.info("Verify that the From text is same or not");
        verify.verifyString(fromText,
                rideNowDetails.getPropertyValue(RideNowKeys.PICK_UP_TEXT),
                "Verify From text : ");

        logger.info("Verify that the To text is same or not");
        verify.verifyString(toText,
                rideNowDetails.getPropertyValue(RideNowKeys.DROP_TEXT),
                "Verify To text : ");
    }

    public void verifyRideNowTripTime(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Verify the both sysytem time and booking is equal");
        String timeString = RIDE_NOW_TEXT_VERIFY.get(1);
        String[] strArray = timeString.split(",");
        String time = strArray[1].toString().trim();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
        Date dates = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));
        DATE_TO_FORMAT = dateFormat.format(dates);
        DATE_STRING = String.valueOf(DATE_TO_FORMAT);

        String[] systemTime = DATE_STRING.split(",");
        String systemtimeString = systemTime[1].toString().trim();

        logger.info("Verify that the Arrival time is showing 5 min after booking ");
        verify.verifyString(systemtimeString, time, "Verify time : ");
    }

    public void verifyRideNowTripStatus(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Verify that booking status is Upcoming");
        String tripStatus = RIDE_NOW_TEXT_VERIFY.get(4);
        String[] splitStatus = tripStatus.split("\\s");
        String status = splitStatus[1];

        logger.info("Verify that the Status is upcoming after booking the ride");
        verify.verifyString(status, "Upcoming", "Verify Status : ");

        logger.info("Click on Back button");
        String backButton = menuPagePath.getPropertyValue(CommonKeys.BACK_BUTTON);
        androidDriver.findElement(By.xpath(backButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void rideLaterTripDetails(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Read and get te details of the trip");
        WebElement tripDetails = androidDriver.findElement(By
                .xpath(rideLaterPath.getPropertyValue( RideLaterKeys.TRIP_DETAILS)));
        TRIP_DETAILS_RIDE_LATER = tripDetails.getText();

    }

    public void verifyFromAndToLocation(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Verify From and To details are Matching");
        RIDE_LATER_TEXT_VERIFY = new ArrayList<String>();
        Scanner textCheck = new Scanner(TRIP_DETAILS_RIDE_LATER);
        while (textCheck.hasNextLine()) {
            String ecahLineCheck = textCheck.nextLine();
            RIDE_LATER_TEXT_VERIFY.add(ecahLineCheck);
        }

        String fromToString = RIDE_LATER_TEXT_VERIFY.get(0); // getting the first index in the trip details page.

        String[] splitFromToWords = fromToString.split("\\s"); // split the words in the from and To

        String fromText = splitFromToWords[0];
        String toText = splitFromToWords[2];

        logger.info("Verify that the From text is same or not");
        verify.verifyString(fromText,
                rideLaterDetails.getPropertyValue(RideLaterKeys.PICK_UP_TEXT),
                "Verifying From text");

        logger.info("Verify that the To text is same or not");
        verify.verifyString(toText,
                rideLaterDetails.getPropertyValue(RideLaterKeys.DROP_TEXT),
               "Verifying To text : ");
    }

    public void verifyRideLaterTripTime(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Verify the both sysytem time and booking is equal");

        String time = rideLaterPage.TIME_TEXT;
        String timeString = RIDE_LATER_TEXT_VERIFY.get(1);
        String[] strArray = timeString.split(",");
        String systemTime = strArray[1].toString().trim();
        logger.info(systemTime);

        logger.info("Verify that the Time is equal ");
        verify.verifyString(systemTime, time, "Time Verification : 	");

    }

    public void verifyRideLaterTripStatus(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Verify that booking status is Upcoming");
        String statusText = RIDE_LATER_TEXT_VERIFY.get(4);

        String[] splitStatus = statusText.split("\\s");

        String status = splitStatus[1];

        logger.info("Verify that the Status is upcoming after booking the ride");
        verify.verifyString(status, "Upcoming", "Verify Status");

        logger.info("Click on Back button");
        WebElement backButton = androidDriver.findElement(
                By.xpath(menuPagePath.getPropertyValue( CommonKeys.BACK_BUTTON)));
        backButton.click();
    }

    /**
     * This method verifies the driver details when user books the ride trip.
     */

    public void verifyDriverDetails(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Map<String, String> name = new TreeMap<String, String>();
        name.put("FIRST_TRIP_DETAILS", RideNowKeys.FIRST_TRIP_DETAILS);
        name.put("SECOND_TRIP_DETAILS", RideNowKeys.SECOND_TRIP_DETAILS);
        name.put("THIRD_TRIP_DETAILS", RideNowKeys.THIRD_TRIP_DETAILS);
        name.put("FOURTH_TRIP_DETAILS", RideNowKeys.FOURTH_TRIP_DETAILS);
        name.put("FIFTH_TRIP_DETAILS", RideNowKeys.FIFTH_TRIP_DETAILS);

        List<String> driverList = new ArrayList<String>();
        for (String data : name.values()) {
            WebElement TripDetails = androidDriver
                    .findElement(By.xpath(rideNowPath.getPropertyValue(data)));
            String TripText = TripDetails.getText();
            List<String> textVerification = new ArrayList<String>();
            Scanner textCheck = new Scanner(TripText);

            while (textCheck.hasNextLine()) {
                String ecahLineCheck = textCheck.nextLine();
                textVerification.add(ecahLineCheck);
            }
            String fromToString = textVerification.get(2);
            driverList.add(fromToString);
        }
        for (String driverName : driverList) {
            logger.info("Driver Name list : " + driverName);
        }
        String originalDriverString = String.valueOf(driverList.size());
        Set<String> removeDuplicate = new HashSet<String>();

        for (String duplicates : driverList) {
            removeDuplicate.add(duplicates);
        }
        logger.info("After removing repeated Driver name : " + removeDuplicate);

        String removingDuplicateString = String.valueOf(removeDuplicate.size());

        logger.info("Verify the driver names are different ");

        verify.verifyBoolean(originalDriverString, removingDuplicateString, true);

        logger.info("Click on Back button");
        WebElement backButton = androidDriver.findElement(
                By.xpath(menuPagePath.getPropertyValue(CommonKeys.BACK_BUTTON)));
        backButton.click();
    }
}


