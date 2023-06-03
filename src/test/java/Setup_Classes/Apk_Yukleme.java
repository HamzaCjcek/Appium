package Setup_Classes;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Apk_Yukleme {

    public static AndroidDriver driver;
    AppiumDriver appiumDriver; // Hem ios hem de android'de calisir.

    @Test
    public void beforetest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");//Cihaz İsmi
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");// test senaryolarının Android uygulamasını otomatik olarak kontrol etmesine ve etkileşimde bulunmasına olanak tanır.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");//Android
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");//Version
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\hello\\Downloads\\Selenium_Appium\\Appium\\Apps\\arabam.com_ 2.El Araç Al & Sat_4.8.2_apkcombo.com.apk");//Apk Yolu Uzantısı


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            // Diğer kodlar...
        } catch (Exception e) {
            e.printStackTrace();
        }
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

}
