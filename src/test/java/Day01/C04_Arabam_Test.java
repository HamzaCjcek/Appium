package Day01;

import Setup_Classes.TouchAction_Setup;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Setup_Classes.TouchAction_Setup.performTouchAction;
import static Setup_Classes.TouchAction_Setup.tekbirlokasyonatıklama_TouchAction;


public class C04_Arabam_Test {
    public static AndroidDriver driver;
    AppiumDriver appiumDriver; // Hem ios hem de android'de calisir.
    @BeforeTest
    public void beforetest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");//Cihaz İsmi
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");// test senaryolarının Android uygulamasını otomatik olarak kontrol etmesine ve etkileşimde bulunmasına olanak tanır.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");//Android
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");//Version
        capabilities.setCapability("appPackage","com.dogan.arabam");
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,false); // email password tekrar tek sefer girilmesini sağlar ınstagram gibi
        // false olduğunda işlemleri sıfırlar
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            // Diğer kodlar...
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test() throws InterruptedException {
        //driver.activateApp("com.dogan.arabam"); // apk bilgisi içine gir orda hesap makinasını bul orda
       // driver.findElement(By.xpath("//*[@text=\"İlan ver\"]")).click();
        driver.findElement(By.xpath("//*[@text=\"Arabam kaç para?\"]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.TextView[1]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        performTouchAction(534,1732,537,381);
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@text='Volkswagen']")).click();
        // Tarih Seç
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@text='2022']")).click();
        //Model Seç
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@text='Golf']")).click();
        //Gövde Tipi Seç
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@text='Hatchback/5']")).click();
        //Yakın Tipi Seç
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@text='Hibrit']")).click();
        //Vites Tipi Seç
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@text='Yarı Otomatik']")).click();
        //Locate Tıklama
        Thread.sleep(Duration.ofSeconds(2));
        tekbirlokasyonatıklama_TouchAction(471,1536);
        //Km gir
        Thread.sleep(Duration.ofSeconds(2));
        WebElement km = driver.findElement(By.id("com.dogan.arabam:id/et_km"));
        km.sendKeys("10000");
        km.click();
        //Devam
        driver.findElement(By.id("com.dogan.arabam:id/btn_price_prediction_submit")).click();
        //Renk Seç
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@text='Bej']")).click();
        //Onayla
        Thread.sleep(Duration.ofSeconds(2));
        WebElement onaybutton = driver.findElement(By.xpath("//*[@text='Devam']"));
        onaybutton.click();
        //Tramer Kaydı
        driver.findElement(By.id("com.dogan.arabam:id/rbHasTramerEntry")).click();
        //Tutar
        WebElement tramerkaydıtutar = driver.findElement(By.id("com.dogan.arabam:id/etPriceValue"));
        tramerkaydıtutar.click();
        tramerkaydıtutar.sendKeys("1000");
        //Devam
        driver.findElement(By.id("com.dogan.arabam:id/btnNext")).click();


        //Uygulamayı Kapat
        driver.quit();

    }
}
