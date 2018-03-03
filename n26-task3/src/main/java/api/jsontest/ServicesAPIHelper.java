package api.jsontest;

import api.APICore;


public class ServicesAPIHelper extends APICore {

    private static final String REQUEST_URL = "http://localhost:3030/";

    @Override
    protected String addDomainToURL(String partUrl) {
        return REQUEST_URL + partUrl;
    }
}
