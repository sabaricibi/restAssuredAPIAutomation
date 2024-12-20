package qa.api.com.tests.performance;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.api.com.restclient.RestClient;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetTemplate {

    String baseURI ="";
    String basePath = "/templates/";
    String Auth = "{\"access_key\": \"xxx\",  \"organisation_access_key\": \"xxx\"}";
    String csrfToken = "";
    String Cookie = "";

    Map<String, String> paramKeys = new HashMap<String, String>();


    @BeforeMethod
    public void setUp(){

        paramKeys.put("", );
        paramKeys.put("csrfToken", csrfToken);
        paramKeys.put("Cookie", Cookie);
    }

    @Test
    @Description("Get the Template by ID")
    @Severity(SeverityLevel.CRITICAL)
    public void getTemplateByID(){
        String template_ID = "201";
        Response response = RestClient.doGet("JSON", baseURI, basePath, paramKeys , null, template_ID, true);
        Assert.assertEquals(RestClient.getStatusCode(response), 200);
        Assert.assertEquals(RestClient.getHeaderValue(response,"Content-Type"), "application/json");

    }

    @Test
    @Description("Get the Template by InvalidID")
    @Severity(SeverityLevel.CRITICAL)
    public void getTemplateByInvalidID(){
        String template_ID = "999";
        Response response = RestClient.doGet("JSON", baseURI, basePath, paramKeys , null, template_ID, true);
        Assert.assertEquals(RestClient.getStatusCode(response), 404);
        Assert.assertEquals(RestClient.getHeaderValue(response,"Content-Type"), "application/json");
    }


    @Test
    @Description("Get the all the templates")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllOrgTemplateList(){

        /*
        Default Params:
        search_word: ''
        type: ['my_library', 'distributed', 'organisation_library', 'discussion']
        page: 1
        size: 20 */

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("search_word", "");
        paramsMap.put("type[]", "['my_library', 'distributed', 'organisation_library', 'discussion']" );
        paramsMap.put("page", "1");
        paramsMap.put("size", "20");

        Response response = RestClient.doGet("JSON", baseURI, basePath, paramKeys , paramsMap, null, true);
        Assert.assertEquals(RestClient.getStatusCode(response), 200);
        Assert.assertEquals(RestClient.getHeaderValue(response,"Content-Type"), "application/json");

    }



    @Test
    @Description("Get the all favorite templates")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllFavTemplateList(){

        /*
        Default Params:
        search_word: ''
        type: ['my_library', 'distributed', 'organisation_library', 'discussion']
        page: 1
        size: 20
        favourite: true
        */

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("search_word", "");
        paramsMap.put("type[]", "organisation_library" );
        paramsMap.put("page", "1");
        paramsMap.put("size", "20");
        paramsMap.put("favourite","true");

        Response response = RestClient.doGet("JSON", baseURI, basePath, paramKeys , paramsMap, null, true);
        Assert.assertEquals(RestClient.getStatusCode(response), 200);
        Assert.assertEquals(RestClient.getHeaderValue(response,"Content-Type"), "application/json");
        System.out.println(response.prettyPrint());
    }

    @Test
    @Description("Get the all favorite templates")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllOwnerTemplateList(){

        /*
        Default Params:
        search_word: ''
        type: ['my_library', 'distributed', 'organisation_library', 'discussion']
        page: 1
        size: 20
        favourite: true
        */

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("search_word", "");
        paramsMap.put("type[]", "my_library" );
        paramsMap.put("page", "1");
        paramsMap.put("size", "20");


        Response response = RestClient.doGet("JSON", baseURI, basePath, paramKeys , paramsMap, null, true);
        Assert.assertEquals(RestClient.getStatusCode(response), 200);
        Assert.assertEquals(RestClient.getHeaderValue(response,"Content-Type"), "application/json");
        System.out.println(response.prettyPrint());
    }


    @Test
    @Description("Get the all favorite templates")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllActiveTemplateList(){

        /*
        Default Params:
        search_word: ''
        type: ['my_library', 'distributed', 'organisation_library', 'discussion']
        page: 1
        size: 20
        favourite: true
        */

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("search_word", "");
        paramsMap.put("type[]", "['my_library', 'distributed', 'organisation_library', 'discussion']" );
        paramsMap.put("page", "1");
        paramsMap.put("size", "20");
        paramsMap.put("status[]","active");


        Response response = RestClient.doGet("JSON", baseURI, basePath, paramKeys , paramsMap, null, true);
        Assert.assertEquals(RestClient.getStatusCode(response), 200);
        Assert.assertEquals(RestClient.getHeaderValue(response,"Content-Type"), "application/json");
        System.out.println(response.prettyPrint());
    }

    @Test
    @Description("Get the all favorite templates")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllArchivedTemplateList(){

        /*
        Default Params:
        search_word: ''
        type: ['my_library', 'distributed', 'organisation_library', 'discussion']
        page: 1
        size: 20
        favourite: true
        */

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("search_word", "");
        paramsMap.put("type[]", "['my_library', 'distributed', 'organisation_library', 'discussion']" );
        paramsMap.put("page", "1");
        paramsMap.put("size", "20");
        paramsMap.put("status[]","archived");


        Response response = RestClient.doGet("JSON", baseURI, basePath, paramKeys , paramsMap, null, true);
        Assert.assertEquals(RestClient.getStatusCode(response), 200);
        Assert.assertEquals(RestClient.getHeaderValue(response,"Content-Type"), "application/json");
        System.out.println(response.prettyPrint());
    }




}
