package steps;

import core.AppiumDriverHelper;
import core.AppiumDriverStorage;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertNotNull;

public class CommonSteps {

    @When("^I launch app$")
    public void iLaunchApp(){
        AppiumDriverStorage.launchDriver();
        assertNotNull("Driver is null", AppiumDriverStorage.getDriver());
    }

    @When("^I swipe through the whole screen from right to left$")
    public void iSwipeThroughTheWholeScreenFromRightToLeft() {
        AppiumDriverHelper.swipeHorizontal(AppiumDriverStorage.getDriver(), 0.9,0.01, 2);
    }
}
