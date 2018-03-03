package stepdefs_api;

import api.jsontest.ServicesAPIHelper;
import cucumber.api.DataTable;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import pojo.ServiceItem;
import pojo.ServiceList;

import static org.junit.Assert.*;

public class ServicesDef extends AbstractDef {

    private ServicesAPIHelper servicesAPIHelper = new ServicesAPIHelper();

    private ServiceItem createdServiceItem;
    private ServiceItem lastGotServiceItem;

    private ServiceList lastGotServiceList;
    private int initialTotalNumber;

    private String partUrl = "services";

    @When("^GET services is sent$")
    public void getServices() {
        servicesAPIHelper.sendGetAPIRequest(partUrl);
        lastGotServiceList = getGson().fromJson(servicesAPIHelper.getLastResponseBody(), ServiceList.class);
    }

    @When("^GET services with id of last created service$")
    public void getServicesByIdOfLastCreated() {
        servicesAPIHelper.sendGetAPIRequest(partUrl + "/" + createdServiceItem.getId());
        lastGotServiceItem = getGson().fromJson(servicesAPIHelper.getLastResponseBody(), ServiceItem.class);
    }

    @When("^POST services is sent with body$")
    public void postServiceWithAttributes(String jsonBody) {
        servicesAPIHelper.sendJsonInPostRequest(partUrl, jsonBody);
        createdServiceItem = getGson().fromJson(servicesAPIHelper.getLastResponseBody(), ServiceItem.class);
        lastGotServiceItem = createdServiceItem;
    }

    @When("^PATCH last created service is sent with body$")
    public void patchLastCreatedServiceWithAttributes(String jsonBody) {
        servicesAPIHelper.sendJsonInPatchRequest(partUrl + "/" + createdServiceItem.getId(), jsonBody);
        lastGotServiceItem = getGson().fromJson(servicesAPIHelper.getLastResponseBody(), ServiceItem.class);
    }

    @When("^DELETE last created service is sent$")
    public void deleteLastCreatedService() {
        System.out.println("url test " + createdServiceItem.getId());
        servicesAPIHelper.sendDeleteAPIRequest(partUrl + "/" + createdServiceItem.getId());
    }

    @Then("^last response should not be empty$")
    public void lastResponseShouldNotBeEmpty() {
        assertFalse("Last Response is empty", StringUtils.isBlank(servicesAPIHelper.getLastResponseBody()));
    }

    @Then("^last response should be empty$")
    public void lastResponseShouldBeEmpty() {
        assertFalse("Last Response is not empty", StringUtils.isNotBlank(servicesAPIHelper.getLastResponseBody()));
    }

    @Then("^last response should have status '(.*)'$")
    public void lastResponseShouldHaveStatus(int expectedStatus) {
        servicesAPIHelper.verifyLastStatusCode(expectedStatus);
    }

    @And("^last response should contain following data")
    public void lastResponseShouldContain(@Transpose DataTable serviceInfo) {
        ServiceItem serviceItem = serviceInfo.asList(ServiceItem.class).get(0);
        assertEquals(serviceItem, lastGotServiceItem);
    }

    @And("^last response should contain id of last created service")
    public void lastResponseShouldContainLastReceivedServiceId() {
        String lastResponse = servicesAPIHelper.getLastResponseBody();
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
        initialTotalNumber = lastGotServiceList.getTotal();
    }

    @And("^total number should be increased to 1$")
    public void verifyServicesTotalNumberIncreased() {
        lastGotServiceList = getGson().fromJson(servicesAPIHelper.getLastResponseBody(), ServiceList.class);
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
