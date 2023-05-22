package Utils;

import Dto.Post;
import Dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static Utils.DataReader.getUserJsonFilePath;
import static aquality.selenium.browser.AqualityServices.getLogger;

public class ParseUtil {
    public static List<Post> parsePosts(HttpResponse<String> response) {
        try {
            getLogger().info("Parsing Posts");
            ObjectMapper mapper = new ObjectMapper();
            Post[] posts =mapper.readValue(response.getBody(), Post[].class);
            List<Post> postList = Arrays.asList(posts);
            return postList;
        } catch (IOException e) {
            getLogger().info(e.getMessage());
            throw new RuntimeException("Error while parsing posts ", e);
        }
    }
    public static Post parsePost(HttpResponse<String> response) {
        try {
            getLogger().info("Parsing Post");
            ObjectMapper mapper = new ObjectMapper();
            Post post = mapper.readValue(response.getBody(), Post.class);
            return post;
        } catch (IOException e) {
            getLogger().info(e.getMessage());
            throw new RuntimeException("Error while parsing post ", e);
        }
    }
    public static User parseUser(HttpResponse<String> response) {
        try {
            getLogger().info("Parsing User");
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(response.getBody(), User.class);
            return user;
        } catch (IOException e) {
            getLogger().info(e.getMessage());
            throw new RuntimeException("Error while parsing user ", e);
        }
    }
    public static User parseUserFromJsonfile(){
        try {
            getLogger().info("Parsing User from json file");
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(new File(getUserJsonFilePath()), User.class);
            return user;
        } catch (IOException e) {
            getLogger().info(e.getMessage());
            throw new RuntimeException("Error while parsing user from json file ", e);
        }
    }
}
