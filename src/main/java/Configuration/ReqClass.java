package Configuration;

import Dto.Post;
import Utils.ContentType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import static Utils.DataReader.*;
import static Utils.StringUtil.getString;
import static aquality.selenium.browser.AqualityServices.getLogger;


public class ReqClass {
    public static HttpResponse<String> getPosts() {
        getLogger().info("Sending Get request for Posts");
        try {
            HttpResponse<String> response = Unirest.get(getBaseUrl() + getPostEndpoint()).asString();
            return response;
        } catch (UnirestException e) {
            getLogger().error("Error getting posts: " + e.getMessage());
            throw new RuntimeException("Error sending request to get posts " + e);
        }
    }
    public static HttpResponse<String> getPostById(int id)throws UnirestException {
        getLogger().info("Sending Get request for Post with ID - " + id);
        try {
            HttpResponse<String> response = Unirest.get(getBaseUrl()+getPostEndpoint()+"/"+ id)
                    .asString();
            return response;
        } catch (UnirestException e) {
            getLogger().error("Error getting posts by id : " + e.getMessage());
            throw e;
        }
    }

    public static HttpResponse<String> post() throws UnirestException {
        getLogger().info("Sending request of Post");
        try {
            Post post = new Post(readJsonInt("setUserId"), getString(), getString());

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(post);
            HttpResponse<String> response = Unirest.post(getBaseUrl()+getPostEndpoint())
                    .header("Content-Type", ContentType.JSON.getValue())
                    .body(json)
                    .asString();
            return response;
        } catch (JsonProcessingException e) {
            getLogger().error("Error while processing JSON data: " + e.getMessage());
            throw new UnirestException("Error while proccesing json data");
        } catch (UnirestException e) {
            getLogger().error("Error while sending request to post: " + e.getMessage());
            throw e;
        }
    }
    public static HttpResponse<String> getUsers()throws UnirestException {
        getLogger().info("Sending Get request for Users");
        try {
            HttpResponse<String> response = Unirest.get(getBaseUrl()+getUserEndpoint())
                    .asString();
            return response;
        } catch (UnirestException e) {
            getLogger().error("Error getting users : " + e.getMessage());
            throw e;
        }
    }

    public static HttpResponse<String> getUserById(int id)throws UnirestException {
        getLogger().info("Sending Get request for User with ID - " + id);
        try {
            HttpResponse<String> response = Unirest.get(getBaseUrl()+getUserEndpoint()+"/"+ id)
                    .asString();
            return response;
        } catch (UnirestException e) {
            getLogger().error("Error getting users by id  : " + e.getMessage());
            throw e;
        }
    }
}

