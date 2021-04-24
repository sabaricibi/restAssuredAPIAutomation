package qa.api.engagedly.tests.performance;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.api.engagedly.restclient.RestClient;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetTemplate {

    String baseURI ="https://durjaya.sandbox-engagedly.com";
    String basePath = "/performance/review_templates/";
    String ENGAGEDLYAUTH = "{\"access_key\": \"808e83c2-9ddd-42e1-b86c-4d35dd4200e2\",  \"organisation_access_key\": \"ea272349-3e5c-4077-ace3-d93d0610bfdf\"}";
    String csrfToken = "a272349-3e5c-4077-ace3-d93d0610bfdf";
    String Cookie = "advaya=QmE13raXvm83GHnfOMj4J8aZRjAjMWYXnG6r5FzGEWc9l%252FkTt4vT9A%253D%253D%250A; " +
            "subdomain=testdomain; advaya_session=1615788875; " +
            "ph_mZ0RGOkRzHgmriYMN-ds00ZHTcWP5uCaQVJekNxueK0_posthog=%7B%22distinct_id%22%3A%221783b22adf7669-09ab7d285238d3-6518207d-1ea000-1783b22adf88ce%22%2C%22%24" +
            "device_id%22%3A%221783b22adf7669-09ab7d285238d3-6518207d-1ea000-1783b22adf88ce%22%2C%22%24" +
            "initial_referrer%22%3A%22%24direct%22%2C%22%24" +
            "initialcsrfToken_referring_domain%22%3A%22%24direct%22%2C%22%24" +
            "referrer%22%3A%22https%3A%2F%2F" +
            "testdomain.sandbox-engagedly.com%2Fperformance_reviews%22%2C%22%24referring_domain%22%3A%22" +
            "testdomain.sandbox-engagedly.com%22%2C%22%24" +
            "session_recording_enabled%22%3Atrue%2C%22%24" +
            "active_feature_flags%22%3A%5B%5D%2C%22%24" +
            "sesid%22%3A%5B1616350738533%2C%2217855f0000334e-0e28ab1551c417-6718207c-1ea000-17855f00004b81%22%5D%7D; " +
            "present_url=%2Factors%23organisations%2Fv1%2F5%2F" +
            "languages%2Fea272349-3e5c-4077-ace3-d93d0610bfdf%2F" +
            "translations%2Fen%2FEnglish";

    Map<String, String> paramKeys = new HashMap<String, String>();


    @BeforeMethod
    public void setUp(){

        paramKeys.put("ENGAGEDLYAUTH", ENGAGEDLYAUTH);
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
