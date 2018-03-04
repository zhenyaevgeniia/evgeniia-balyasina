package stepdefs_api;

import api.helpers.CommonAPIHelper;
import cucumber.api.DataTable;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import pojo.ServiceItem;
import pojo.ServiceList;
import utils.PrettyJsonUtil;

import static org.junit.Assert.*;

public class CommonDef extends AbstractDef {

    private CommonAPIHelper commonAPIHelper = new CommonAPIHelper();

    private String servicesDynamicUrl = "services";
    private ServiceItem createdServiceItem;
    private ServiceItem lastGotServiceItem;
    private ServiceList lastGotServiceList;
    private int initialTotalNumber;

    /*COMMON STEP DEFINITIONS*/

    @When("^GET '(.*)' is sent$")
    public void getSent(String partUrl) {
        commonAPIHelper.sendGetAPIRequest(partUrl);
    }

    @Then("^last response should not be empty$")
    public void lastResponseShouldNotBeEmpty() {
        assertFalse("Last Response is empty", StringUtils.isBlank(commonAPIHelper.getLastResponseBody()));
    }

    @Then("^last response should be empty$")
    public void lastResponseShouldBeEmpty() {
        assertFalse("Last Response is not empty", StringUtils.isNotBlank(commonAPIHelper.getLastResponseBody()));
    }

    @Then("^last response should have status '(.*)'$")
    public void lastResponseShouldHaveStatus(int expectedStatus) {
        commonAPIHelper.verifyLastStatusCode(expectedStatus);
    }

    @Then("^last response should equal$")
    public void lastResponseShouldEqual(String expectedBody) {
        expectedBody = PrettyJsonUtil.getPrettyFormattedJson(expectedBody);
        String actualBody = commonAPIHelper.getPrettyFormattedLastResponseBody();
        assertEquals("Actual response body does not equal expected. Actual body:\n" + actualBody,
                     expectedBody, actualBody);
    }

    /*STEP DEFINITIONS FOR SERVICES*/

    @When("^GET services with id of last created service$")
    public void getServicesByIdOfLastCreated() {
        commonAPIHelper.sendGetAPIRequest(servicesDynamicUrl + "/" + createdServiceItem.getId());
        lastGotServiceItem = getGson().fromJson(commonAPIHelper.getLastResponseBody(), ServiceItem.class);
    }

    @When("^POST services is sent with body$")
    public void postServiceWithAttributes(String jsonBody) {
        commonAPIHelper.sendJsonInPostRequest(servicesDynamicUrl, jsonBody);
        createdServiceItem = getGson().fromJson(commonAPIHelper.getLastResponseBody(), ServiceItem.class);
        lastGotServiceItem = createdServiceItem;
    }

    @When("^PATCH last created service is sent with body$")
    public void patchLastCreatedServiceWithAttributes(String jsonBody) {
        commonAPIHelper.sendJsonInPatchRequest(servicesDynamicUrl + "/" + createdServiceItem.getId(), jsonBody);
        lastGotServiceItem = getGson().fromJson(commonAPIHelper.getLastResponseBody(), ServiceItem.class);
    }

    @When("^DELETE last created service is sent$")
    public void deleteLastCreatedService() {
        System.out.println("url test " + createdServiceItem.getId());
        commonAPIHelper.sendDeleteAPIRequest(servicesDynamicUrl + "/" + createdServiceItem.getId());
    }

    @And("^last response should contain following data")
    public void lastResponseShouldContain(@Transpose DataTable serviceInfo) {
        ServiceItem serviceItem = serviceInfo.asList(ServiceItem.class).get(0);
        assertEquals(serviceItem, lastGotServiceItem);
    }

    @And("^last response should contain id of last created service")
    public void lastResponseShouldContainLastReceivedServiceId() {
        String lastResponse = commonAPIHelper.getLastResponseBody();
        assertTrue("Response doesn't contain the last created service. Actual response: " + lastResponse,
                   lastResponse.contains(createdServiceItem.getId()));
    }

    @And("^last response should contain last created service$")
    public void lastResponseShouldContainLastCreatedService() {
        assertEquals(createdServiceItem, lastGotServiceItem);
    }

    //Validation of total number in GET /services is made to be sure that items updated correctly
    //I would not do it if pagination on GET works correctly
    @And("^total number of services is stored$")
    public void storeGetServicesTotalNumber() {
        lastGotServiceList = getGson().fromJson(commonAPIHelper.getLastResponseBody(), ServiceList.class);
        initialTotalNumber = lastGotServiceList.getTotal();
    }

    @And("^total number should be increased to 1$")
    public void verifyServicesTotalNumberIncreased() {
        lastGotServiceList = getGson().fromJson(commonAPIHelper.getLastResponseBody(), ServiceList.class);
        assertEquals(initialTotalNumber + 1, lastGotServiceList.getTotal());
    }

    @And("^total number should be decreased to 1$")
    public void verifyServicesTotalNumberDecreased() {
        assertEquals(initialTotalNumber - 1, lastGotServiceList.getTotal());
    }

    @And("^total number should not be changed$")
    public void verifyServicesTotalNumberNotChanged() {
        assertEquals(initialTotalNumber, lastGotServiceList.getTotal());
    }
}
