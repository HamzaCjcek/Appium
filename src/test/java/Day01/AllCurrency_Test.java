package Day01;

import Setup_Classes.TouchAction_Setup;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AllCurrency_Test {
     public static AndroidDriver driver = Driver.getAndroidDriver();
    @Test
    public static void testAllCurrency() throws InterruptedException, IOException {
        //String price= page.ticketPrice.getText();
        //driver.sendSMS("5555555555",price);
        driver.activateApp("com.smartwho.SmartAllCurrencyConverter");
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"),"uygulama yukleme basarisiz");
        WebElement anasayfahead=driver.findElement(By.xpath("//*[@text='CURRENCY CONVERTER']"));
        String expected = "CURRENCY CONVERTER";
        Assert.assertEquals(anasayfahead.getText(),expected);
        if(anasayfahead.getText().equals(expected))
        {
            System.out.println("Uygulama Açıldı");
        }
        else
        {
            System.out.println("Uygulama Açılmadı");
        }
        WebElement ilkKategori=  driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/linearLayoutPopupHistory"));
        ilkKategori.click();
        // ReusableMethods.scrollWithUiScrollable("PLN");
        Thread.sleep(Duration.ofSeconds(1));
        ReusableMethods.scrollWithUiScrollable("//*[@text='VES']");
        // cevrilen tutar screenShot olarak kaydedilir
        File ekranfotografi=driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranfotografi,new File("ahmet.jpg"));
        ReusableMethods.getScreenshot("VES");
        Thread.sleep(Duration.ofSeconds(7));
        ilkKategori.click();
        TouchAction_Setup.performTouchAction(308,349,301,1191);
        ReusableMethods.scrollWithUiScrollable("//*[@text='TRY']");
    }
}
