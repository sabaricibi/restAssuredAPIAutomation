package qa.api.com.tests.users;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.api.com.restclient.RestClient;

import java.util.HashMap;
import java.util.Map;

public class GetUserTest {

    String baseURI ="https://api.invodx.com/beta";
    String basePath = "/users";
    String ClientKey = "6f727624-95af-47a3-a297-acee1691e812";
    String SecretKey = "6b1ebe411ecfd85f83783baba7636abb77f84be8ce8d6691";
    Map<String, String> paramKeys = new HashMap<String, String>();

    @BeforeMethod
    public void setUp(){

        paramKeys.put("ClientKey", ClientKey);
        paramKeys.put("SecretKey", SecretKey);
    }

    @Test
    @Description("get all the users in the org")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllUsersTest(){
        Response response = RestClient.doGet("JSON", baseURI, basePath, paramKeys, null, null, true);
        Assert.assertEquals(RestClient.getStatusCode(response), 200);
        RestClient.getPrettyResponsePrint(response);
        System.out.println(response.time());

    }

    @Test
    @Description("test case name: verify get user api with existing user...")
    @Severity(SeverityLevel.CRITICAL)
    public void getUserWithParam(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("first_name", "john");
        params.put("gender", "male");

        Response response = RestClient.doGet("JSON", baseURI, basePath,paramKeys , params, null,true);
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());

    }
}
