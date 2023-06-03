package utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AndroidDriver appiumDriver;
    public static AndroidDriver getAndroidDriver()  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");//Cihaz İsmi
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");// test senaryolarının Android uygulamasını otomatik olarak kontrol etmesine ve etkileşimde bulunmasına olanak tanır.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");//Android
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");//Version
        capabilities.setCapability("appPackage","com.smartwho.SmartAllCurrencyConverter");
        capabilities.setCapability("appActivity","com.smartwho.SmartAllCurrencyConverter.CurrencyConverter");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,true); // email password tekrar tek sefer girilmesini sağlar ınstagram gibi
        // false olduğunda işlemleri sıfırlar
        try {
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            // Diğer kodlar...
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appiumDriver;
    }


    public static void quitAppiumDriver(){
        if (appiumDriver != null) {
            appiumDriver.closeApp();
            appiumDriver = null;
        }
    }
}

