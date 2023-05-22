package Utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class DataReader {
    static ISettingsFile environment = new JsonSettingsFile("config.json");
    static ISettingsFile environment1 = new JsonSettingsFile("test_data.json");

    public static String getBaseUrl() {
        return environment.getValue("/base_url").toString();
    }

    public static String getPostEndpoint() {
        return environment.getValue("/post_endpoint").toString();
    }

    public static String getUserEndpoint() {
        return environment.getValue("/user_endpoint").toString();
    }

    public static String getUserJsonFilePath(){
        return environment.getValue("/user5").toString();
    }
    public static int readJsonInt(String value){
        return (int) environment1.getValue("/"+value);
    }
}
