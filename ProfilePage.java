package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;

import com.taxi.taxi_mobile_automation.page.keys.CommonKeys;
import com.taxi.taxi_mobile_automation.page.keys.LoginLogoutKeys;
import com.taxi.taxi_mobile_automation.page.keys.RegistrationKeys;
import com.taxi.taxi_mobile_automation.page.keys.UpdateProfileKeys;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import com.taxi.taxi_mobile_automation.verify.Verify;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProfilePage {

    public Logger logger = Logger.getLogger(ProfilePage.class);
    static AndroidDriver androidDriver;
    PropertyParser registrationPath = new PropertyParser(FilePathConstants.REGISTRATION_PATH);
    PropertyParser menuPagePath = new PropertyParser(FilePathConstants.MENU_PAGE_PATH);
    PropertyParser loginDetail = new PropertyParser(FilePathConstants.LOGIN_DETAIL);
    PropertyParser profileUpdatePath = new PropertyParser(FilePathConstants.PROFILE_UPDATE_PATH);
    PropertyParser profileUpdateDetails = new PropertyParser(FilePathConstants.PROFILE_UPDATE_DETAILS);
    Verify verify = new Verify();

    /**
     * This method checks that mobile number registered is available in the profile
     * page.
     */

    public void verifyMobileNumber(AppiumDriver androidDriver) {

        logger.info("Profile page is displayed");
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Read and Get the mobile number");

        WebElement getMobileNumber = androidDriver.findElement(By.xpath(registrationPath.getPropertyValue(RegistrationKeys.GET_MOBILE_NUMBER)));

        String getMobileString = getMobileNumber.getText() ;

        logger.info("Verify given mobile number is same ");

        verify.verifyString(getMobileString, loginDetail.getPropertyValue(LoginLogoutKeys.MOBILE_NUMBER_TEXT),
                "Verify mobileNumber : ");

        logger.info("Click on back button");
        String backButton = menuPagePath.getPropertyValue(CommonKeys.BACK_BUTTON);
        androidDriver.findElement(By.xpath(backButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    /**
     * This method perform updating the profile in the profile page by changing the
     * name and email id.
     */
    public void updateProfile(AppiumDriver androidDriver) {
       // androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Enter the First name to be updated ");
        WebElement updateFirstNameTextBox =androidDriver.findElement(By.xpath(profileUpdatePath.getPropertyValue(UpdateProfileKeys.UPDATE_FIRST_NAME_TEXT_BOX)));
        updateFirstNameTextBox.sendKeys(profileUpdateDetails.getPropertyValue(UpdateProfileKeys.UPDATE_FIRST_NAME_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Enter the Last name to be updated ");
        WebElement updateLastNameTextBox =androidDriver.findElement(By.xpath(profileUpdatePath.getPropertyValue(UpdateProfileKeys.UPDATE_LAST_NAME_TEXT_BOX)));
        updateLastNameTextBox.sendKeys(profileUpdateDetails.getPropertyValue(UpdateProfileKeys.UPDATE_LAST_NAME_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Enter the Email Id to be updated ");
        WebElement updateEmailTextBox = androidDriver.findElement(By.xpath(profileUpdatePath.getPropertyValue(UpdateProfileKeys.UPDATE_EMAIL_TEXT_BOX)));
        updateEmailTextBox.sendKeys(profileUpdateDetails.getPropertyValue(UpdateProfileKeys.UPDATE_EMAIL_TEXT));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on Save button");
        String saveButton = profileUpdatePath.getPropertyValue(UpdateProfileKeys.SAVE_BUTTON);

        androidDriver.findElement(By.xpath(saveButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on Ok button");
        String okButton = profileUpdatePath.getPropertyValue(CommonKeys.OK_BUTTON);
        androidDriver.findElement(By.xpath(okButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        logger.info("Click on back button");
        String backButton = menuPagePath.getPropertyValue(CommonKeys.BACK_BUTTON);
        androidDriver.findElement(By.xpath(backButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    /**
     * This method verifies that profile is updated with new credentials or not.
     */
    public void verifyProfileUpdate(AppiumDriver androidDriver) {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Read and Get the First name");

        WebElement updateFirstNameTextBox =androidDriver.findElement(By.xpath(profileUpdatePath.getPropertyValue(UpdateProfileKeys.UPDATE_FIRST_NAME_TEXT_BOX)));

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String verifyFirstNameText = updateFirstNameTextBox.getText();

        logger.info("Verify given First name is same ");

        verify.verifyString(verifyFirstNameText, profileUpdateDetails.getPropertyValue(UpdateProfileKeys.UPDATE_FIRST_NAME_TEXT),
                "Verify First Name : ");

        logger.info("Read and Get the Last name");
        WebElement updateLastNameTextBox =androidDriver.findElement(By.xpath(profileUpdatePath.getPropertyValue(UpdateProfileKeys.UPDATE_LAST_NAME_TEXT_BOX)));

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String verifyLastNameText = updateLastNameTextBox.getText();

        logger.info("Verify given Last name is same ");
        verify.verifyString(verifyLastNameText, profileUpdateDetails.getPropertyValue(UpdateProfileKeys.UPDATE_LAST_NAME_TEXT), "Verify Last Name : ");

        logger.info("Read and Get the email id");
        WebElement updateEmailTextBox = androidDriver.findElement(By.xpath(profileUpdatePath.getPropertyValue(UpdateProfileKeys.UPDATE_EMAIL_TEXT_BOX)));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String verifyEmailText = updateEmailTextBox.getText();

        logger.info("Verify given Email Id name is same ");
        verify.verifyString(verifyEmailText, profileUpdateDetails.getPropertyValue(UpdateProfileKeys.UPDATE_EMAIL_TEXT), "Verify Email Id : ");

        logger.info("Click on back button");
        String backButton = menuPagePath.getPropertyValue(CommonKeys.BACK_BUTTON);
        androidDriver.findElement(By.xpath(backButton)).click();
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}