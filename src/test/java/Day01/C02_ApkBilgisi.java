package Day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C02_ApkBilgisi {
    public static AndroidDriver driver;
    String device_name="PIXEL";
    String automation_name="UiAutomator2";
    String platform_name="Android";
    String platform_version="11.0";
    AppiumDriver appiumDriver; // Hem ios hem de android'de calisir.

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device_name);//Cihaz İsmi
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automation_name);// test senaryolarının Android uygulamasını otomatik olarak kontrol etmesine ve etkileşimde bulunmasına olanak tanır.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platform_name);//Android
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platform_version);//Version
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\hello\\Downloads\\Selenium_Appium\\Appium\\Apps\\Apk Bilgisi_2.3.5_apkcombo.com.apk");//Apk Yolu Uzantısı


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            // Diğer kodlar...
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
