package Utils;

import Dto.Post;
import kong.unirest.HttpResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Configuration.ReqClass.getPostById;
import static Configuration.ReqClass.getPosts;
import static Utils.DataReader.readJsonInt;
import static Utils.ParseUtil.parsePost;
import static Utils.ParseUtil.parsePosts;
import static aquality.selenium.browser.AqualityServices.getLogger;

public class ResponseUtils {
    public static boolean checkType(HttpResponse<String> response){
        getLogger().info("check if info is valid type");
        String contentType = response.getHeaders().get("Content-Type").get(0);
        if (contentType.toLowerCase().contains(ContentType.JSON_TYPE.getValue())) {
            return true;
        }else {
            getLogger().info("Response body is not a JSON type");
            return false;
        }
    }
    public static ArrayList<Integer> getPostIdNumbs() {
        ArrayList<Integer> postIds = new ArrayList<>();
        for (Post book : parsePosts(getPosts())){
            postIds.add(book.getId());
        }
        return postIds;

    }
    public static boolean checkIfPostsAreSorted() {
        ArrayList<Integer> sortedPostIdNumbers = new ArrayList<>(getPostIdNumbs());
        Collections.sort(sortedPostIdNumbers);
        return sortedPostIdNumbers.equals(getPostIdNumbs());
    }
    public static boolean checkPostInfoIscorrect(Post obj){

        getLogger().info("check if post title and body is not empty");;
        if (!(obj.getTitle().isEmpty())&&!(obj.getBody().isEmpty()) && obj.getUserId() == readJsonInt("postUserId") && obj.getId() == readJsonInt("postById")) {
            return true;
        }else {
            getLogger().info("post title and body are empty");
            return false;
        }
    }
}
