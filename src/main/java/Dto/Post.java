package Dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static aquality.selenium.browser.AqualityServices.getLogger;

public class Post {

    @JsonCreator
    public Post(@JsonProperty("userId") int userId,
                @JsonProperty("id") int id,
                @JsonProperty("title") String title,
                @JsonProperty("body") String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
    public Post(int userId,String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    @Override
    public String toString() {
        return userId + "\n"+ id + "\n"+ title + "\n"+ body + "\n" ;
    }
}

