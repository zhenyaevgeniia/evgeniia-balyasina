package stepdefs_api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractDef {

    private GsonBuilder gsonBuilder;

    public AbstractDef() {
        initGsonBuilder();
    }

    private void initGsonBuilder() {
        gsonBuilder = new GsonBuilder();
    }

    protected Gson getGson() {
        return gsonBuilder.create();
    }
}
