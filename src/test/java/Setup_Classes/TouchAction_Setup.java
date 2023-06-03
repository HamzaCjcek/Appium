package Setup_Classes;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import static Day01.C04_Arabam_Test.driver;

public class TouchAction_Setup {

    public static void performTouchAction(int initialX, int initialY, int finalX, int finalY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(initialX, initialY)).perform();

        // Ardından başka bir noktaya sürükleme işlemi
        touchAction.press(PointOption.point(initialX, initialY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(finalX, finalY))
                .release()
                .perform();
    }
    public static void tekbirlokasyonatıklama_TouchAction(int initialX, int initialY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(initialX, initialY)).release().perform();

    }

    //driver.findElements(new AppiumBy.ByAccessibilityId("divide")).get(0).click();;
        /*TouchAction touchAction = new TouchAction<>(driver);
        touchAction.press(PointOption.point(534,1732))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(537,381))
                .release().perform();
        Thread.sleep(2);
        driver.findElement(By.xpath("//*[@text='Volkswagen']")).click(); */
        /*
        // Koordinatlara tıklama işlemi
        touchAction.tap(PointOption.point(543, 1732)).perform();

        // Ardından başka bir noktaya sürükleme işlemi
        touchAction.press(PointOption.point(543, 1732))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(537, 281))
                .release()
                .perform();
        Thread.sleep(2);
        driver.findElement(By.xpath("//*[@text='Volkswagen']")).click();
         */
}
