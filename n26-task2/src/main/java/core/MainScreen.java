package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.AbstractScreen;

import java.util.NoSuchElementException;

public class MainScreen extends AbstractScreen {

    @AndroidFindBy(id = "text_0")
    private MobileElement firstScreenText;

    @AndroidFindBy(id = "text_1")
    private MobileElement secondScreenText;

    @AndroidFindBy(id = "text_2")
    private MobileElement thirdScreenText;

    @AndroidFindBy(id = "text_3")
    private MobileElement forthScreenText;

    @AndroidFindBy(id = "viewpager_main_activity")
    private MobileElement viewPager;

    @AndroidFindBy(id = "edit_view_ly")
    private MobileElement editViewLayout;

    @AndroidFindBy(id = "password_tip")
    private MobileElement passwordTip;

    @AndroidFindBy(id = "gridview")
    private MobileElement gridView;

    public MainScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getFirstScreenText() {
        return firstScreenText.getText().trim();
    }

    public String getSecondScreenText() {
        return secondScreenText.getText().trim();
    }

    public String getThirdScreenText() {
        return thirdScreenText.getText().trim();
    }

    public String getForthScreenText() {
        return forthScreenText.getText().trim();
    }

    public boolean isViewPagerPresent() {
        try {
            return viewPager != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEditViewLayoutPresent() {
        try {
            return editViewLayout != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getPasswordTip() {
        return passwordTip.getText().trim();
    }

    public boolean isGridViewDisplayed() {
        return gridView.isDisplayed();
    }

    public void waitForDotsView(){
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dotsview_main")));
    }
}
