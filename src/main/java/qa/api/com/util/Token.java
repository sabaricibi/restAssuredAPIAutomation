package qa.api.com.util;

import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Token {
    public static Map<Object, Object> appTokenMap;
    public static Map<String, String> tokenMap = new HashMap<String, String>();
    public static String clientId = "d8874bea7b98483";

    public static  Map<Object, Object> getAccessToken(){

        Map<String,String> formParams = new HashMap<String, String>();
        formParams.put("refresh_token", "44a15e57e1f49b5901292fd7c9983622ef3cdf5c");
        formParams.put("client_id", "d8874bea7b98483");
        formParams.put("client_secret", "a19c820d2e257b8f2261cc72b3436877778e3e41");
        formParams.put("grant_type", "refresh_token");

        JsonPath tokenJson = given().formParams(formParams)
                .when().post("https://api.imgur.com/oauth2/token/")
                .then()
                .extract()
                .jsonPath();
        System.out.println(tokenJson.getMap(""));

        appTokenMap = tokenJson.getMap("");

        return appTokenMap;
    }

    public static Map<String, String> getAuthToken(){
        String authToken = appTokenMap.get("access_token").toString();
        System.out.println("Auth Token ====> "+ authToken);
        tokenMap.put("Authorization", "Bearer "+authToken);
        return tokenMap;
    }

    public static Map<String, String> getClientId(){
        System.out.println("Client id is ====> "+ clientId);
        tokenMap.put("Authorization", "Client-ID "+clientId);
        return tokenMap;
    }
}
