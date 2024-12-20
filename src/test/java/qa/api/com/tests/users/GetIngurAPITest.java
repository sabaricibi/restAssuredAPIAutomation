package qa.api.com.tests.users;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.api.com.restclient.RestClient;
import qa.api.com.util.Token;

import java.util.HashMap;
import java.util.Map;

public class GetIngurAPITest {

    Map<Object, Object> tokenMap;
    String accessToken;
    String accountUserName;
    String refreshToken;

    String baseURI ="https://api.imgur.com";
    String basePath = "/users";


    @BeforeMethod
    public void setUp(){
        tokenMap = Token.getAccessToken();
        accessToken = tokenMap.get("access_token").toString();
        accountUserName = tokenMap.get("account_username").toString();
        refreshToken = tokenMap.get("refresh_token").toString();
    }

    @Test
    public void getAccountBlockStatusTest(){
        Map<String, String> accessToken = Token.getAuthToken();
        Response response = RestClient.doGet(null, baseURI, "/account/v1/"+accountUserName+"/block",
                accessToken, null, null,true);
        System.out.println(response.prettyPrint());
    }

    @Test
    public void getAccountImagesTest(){
        Map<String, String> accessToken = Token.getAuthToken();
        Response response = RestClient.doGet(null, baseURI, "/3/account/me/images",
                accessToken, null, null, true);
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
    }

    @Test(enabled = false)
    public void uploadImageTest(){
        Map<String, String> clientIDMap = Token.getClientId();
        Map<String, String> formMap = new HashMap<String, String>();

        formMap.put("title","test title");
        formMap.put("description", "test description");
        Response response = RestClient.doPost("multipart", baseURI, "/3/image",
                clientIDMap, null, true, formMap);
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
    }
}
