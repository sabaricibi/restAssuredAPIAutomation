package qa.api.com.tests.users;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.api.com.pojo.BusinessUnit;
import qa.api.com.pojo.JobTitle;
import qa.api.com.pojo.Location;
import qa.api.com.restclient.RestClient;
import qa.api.com.pojo.User;
import qa.api.com.util.ExcelUtil;

import java.util.HashMap;
import java.util.Map;

public class CreateUserTest {


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

    @DataProvider
    public Object[][] getUserData(){
        Object[][] userData = ExcelUtil.getTestData("users");
        return userData;
    }

    @Test(dataProvider = "getUserData")
    public void createUserTest(String first_name, String last_name, String email, String id, String name, String middleName,
                               String employeeID, String status, String displayPicture, JobTitle jobTitle, BusinessUnit businessUnit,
                               String employeeType, String birthDay, Location location, String phoneNumber){

        User user = new User(first_name,last_name,email,id,name, middleName,employeeID,status, displayPicture, jobTitle,
                businessUnit,employeeType,birthDay,location,phoneNumber);

        Response response = RestClient.doPost("JSON",  baseURI, basePath,
                paramKeys, null, true, user);
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
        System.out.println("=======================");
    }

}
