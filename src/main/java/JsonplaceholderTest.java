import Dto.Post;
import Dto.User;
import Utils.StatusCode;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Configuration.ReqClass.*;
import static Utils.DataReader.*;
import static Utils.ParseUtil.parsePost;
import static Utils.ParseUtil.parseUser;
import static Utils.ParseUtil.parseUserFromJsonfile;
import static Utils.ResponseUtils.*;

public class JsonplaceholderTest{

    @Test
    public void testGetPosts() {
        Assert.assertEquals(getPosts().getStatus(), StatusCode.OK.getCode(),"Expected status code to be 200");
        Assert.assertTrue(checkType(getPosts()),"Excpected type to be Json!");
        Assert.assertTrue(checkIfPostsAreSorted(),"posts are not sorted!");
    }
    @Test
    public void testGetPostById() {
        Post post = parsePost(getPostById(readJsonInt("postById")));
        Assert.assertEquals(getPostById(readJsonInt("postById")).getStatus(), StatusCode.OK.getCode(), "Expected status code to be 200");
        Assert.assertTrue(checkPostInfoIscorrect(post),"Post Information is not correct!");
    }

    @Test
    public void testGetPostByNonexistentId() {
        Post post1 = parsePost(getPostById(readJsonInt("nonexistPostById")));
        Assert.assertEquals(getPostById(readJsonInt("nonexistPostById")).getStatus(),StatusCode.NOT_FOUND.getCode(), "Expected status code to be 404");
        Assert.assertNull(post1.getBody(),"Excpected to be without body");
    }
    @Test
    public void testPost() {
        Post sentPost = parsePost(post());
        Assert.assertEquals(post().getStatus(),StatusCode.CREATED.getCode(), "Expected status code to be 201");
        Assert.assertEquals(sentPost.getId(),readJsonInt("createdId"),"id doesn't matches expected");
        Assert.assertEquals(sentPost.getUserId(),readJsonInt("createdUserId"),"userid doesn't matches expected");
        Assert.assertFalse(sentPost.getBody().isEmpty(),"body is empty");
        Assert.assertFalse(sentPost.getTitle().isEmpty(),"title is empty");
    }
    @Test
    public void testGetUsers() {
        User user = parseUser(getUserById(readJsonInt("userById")));
        Assert.assertEquals(getUsers().getStatus(),StatusCode.OK.getCode(),"Expected status code to be 200");
        Assert.assertTrue(checkType(getPosts()),"Excpected type to be Json!");
        Assert.assertTrue(user.equals(parseUserFromJsonfile()),"User data doesn't equals to expected!");
    }
    @Test
    public void testGetUsersById() {
        User user1 = parseUser(getUserById(readJsonInt("userById")));
        Assert.assertEquals(getUserById(readJsonInt("userById")).getStatus(),StatusCode.OK.getCode(),"Expected status code to be 200");
        Assert.assertEquals(user1,parseUserFromJsonfile(),"user1 data doesn't matches with expected data");
    }
}
