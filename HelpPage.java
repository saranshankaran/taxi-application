package com.taxi.taxi_mobile_automation.pages;

import com.taxi.taxi_mobile_automation.page.keys.CommonKeys;
import com.taxi.taxi_mobile_automation.page.keys.HelpKeys;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.taxi.taxi_mobile_automation.constants.FilePathConstants;
import com.taxi.taxi_mobile_automation.utils.PropertyParser;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class HelpPage {
    public Logger logger = Logger.getLogger(HelpPage.class);
    PropertyParser helpPath = new PropertyParser(FilePathConstants.HELP_PATH);
    PropertyParser menuPagePath = new PropertyParser(FilePathConstants.MENU_PAGE_PATH);

    /**
     * This method will verify that help support popup with successful message is
     * displayed or not.
     */
    public boolean verifyHelpPopup(AppiumDriver androidDriver) {
        try {
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Done");
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            logger.info("Click on call Support button");
            String callSupportButton = helpPath.getPropertyValue(HelpKeys.CALL_SUPPORT_BUTTON);
            androidDriver.findElement(By.id(callSupportButton)).click();
            System.out.println(callSupportButton);

            logger.info("Read and get the popup message");
            WebElement text = androidDriver.findElement(By.xpath(helpPath.getPropertyValue(HelpKeys.VERIFY_SUPPORT)));
            String actual = text.getText();
            System.out.println(actual);

            logger.info("Verify that the popup message is same or not");
            Assert.assertEquals(actual.contains(helpPath.getPropertyValue(HelpKeys.PASS_MESSAGE)), true);

            logger.info("Click on Ok button");
            String popupOkButton = helpPath.getPropertyValue(CommonKeys.OK_BUTTON);
            androidDriver.findElement(By.xpath(popupOkButton)).click();

            logger.info("Click on Back button");
            String backButton = menuPagePath.getPropertyValue(CommonKeys.BACK_BUTTON);
            androidDriver.findElement(By.xpath(backButton)).click();
            return true;
        } catch (Exception e) {
            logger.info("Failed message popup is displayed");
            return false;
        }
    }
}


