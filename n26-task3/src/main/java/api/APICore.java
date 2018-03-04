package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PrettyJsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class APICore {

    private ExtractableResponse<Response> lastResponse = null;
    private String lastRequest = null;
    private RequestMethod lastRequestMethod = null;

    protected ExtractableResponse<Response> getLastResponse() {
        return lastResponse;
    }

    public String getLastResponseBody() {
        return lastResponse.response().body().asString();
    }

    public JsonPath getLastResponseBodyJson() {
        return lastResponse.response().body().jsonPath();
    }

    public String getPrettyFormattedLastResponseBody() {
        return PrettyJsonUtil.getPrettyFormattedJson(getLastResponseBody());
    }

    protected String getLastRequestUrl() {
        return lastRequest;
    }

    protected RequestMethod getLastRequestMethod() {
        return lastRequestMethod;
    }

    /**
     * Clear last response value; set new request url and params
     *
     * @param url    request url
     * @param params request parameters
     */
    private void updateLastRequest(String url, Map<String, String> params, RequestMethod requestMethod) {
        lastResponse = null;
        lastRequest = url;
        lastRequestMethod = requestMethod;
    }

    /**
     * GET HTTP request with necessary headers
     *
     * @param url fully qualified URL to request
     * @return response
     */
    protected ExtractableResponse<Response> get(String url) {
        return given().get(url).then().extract();
    }

    /**
     * Build up API query with parameters and/or cookies
     *
     * @param params parameters
     * @return RequestSpecification
     */
    protected RequestSpecification request(Map<String, String> params) {

        RestAssured.useRelaxedHTTPSValidation();

        RequestSpecification given = given();

        //Add provided parameters to the request
        for (Map.Entry<String, String> param : params.entrySet()) {
            //Re-use session, only if id was provided
            if (param.getKey().equals("X-Requested-With")) {
                given.header("X-Requested-With", "XMLHttpRequest");
                continue;
            }
            given.formParams(param.getKey(), param.getValue());
        }
        return given;
    }

    /**
     * Sends GET request
     *
     * @param url fully qualified URL
     */
    private void sendGetRequest(String url) {
        updateLastRequest(url, new HashMap<>(), RequestMethod.GET);
        try {
            lastResponse = get(url);
        } catch (Throwable e) {
            throw new IllegalStateException(String.format("API request failed: %s\n\nOriginal request: %s\n\nParams: %s\n",
                                                          e.getMessage(),
                                                          url));
        }
    }

    /**
     * Sends GET API request
     *
     * @param url API_URL endpoint (without domain name)
     */
    public void sendGetAPIRequest(String url) {
        updateLastRequest(url, new HashMap<>(), RequestMethod.GET);
        String request = prepareRequestUrl(url);
        System.out.println("test request " + url);
        sendGetRequest(request);
    }

    /**
     * POST HTTP request with JSON body
     *
     * @param url          fully qualified URL to request
     * @param jsonAsString json body parameter
     */
    private ExtractableResponse<Response> postJson(String url,
                                                   String jsonAsString) {
        RequestSpecification given = given();
        given.contentType(ContentType.JSON).body(jsonAsString);
        return given.post(url).then().extract();
    }

    /**
     * Sends POST request with JSON body
     *
     * @param url          fully qualified URL
     * @param jsonAsString string which contains json body of request
     */
    public void sendJsonInPostRequest(String url, String jsonAsString) {
        String requestUrl = prepareRequestUrl(url);
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("JSON body", jsonAsString);
        updateLastRequest(requestUrl, requestParams, RequestMethod.POST);
        try {
            lastResponse = postJson(requestUrl, jsonAsString);
        } catch (Throwable e) {
            String errMessage = "API POST request failed: %s\n\nOriginal request: %s\n\nParams: %s\n";
            throw new IllegalStateException(String.format(errMessage, e.getMessage(), requestUrl, requestParams));
        }
    }


    /**
     * PATCH HTTP request with JSON body
     *
     * @param url          fully qualified URL to request
     * @param jsonAsString json body parameter
     */
    private ExtractableResponse<Response> patchJson(String url,
                                                    String jsonAsString) {
        RequestSpecification given = given();
        given.contentType(ContentType.JSON).body(jsonAsString);
        return given.patch(url).then().extract();
    }

    /**
     * Sends PATCH request with JSON body
     *
     * @param url          fully qualified URL
     * @param jsonAsString string which contains json body of request
     */
    public void sendJsonInPatchRequest(String url, String jsonAsString) {
        String requestUrl = prepareRequestUrl(url);
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("JSON body", jsonAsString);
        updateLastRequest(requestUrl, requestParams, RequestMethod.PATCH);
        try {
            lastResponse = patchJson(requestUrl, jsonAsString);
        } catch (Throwable e) {
            String errMessage = "API PATCH request failed: %s\n\nOriginal request: %s\n\nParams: %s\n";
            throw new IllegalStateException(String.format(errMessage, e.getMessage(), requestUrl, requestParams));
        }
    }

    /**
     * DELETE HTTP request
     *
     * @param url fully qualified URL to request
     * @return response
     */
    protected static ExtractableResponse<Response> delete(String url) {
        return given().delete(url).then().extract();
    }

    /**
     * Sends DELETE request
     *
     * @param url fully qualified URL
     */
    private void sendDeleteRequest(String url) {
        updateLastRequest(url, new HashMap<>(), RequestMethod.DELETE);
        try {
            lastResponse = delete(url);
        } catch (Throwable e) {
            throw new IllegalStateException(String.format("API request failed: %s\n\nOriginal request: %s",
                                                          e.getMessage(),
                                                          url));
        }
    }

    /**
     * Sends DELETE API request
     *
     * @param url API_URL endpoint (without domain name)
     */
    public void sendDeleteAPIRequest(String url) {
        String request = prepareRequestUrl(url);
        sendDeleteRequest(request);
    }

    /**
     * Construcst absolute URL if relative was provided
     *
     * @param partUrl part url after domain name OR
     *                full url if does not belong to domain of AUT specified in {@link #addDomainToURL(String)}
     * @return fully qualified url to send API request to
     */
    protected String prepareRequestUrl(String partUrl) {
        String fullUrl;
        if (partUrl.startsWith("http") || partUrl.startsWith("https")) {
            fullUrl = partUrl;
        }
        else {
            fullUrl = addDomainToURL(partUrl);
        }
        return fullUrl;
    }

    /**
     * Adds protocol (e.g. HTTP://) and main domain of AUT, e.g. example.com
     * to send API request to in case sendPost... was used with partial URL, e.g. (/example/endpoint/)
     *
     * @param partUrl relative URL, e.g. /example/endpoint/
     * @return absolute URL, e.g. https://www.example.com/example/endpoint/
     */
    protected abstract String addDomainToURL(String partUrl);

    /**
     * Checks last response for the provided response code
     *
     * @param expectedStatus expected status code
     */
    public void verifyLastStatusCode(int expectedStatus) {

        if (lastResponse == null) {
            throw new IllegalStateException("API request was not sent or response is not saved");
        }
        int actualStatus = lastResponse.statusCode();
        if (actualStatus != expectedStatus) {
            String body = "Response body is not available\n";
            try {
                body = lastResponse.body().jsonPath().prettify();
            } catch (Throwable e) {
                body = body.concat(e.getMessage());
            }
            throw new IllegalStateException(String.format("Status code is not %s: %s\n\n%s",
                                                          expectedStatus, actualStatus, body));
        }
    }
}
