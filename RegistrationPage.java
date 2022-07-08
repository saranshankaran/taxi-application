package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.actions.ElementAction;
import com.taxi.taxi_mobile_automation.constants.FilePathConstants;

import com.taxi.taxi_mobile_automation.page.keys.CommonKeys;
import com.taxi.taxi_mobile_automation.page.keys.RegistrationKeys;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import com.taxi.taxi_mobile_automation.verify.Verify;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;



public class RegistrationPage  {
    ElementAction action = new ElementAction();
    public Logger logger = Logger.getLogger(RegistrationPage.class);
    PropertyParser registrationPath = new PropertyParser(FilePathConstants.REGISTRATION_PATH);
    PropertyParser registrationDetail = new PropertyParser(FilePathConstants.REGISTRATION_DETAIL);
    PropertyParser registrationPopupDetails = new PropertyParser(FilePathConstants.REGISTER_POPUP_DETAILS);
    PropertyParser registerPopupPath = new PropertyParser(FilePathConstants.REGISTER_POPUP_PATH);
    PropertyParser menuPagePath = new PropertyParser(FilePathConstants.MENU_PAGE_PATH);
    Verify verify = new Verify();
    LoginPage loginPage = new LoginPage();

    /**
     * This method verifies that user able to register to the application or not.
     *
     * @return true or false
     */
    public boolean registerUser(AppiumDriver androidDriver) {

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        try {
            logger.info("Register page is Displayed");
            logger.info("Enter the First name");
            String firstNamElement = registrationPath.getPropertyValue(RegistrationKeys.FIRST_NAME_TEXT_BOX);
            androidDriver.findElement(By.id(firstNamElement)).sendKeys(registrationDetail.getPropertyValue(RegistrationKeys.FIRST_NAME_TEXT));


            logger.info("Enter the Last name");
            String lastNamElement = registrationPath.getPropertyValue(RegistrationKeys.LAST_NAME_TEXT_BOX);
            androidDriver.findElement(By.id(lastNamElement)).sendKeys(registrationDetail.getPropertyValue(RegistrationKeys.LAST_NAME_TEXT));


            logger.info("Enter the MobileNumber");
            String mobileNumber = registrationPath.getPropertyValue(RegistrationKeys.MOBILE_NUMBER_TEXT_BOX);
            androidDriver.findElement(By.id(mobileNumber)).sendKeys(registrationDetail.getPropertyValue(RegistrationKeys.MOBILE_NUMBER_TEXT));


            logger.info("Enter the Valid Email id");
            String emailTextBox = registrationPath.getPropertyValue(RegistrationKeys.EMAIL_ADDRESS_TEXTBOX);
            androidDriver.findElement(By.id(emailTextBox)).sendKeys(registrationDetail.getPropertyValue(RegistrationKeys.EMAIL_ADDRESS_TEXT));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("Enter the password");
            String password = registrationPath.getPropertyValue(RegistrationKeys.PASSWORD_TEXT_BOX);
            androidDriver.findElement(By.id(password)).sendKeys(registrationDetail.getPropertyValue(RegistrationKeys.PASSWORD_TEXT));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("Enter the password again to confirm");
            String confirmPasswordTextBox = registrationPath.getPropertyValue(RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX);
            androidDriver.findElement(By.id(confirmPasswordTextBox)).sendKeys(registrationDetail.getPropertyValue(RegistrationKeys.CONFIRM_PASSWORD_TEXT));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("Click on Register button");
            String registerButton = registrationPath.getPropertyValue(RegistrationKeys.REGISTER_BUTTON);
            androidDriver.findElement(By.id(registerButton)).click();
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("Click on Ok button");
            String okButton = registrationPath.getPropertyValue(CommonKeys.OK_BUTTON);
            androidDriver.findElement(By.id(okButton)).click();
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            logger.info("(: User Registered Succcessfully :)");

            logger.info("Page directed to Login page!!");

            return true;

        } catch (Exception e) {
            logger.info("! User Registration failed !");
            return false;
        }

    }
    /**
     * This method verifies popup is displayed when user lefts the firstName text
     * box empty. Verify actual and expected popup is equal or not.
     */
    public void verifyFirstNamePopup(AppiumDriver androidDriver) {

        
        logger.info("--------First Name Empty Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue( RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for not entering the first name");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue( RegistrationKeys.FIRST_NAME_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.FIRST_NAME_EMPTY_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");

        verify.verifyString(getActualPopupText, expectedPopupText, "Verify First name popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue(CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Enter the first name text");
        WebElement firstNametextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.FIRST_NAME_TEXT_BOX)));
        action.TextBox(firstNametextBox, registrationDetail.getPropertyValue(RegistrationKeys.FIRST_NAME_TEXT));
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user lefts the lastName text box
     * empty. Verify actual and expected popup is equal or not.
     */
    public void verifyLastNamePopup(AppiumDriver androidDriver) {

        logger.info("--------Last Name Empty Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue(RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for not entering the last name");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue(RegistrationKeys.LAST_NAME_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.LAST_NAME_EMPTY_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify Last Name popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue(CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Enter the last name text");
        WebElement lastNameTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue(RegistrationKeys.LAST_NAME_TEXT_BOX)));
        action.TextBox(lastNameTextBox,
                registrationDetail.getPropertyValue(RegistrationKeys.LAST_NAME_TEXT));
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user lefts the mobile number
     * text box empty. Verify actual and expected popup is equal or not.
     */
    public void verifyMobileNumberPopup(AppiumDriver androidDriver) {

        logger.info("--------First Name Empty Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue(RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for not entering the mobile number");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue( RegistrationKeys.MOBILE_NUMBER_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.MOBILE_NUMBER_EMPTY_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify Mobile number popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue( CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Enter the mobile number");
        WebElement mobileNumberTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
        action.TextBox(mobileNumberTextBox, registrationPopupDetails.getPropertyValue(
                RegistrationKeys.INVALID_MOBILE_NUMBER_TEXT));
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user enters invalid mobile
     * number. Verify actual and expected popup is equal or not.
     */
    public void verifyValidNumberPopup(AppiumDriver androidDriver) {

        logger.info("--------Invalid Mobile Number Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue( RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for not entering the valid mobile number");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue(RegistrationKeys.VALID_MOBILE_NUMBER_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.INVALID_NUMBER__MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify valid number popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue( CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Enter the valid mobile number");
        WebElement mobileNumberTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
        action.TextBox(mobileNumberTextBox, registrationDetail.getPropertyValue(
                RegistrationKeys.MOBILE_NUMBER_TEXT));
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user lefts the email id text box
     * empty. Verify actual and expected popup is equal or not.
     */
    public void verifyEmailPopup(AppiumDriver androidDriver) {

        logger.info("--------Invalid Email ID Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue( RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for not entering the valid email id");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue( RegistrationKeys.EMAIL_ID_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.EMAIL_ID_EMPTY_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify Email popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue( CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Enter the valid valid email id");
        WebElement emailTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.EMAIL_ADDRESS_TEXTBOX)));
        action.TextBox(emailTextBox, registrationDetail.getPropertyValue(
                RegistrationKeys.EMAIL_ADDRESS_TEXT));
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user lefts the password text box
     * empty. Verify actual and expected popup is equal or not.
     */
    public void verifyPasswordPopup(AppiumDriver androidDriver) {

        logger.info("--------Password Empty Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue( RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for not entering the password");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue( RegistrationKeys.PASSWORD_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.PASSWORD_EMPTY_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify Password popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue( CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Enter the password upto 5 digits");
        WebElement passwordTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.PASSWORD_TEXT_BOX)));
        action.TextBox(passwordTextBox,
                registrationPopupDetails.getPropertyValue( RegistrationKeys.PASSWORD));
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user lefts the confirm password
     * text box empty. Verify actual and expected popup is equal or not.
     */
    public void verifyConfirmPasswordPopup(AppiumDriver androidDriver) {

        logger.info("--------Comfirm Password Empty Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue( RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for not entering the Confrim password");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue(RegistrationKeys.CONFIRM_PASSWORD_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.CONFIRM_PASSWORD_EMPTY_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify Confirm Password popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue( CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Enter the password again upto 5 digits to confirm");
        WebElement confirmPasswordTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
        action.TextBox(confirmPasswordTextBox, registrationPopupDetails.getPropertyValue(
                RegistrationKeys.CONFIRM_PASSWORD));
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user enters the password less
     * than 6 digits.Verify actual and expected popup is equal or not.
     */
    public void verifyPasswordLengthPopup(AppiumDriver androidDriver) {

        logger.info("--------Password less than 6 Digits Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue( RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for not entering the password greater than 6 digits");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue( RegistrationKeys.PASSWORD_LENGTH_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.PASSWORD_LENGTH_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify Password length popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue( CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Enter the valid password");
        WebElement passwordTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue(RegistrationKeys.PASSWORD_TEXT_BOX)));
        passwordTextBox.clear();
        action.TextBox(passwordTextBox,
                registrationDetail.getPropertyValue(RegistrationKeys.PASSWORD_TEXT));
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user enters the password and
     * confirm password with different inputs .Verify actual and expected popup is
     * equal or not.
     */
    public void verifyPasswordNotMatchPopup(AppiumDriver androidDriver) {

        logger.info("--------Password Mismatch Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue( RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for not entering the password and confirm password same");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue( RegistrationKeys.PASSWORD_NOT_MATCH_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.PASWORD__NOTMATCH_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify Password Mismatch popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue( CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Enter the valid password again to confirm");
        WebElement confirmPasswordTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
        action.TextBox(confirmPasswordTextBox, registrationDetail.getPropertyValue(
                RegistrationKeys.CONFIRM_PASSWORD_TEXT));
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user click on register button.
     * Verify actual and expected popup is equal or not.
     */
    public void verifySuccessPopup(AppiumDriver androidDriver) {

        logger.info("--------Register Successful Pop Up---------");
        logger.info("Click register here");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue( RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);

        logger.info("Read and get the popup message for succesful register");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue( RegistrationKeys.SUCCESSFUL_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.SUCCESS_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify Success popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue( CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);
        System.out.println();
    }

    /**
     * This method verifies popup is displayed when user registers with the same
     * credentials.Verify actual and expected popup is equal or not.
     */
    public void verifyAlreadyRegisteredPopup(AppiumDriver androidDriver) {

        logger.info("--------User Already Registered Pop Up---------");

        loginPage.clickRegisterHereLink(androidDriver);

        logger.info("Enter the First name");
        WebElement firstNametextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.FIRST_NAME_TEXT_BOX)));
        action.TextBox(firstNametextBox, registrationDetail.getPropertyValue(
                RegistrationKeys.FIRST_NAME_TEXT));

        logger.info("Enter the Last name");
        WebElement lastNameTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.LAST_NAME_TEXT_BOX)));
        action.TextBox(lastNameTextBox,
                registrationDetail.getPropertyValue( RegistrationKeys.LAST_NAME_TEXT));

        logger.info("Enter the MobileNumber");
        WebElement mobileNumberTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
        action.TextBox(mobileNumberTextBox, registrationDetail.getPropertyValue(
                RegistrationKeys.MOBILE_NUMBER_TEXT));

        logger.info("Enter the Valid Email id");
        WebElement emailTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.EMAIL_ADDRESS_TEXTBOX)));
        action.TextBox(emailTextBox, registrationDetail.getPropertyValue(
                RegistrationKeys.EMAIL_ADDRESS_TEXT));

        logger.info("Enter the password");
        WebElement passwordTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.PASSWORD_TEXT_BOX)));
        action.TextBox(passwordTextBox,
                registrationDetail.getPropertyValue( RegistrationKeys.PASSWORD_TEXT));

        logger.info("Enter the password again to confirm");
        WebElement confirmPasswordTextBox = androidDriver.findElement(By.id(registrationPath
                .getPropertyValue( RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
        action.TextBox(confirmPasswordTextBox, registrationDetail.getPropertyValue(
                RegistrationKeys.CONFIRM_PASSWORD_TEXT));

        logger.info("Click on Register button");
        WebElement registerButton = androidDriver.findElement(By.id(
                registrationPath.getPropertyValue( RegistrationKeys.REGISTER_BUTTON)));
        action.clickButton(registerButton);


        logger.info("Read and get the popup message for already register");
        WebElement popUpElement = androidDriver.findElement(By.id(registerPopupPath
                .getPropertyValue( RegistrationKeys.ALREADY_REGISTER_POPUP)));
        String getActualPopupText = action.Element_text(popUpElement);

        String expectedPopupText = registrationPopupDetails.getPropertyValue(
                RegistrationKeys.ALREADY_REGISTER_MESSAGE);

        logger.info("Verifying the actual popup and expected popup");
        verify.verifyString(getActualPopupText, expectedPopupText, "Verify User Already registered popup :");

        logger.info("Click ok button");
        WebElement okButton = androidDriver.findElement(
                By.id(registrationPath.getPropertyValue( CommonKeys.OK_BUTTON)));
        action.clickButton(okButton);

        logger.info("Click on Back button");
        WebElement backButton = androidDriver.findElement(
                By.xpath(menuPagePath.getPropertyValue( CommonKeys.BACK_BUTTON)));
        action.clickButton(backButton);
    }

}




