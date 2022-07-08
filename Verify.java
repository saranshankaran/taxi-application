package com.taxi.taxi_mobile_automation.verify;

import static org.testng.Assert.assertEquals;
import com.taxi.taxi_mobile_automation.base.TestBase;
import org.apache.log4j.Logger;


/**
 * This class contains verifying using assert class.
 * 
 * @author Saran.S
 *
 */
public class Verify extends TestBase {
	public Logger logger = Logger.getLogger(Verify.class);

	public boolean verifyString(String actualText, String expectedText, String messageInfo) {
		try {
			assertEquals(actualText, expectedText);
			logger.info(messageInfo + ": Pass :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return true;
		} catch (AssertionError assertionError) {

			logger.info(messageInfo + ": Fail :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return false;
		}
	}

	public boolean verifyBoolean(Boolean actualText, Boolean expectedText, String messageInfo) {
		try {
			assertEquals(actualText, expectedText);
			logger.info(messageInfo + ": PASS :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return true;
		} catch (AssertionError assertionError) {

			logger.info(messageInfo + ": FAIL :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return false;
		}
	}

	public boolean verifyBoolean(Integer actualText, Integer expectedText, String messageInfo) {
		try {
			assertEquals(actualText, expectedText);
			logger.info(messageInfo + ": PASS :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return true;
		} catch (AssertionError assertionError) {

			logger.info(messageInfo + ": FAIL :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return false;
		}
	}

	public void verifyBoolean(String actualText, String expectedText, Boolean messageInfo) {
		try {
			assertEquals(actualText, expectedText);
			logger.info("Same " + ": PASS :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);

		} catch (Exception e) {

			logger.info("Different " + ": FAIL :" + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);

		}
	}

}
