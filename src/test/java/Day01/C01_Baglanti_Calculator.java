package Day01;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class C01_Baglanti_Calculator {

    public static AndroidDriver driver;
    AppiumDriver appiumDriver; // Hem ios hem de android'de calisir.

    @BeforeTest
    public void beforetest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");//Cihaz İsmi
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");// test senaryolarının Android uygulamasını otomatik olarak kontrol etmesine ve etkileşimde bulunmasına olanak tanır.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");//Android
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");//Version
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\hello\\Downloads\\Selenium_Appium\\Appium\\Apps\\Calculator Vault_1.3.4_Apkpure.apk");//Apk Yolu Uzantısı


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            // Diğer kodlar...
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public static void test1()
    {
       WebElement text1 = driver.findElement(By.id("android:id/text1"));
       text1.sendKeys("1234");
       WebElement text2 = driver.findElement(By.id("android:id/text2"));
       text2.sendKeys("1234");
       driver.findElement(By.id("android:id/button1")).click();
       driver.findElement(By.id("android:id/button1")).click();
       driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[5]")).click();
       WebElement hesaptext = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText[1]"));
       System.out.println(hesaptext.getText());
       driver.findElements(new AppiumBy.ByAccessibilityId("divide")).get(0).click();

    }

    @Test
    public void test()
    {
        driver.activateApp("me.lam.calculatorvault"); // apk bilgisi içine gir orda hesap makinasını bul orda
    }


}
