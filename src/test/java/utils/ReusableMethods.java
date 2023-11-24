package utils;

import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.offset.PointOption.point;

public class ReusableMethods {

    Driver driver = new Driver();
    TouchAction action = new TouchAction<>(driver.getAndroidDriver());

    public void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tabOnThePoints(int StartPointx,int StartPointy){
        action.tap(point(StartPointx,StartPointy)).perform();
    }
}
