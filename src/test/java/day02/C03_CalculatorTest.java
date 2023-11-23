package day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.net.MalformedURLException;
import java.net.URL;

public class C03_CalculatorTest {
    // appium inspector kullanma zamani
    AndroidDriver<AndroidElement> androidDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    @BeforeTest
    public void setUpCalculatorApk() throws MalformedURLException {
        capabilities.setCapability("deviceName","Pixel 2 API 30");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("app",System.getProperty("user.dir")+"/app/Calculator.apk");
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"),capabilities) ;
    }

    @Test
    public void multiplicationTest(){
        androidDriver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
        androidDriver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        androidDriver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        androidDriver.findElement(By.id("com.google.android.calculator:id/eq")).click();
    }

    @AfterTest
    public void tearDown(){
        androidDriver.quit();
    }

}
