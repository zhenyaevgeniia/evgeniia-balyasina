package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class PrettyJsonUtil {

    public static String getPrettyFormattedJson(String json){
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement jsonElement = parser.parse(json);
        return gson.toJson(jsonElement);
    }
}
