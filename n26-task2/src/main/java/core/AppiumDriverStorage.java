package core;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverStorage {

    private static final String APK_PATH = "app/CoCoin.apk";

    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            launchDriver();
        }
        return driver;
    }

    public static void launchDriver() {
        File apkFile = new File(APK_PATH);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("deviceName", "Nexus 5X");
        capabilities.setCapability("app", apkFile.getAbsolutePath());

        try {
            driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Cannot handle Appium server URL: " + e.getMessage());
        }
    }
}
