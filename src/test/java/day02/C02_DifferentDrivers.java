package day02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C02_DifferentDrivers {

    /*
    Tabloda sadece Android uygulamalarını test ediyorsak, AndroidDriver kullanılması önerilir.
    Android ve IOS uygulamalarını test ediyorsak, AppiumDriver kullanmalıyız.
    Eğer IOS uygulamalarını test etmeyecekseniz, AppiumDriver kullanmanıza gerek yok.
     */

    AppiumDriver<MobileElement> appiumDriver;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Test
    public void isCalculatorAppInstalled() throws MalformedURLException {
        // calculator aplikasyonu yuklenmismi test ediliyor?

        capabilities.setCapability("deviceName","Pixel 2 API 29");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","10.0");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("app",System.getProperty("user.dir")+"/app/Calculator.apk");
        appiumDriver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723"),capabilities) ;
        /*
        "isAppInstalled'ı test etmek için uygulamanın paket kimliğini bulmalıyız.
        APK bilgisini APK Pure websitesinden indirebiliriz."
         */
        Assert.assertTrue(appiumDriver.isAppInstalled("com.google.android.calculator"));
    }

    /*
    Node.js kullaniyorsaniz, Java nin MobileCapabilityType nin dogrudan access i yoktur
    bu sebepten hata alinma riski olabilir
     */

    @Test
    public void capabilityTypes() throws MalformedURLException {
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 29");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/app/Calculator.apk");
        appiumDriver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723"),capabilities) ;

    }
}
