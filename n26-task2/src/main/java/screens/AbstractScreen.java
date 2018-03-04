package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractScreen {

    private final AppiumDriver driver;

    protected AbstractScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected AppiumDriver getDriver() {
        return driver;
    }

    public boolean isElementDisplayed(String id){
        return driver.findElementById(id).isDisplayed();
    }
}
