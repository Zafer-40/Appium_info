package day05;


import io.appium.java_client.android.AndroidTouchAction;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ApiDemosPage;
import utils.Hooks;
import utils.ReusableMethods;

import static io.appium.java_client.touch.offset.PointOption.point;


public class C06_ApiDemosTest extends Hooks {

    ApiDemosPage apiDemosPage = new ApiDemosPage();
    ReusableMethods reusableMethods = new ReusableMethods();
    public AndroidTouchAction action;

    @Test
    public void clickAccessibilityButton() {
        apiDemosPage.clickElement(apiDemosPage.getAccessibilityButton());
    }

    @Test
    public void tabOntheWithTouchAction() {
        action = new AndroidTouchAction(androidDriver);
        action.tap(point(85, 656)).perform();
    }

    @Test
    public void tabWithMethod() {
        reusableMethods.tabOnThePoint(85, 656);
    }

    @Test
    public void scrollTest() {
        apiDemosPage.clickElement(apiDemosPage.getViewButton());
        action = new AndroidTouchAction(androidDriver);
        action.longPress(point(481, 1287))
                .moveTo(point(552, 425))
                .release().perform();
    }

    @Test
    public void scrollTestWithMethod(){
        apiDemosPage.clickElement(apiDemosPage.getViewButton());
        reusableMethods.scroll(481,1287,552,425);
        Assert.assertTrue(apiDemosPage.getListsButton().isDisplayed());
    }

}




