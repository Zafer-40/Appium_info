package day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetUpCapabilities {
    // Set-up Appium Environments

    // 1.Adım: AndroidDriver sınıfından bir android sürücüsü oluşturun.

    AndroidDriver<AndroidElement> androidDriver;


    // 2.Adım: DesiredCapabilities sınıfından capabilities nesneleri oluşturun.

    DesiredCapabilities capabilities = new DesiredCapabilities();


     /*
    Neden capabilities kullanmalıyız?
    1- Emülatörün adını, işletim sistemini, URL'yi, otomasyon adını, uygulama adını tanımlamalıyız.
    2- capabilities, bir anahtar-değer(key value) çifti olarak çalışıyor.
     */

    @Test
    public void setUpCalculator() throws MalformedURLException {
        capabilities.setCapability("deviceName","Pixel 2 API 29");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","10.0");
        capabilities.setCapability("automationName","UiAutomator2");
        // Download an application from the apkPure
        // create a directory with name app under the project name then drag and drop the downloaded app
        capabilities.setCapability("app",System.getProperty("user.dir")+"/app/Calculator.apk");
        // set-up the driver and implement the url
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"),capabilities) ;

    }

}
