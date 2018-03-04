package steps;

import core.AppiumDriverHelper;
import core.AppiumDriverStorage;
import core.MainScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MainScreenSteps {

    private MainScreen mainScreen;

    @Then("^I should (?:be redirected to|remain on) main screen$")
    public void iShouldBeRedirectedToMainScreen() {
        mainScreen = new MainScreen(AppiumDriverStorage.getDriver());

        assertTrue("Expected view pager is not present", mainScreen.isViewPagerPresent());

        mainScreen.waitForDotsView();
    }

    @Then("^main screen should have visible first screen text '(.*)'$")
    public void mainScreenShouldHaveVisibleFirstScreenText(String expectedText) {
        String actualText = mainScreen.getFirstScreenText();

        assertEquals("Unexpected text is visible: " + actualText, expectedText, actualText);
    }

    @And("^main screen should have visible icons with the following ids$")
    public void mainScreenShouldHaveVisibleIconsWithTheFollowingIds(List<String> ids) {
        for (String id : ids) {
            assertTrue(String.format("Element with id '%s' is not visible", id),
                    mainScreen.isElementDisplayed(id));
        }
    }

    @And("^main screen should have edit view layout$")
    public void mainScreenShouldHaveEditViewLayout() {
        assertTrue("Edit view layout is not present", mainScreen.isEditViewLayoutPresent());
    }

    @And("^main screen should have visible grid view$")
    public void mainScreenShouldHaveVisibleGridView() {
        assertTrue("Grid view is not displayed", mainScreen.isGridViewDisplayed());
    }

    @And("^main screen should have password tip$")
    public void mainScreenShouldHavePasswordTip(String expectedPasswordTip) {
        String actualPasswordTip = mainScreen.getPasswordTip();

        assertEquals("Unexpected tip is visible: " + actualPasswordTip, expectedPasswordTip, actualPasswordTip);
    }

    @When("^I swipe through the whole main screen from right to left (\\d+) times$")
    public void iSwipeThroughTheWholeMainScreenFromRightToLeftTimes(int timesAmount) {
        IntStream.range(0, timesAmount).forEach(i -> {
            AppiumDriverHelper.swipeHorizontal(AppiumDriverStorage.getDriver(), 0.9,0.01, 2);
            iShouldBeRedirectedToMainScreen();
        });
    }
}
