package ObjectsCreate;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.ResponseCache;

public class ObjectsTest {

    @Test
    public void createObjects(){
        Response response = RestAssured.given().log().all()
                .baseUri("https://api.restful-api.dev/objects")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "   \"name\": \"Apple MacBook Pro 16\",\n" +
                        "   \"data\": {\n" +
                        "      \"year\": 2019,\n" +
                        "      \"price\": 1849.99,\n" +
                        "      \"CPU model\": \"Intel Core i9\",\n" +
                        "      \"Hard disk size\": \"1 TB\"\n" +
                        "   }\n" +
                        "}")
                .post()
                        .then().log().all().extract().response();

        Assert.assertEquals(response.statusCode(),200);





    }
}
