package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;

import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class AppiumDriverHelper {

    public static void swipeHorizontal(AppiumDriver driver, double startPercentage,
                                       double finalPercentage, int durationSeconds) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * 0.99);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * finalPercentage);

        new TouchAction(driver).press(point(startPoint, anchor))
                .waitAction(waitOptions(ofSeconds(durationSeconds)))
                .moveTo(point(endPoint, anchor))
                .release()
                .perform();
    }
}
