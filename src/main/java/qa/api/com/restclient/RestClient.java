package qa.api.com.restclient;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qa.api.com.util.TestUtil;


import java.io.File;
import java.util.List;
import java.util.Map;


/***
 * All Http Methods
 * Generic methods for getting response
 * Fetch value from response
 *
 * @author SabariThangavelu
 */

public class RestClient {

    // doGet
    public static Response doGet(String contentType, String baseURI, String basePath, Map<String, String> token, Map<String, String> paramsMap, String pathParam, boolean log){
        if(setBaseURI(baseURI)) {
            RequestSpecification request = createRequest(contentType, token, paramsMap, log);
            if(!(pathParam == null))
                basePath = basePath+pathParam;
            return getResponse("GET", request, basePath);
        }
        return null;
    }

    public static Response doPost(String contentType, String baseURI, String basePath, Map<String, String> token, Map<String, String> paramsMap, boolean log, Object pojoObj){
        if(setBaseURI(baseURI)) {
            RequestSpecification request = createRequest(contentType, token, paramsMap, log);
            addRequestPayload(request,pojoObj);
            return getResponse("POST", request, basePath);
        }
        return null;
    }

    public static Response doPut(String contentType, String baseURI, String basePath, Map<String, String> token, Map<String, String> paramsMap, boolean log, Object pojoObj){
        if(setBaseURI(baseURI)) {
            RequestSpecification request = createRequest(contentType, token, paramsMap, log);
            addRequestPayload(request,pojoObj);
            return getResponse("PUT", request, basePath);
        }
        return null;
    }

    public static Response doDelete(String contentType, String baseURI, String basePath, Map<String, String> token, Map<String, String> paramsMap, boolean log) {
        if(setBaseURI(baseURI)) {
            RestClient.setBaseURI(baseURI);
            RequestSpecification request = createRequest(contentType, token, paramsMap, log);
            return RestClient.getResponse("DELETE", request, basePath);
        }
        return null;
    }

    private static void addRequestPayload(RequestSpecification request, Object obj) {

        if (obj instanceof Map) {
            request.formParams((Map<String, String>) obj); //not a pojo but a form data
        } else {
            String jsonPayload = TestUtil.getSerializedJSON(obj); // pojo object
            request.body(jsonPayload);
        }
    }
    private static boolean setBaseURI(String baseURI){
        if(baseURI == null || baseURI.isEmpty()) {
            System.out.println("Please pass the base URL NULL or BLANK");
            return false;
        }
        try{
           RestAssured.baseURI = baseURI;
           return true;
        }
        catch(Exception e){
            System.out.println("setBaseURI() -> Some issue with the Base URI set up with in Rest Client");
            return false;
        }

    }

    private static RequestSpecification createRequest(String contentType, Map<String, String> token,
                                     Map<String, String> paramsMap, boolean log){
        RequestSpecification request = null;
        EncoderConfig encoderconfig = new EncoderConfig();

        if(log){
           request =  RestAssured.given().log().all();
        }
        else{
            request = RestAssured.given();
        }


        if (token.size() > 0) {
            // request.header("Authorization", "Bearer " + token);
            request.headers(token);
        }

        if(!(paramsMap == null)){
            request.queryParams(paramsMap);
        }

        if(contentType != null) {

            if (contentType.equalsIgnoreCase("JSON")) {
                request.contentType(ContentType.JSON);
            } else if (contentType.equalsIgnoreCase("XML")) {
                request.contentType(ContentType.XML);
            } else if (contentType.equalsIgnoreCase("TEXT")) {
                request.contentType(ContentType.TEXT);
            } else if (contentType.equalsIgnoreCase("multipart")) {
                request.multiPart("image", new File("C:\\Automation\\backend\\src\\main\\java\\qa\\api\\com\\testdata\\image.jpeg"));
            }
        }

        request.given().config(RestAssured.config()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .appendDefaultContentCharsetToContentTypeIfUndefined(false)));

        return request;
    }


    private static Response getResponse(String httpMethod, RequestSpecification request, String basePath){
        return executeAPI(httpMethod,request,basePath);
    }

    private static Response executeAPI(String httpMethod, RequestSpecification request, String basePath){
        Response response = null;
        switch(httpMethod){
            case "GET":
                response = request.get(basePath);
                break;
            case "POST":
                response = request.post(basePath);
                break;
            case "PUT":
                response = request.put(basePath);
                break;
            case "DELETE":
                response = request.delete(basePath);
                break;
            default:
                System.out.println("Invalid HTTP Method has been passed ");
                break;
        }
        return response;
    }


    public static JsonPath getJsonPath(Response response) {
        return response.jsonPath();
    }

    public static int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public static String getHeaderValue(Response response, String headerName) {
        return response.getHeader(headerName);
    }

    public static int getResponseHeaderCount(Response response) {
        Headers headers = response.getHeaders();
        return headers.size();
    }

    public static List<Header> getResponseHeaders(Response response) {
        Headers headers = response.getHeaders();
        List<Header> headerList = headers.asList();
        return headerList;
    }

    public static void getPrettyResponsePrint(Response response) {
        System.out.println("========response String in pretty format======");
        response.prettyPrint();
    }


}
