package api.helpers;

import api.APICore;


public class CommonAPIHelper extends APICore {

    private static final String REQUEST_URL = "http://localhost:3030/";

    @Override
    protected String addDomainToURL(String partUrl) {
        return REQUEST_URL + partUrl;
    }
}
