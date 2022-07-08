package com.taxi.taxi_mobile_automation.constants;

//C:\Users\saran.shankaran\taxi-workspace\taxi-mobile-automation\src\main\resources\locators\registration.properties
import java.io.File;

public class FilePathConstants {

    public static final String USER_HOME = System.getProperty("user.dir") + File.separator;
    public static final String MAIN_HOME = USER_HOME + "src" + File.separator + "main" + File.separator;
    public static final String RESOURCE_HOME = MAIN_HOME + "resources" + File.separator;
    public static final String LOCATORS_HOME = RESOURCE_HOME + "locators" + File.separator;
    public static final String REGISTRATION_PATH = LOCATORS_HOME + "registration.properties";
    public static final String LOGIN_PATH = LOCATORS_HOME + "login.properties";
    public static final String LOGOUT_PATH = LOCATORS_HOME + "logout.properties";
    public static final String MENU_PAGE_PATH = LOCATORS_HOME + "menu-page.properties";
    public static final String HELP_PATH = LOCATORS_HOME + "help-page.properties";
    public static final String CHANGE_PASSWORD = LOCATORS_HOME + "change-password.properties";
    public static final String DELETE_PATH = LOCATORS_HOME + "delete-account.properties";
    public static final String PROFILE_UPDATE_PATH = LOCATORS_HOME + "update-profile.properties";
    public static final String RIDE_NOW_PATH = LOCATORS_HOME + "ride-now.properties";
    public static final String RIDE_LATER_PATH = LOCATORS_HOME + "ride-later.properties";
    public static final String TEST_DATA_HOME = RESOURCE_HOME + "testdata" + File.separator;
    public static final String CAPABILITIES_DETAIL = RESOURCE_HOME + "capabilities.properties";
    public static final String REGISTRATION_DETAIL = TEST_DATA_HOME + "registration-details.properties";
    public static final String LOGIN_DETAIL = TEST_DATA_HOME + "logindetails.properties";
    public static final String CHANGE_PASSWORD_DETAILS = TEST_DATA_HOME + "change-password-details.properties";
    public static final String PROFILE_UPDATE_DETAILS = TEST_DATA_HOME + "profile-update-details.properties";
    public static final String RIDE_NOW_DETAILS = TEST_DATA_HOME + "ridenowdetails.properties";
    public static final String RIDE_LATER_DETAILS = TEST_DATA_HOME + "ridelaterdetails.properties";
    public static final String REGISTER_POPUP_PATH = LOCATORS_HOME + "register-popup.properties";
    public static final String REGISTER_POPUP_DETAILS = TEST_DATA_HOME + "register-popup-messages.properties";
    public static final String LOG4J_HOME = RESOURCE_HOME + "log4j" + File.separator;
    public static final String LOG4J_PROPERTY = LOG4J_HOME + "log4j.properties";

}
