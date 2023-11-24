package day04;

import io.appium.java_client.TouchAction;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.AndroidTestPage;
import utils.Driver;
import utils.ReusableMethods;

import static io.appium.java_client.touch.offset.PointOption.point;
/*
Positive Test Case:
Test Case 01: Verify Successful Login with Valid Credentials
Test Steps:


3-Select a Gender
4-Close the Information Text
5-Click the notification sign
6-Enter a valid email address and a password with at least 7 characters.
7-Tap on the login button.
8-Asser the home page header text
Expected Result:
User should be logged in successfully and directed to the home/dashboard page.
 */

public class C05_AndroidTestApk {
    Driver driver = new Driver();
    AndroidTestPage androidTestPage = new AndroidTestPage();
    ReusableMethods reusableMethods = new ReusableMethods();

    @BeforeTest
    public void setUp() {

        driver.getAndroidDriver();
    }

    @Test
    public void tabOnThePointwithTouchAction() {
        TouchAction action = new TouchAction<>(driver.getAndroidDriver());
        action.tap(point(102,148)).perform();
        reusableMethods.waitFor(3);
    }

    @Test
    public void dynamicTabMethodUsing(){
        reusableMethods.tabOnThePoints(102,148);
    }


    @AfterTest
    public void tearDown() {
        //driver.closeAppiumDriver();

    }
}
