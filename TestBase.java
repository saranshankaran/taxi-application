package com.taxi.taxi_mobile_automation.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import com.taxi.taxi_mobile_automation.constants.FilePathConstants;
import com.taxi.taxi_mobile_automation.page.keys.RegistrationKeys;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {
    public static AndroidDriver androidDriver;
    public JavascriptExecutor executor;
    PropertyParser registrationPath = new PropertyParser(FilePathConstants.REGISTRATION_PATH);
    /**
     * This class is used for launching the appium server and taxi
     * application.
     *
     * @author Saran.S
     *
     */
    @BeforeSuite
    public void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "9.0");
            capabilities.setCapability("deviceName", "Pixel 2");
            capabilities.setCapability("appPackage", "com.atmecs.taxi");
            capabilities.setCapability("appActivity", "com.atmecs.taxi.LoginActivity");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            androidDriver = new AndroidDriver(url, capabilities);

            String allowElement = registrationPath.getPropertyValue(RegistrationKeys.SMS_PERMISSION);
            androidDriver.findElement(By.xpath(allowElement)).click();
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            String deviceLocationElement = registrationPath.getPropertyValue(RegistrationKeys.LOCATION_PERMISSION);
            androidDriver.findElement(By.xpath(deviceLocationElement)).click();
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }

    @AfterSuite
    public void quit() {

        androidDriver.quit();
    }
}