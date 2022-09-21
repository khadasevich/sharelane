package apitests.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class RestAssuredTest {

    @Test
    public void checkUserNotFoundTest() {
        RestAssured
                .given()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404);
    }

    @Test
    public void checkBodyValuesTest() {
        RestAssured
                .given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .body("page", instanceOf(Integer.class))
                .body("per_page", equalTo(6));
    }

    @Test
    public void checkStaticResponseTest() {
        JsonPath expectedJson = new JsonPath(new File("src/test/resources/user.json"));
        RestAssured
                .given()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .statusCode(200)
                .body("", equalTo(expectedJson.getMap("")));
    }

    @Test
    public void getWithQueryParamTest() {
        RestAssured
                .given()
                .queryParam("page", "2")
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .body("page", equalTo(2));
    }

    @Test
    public void updateUserTest() {
        UpdateUserModel updateBody = UpdateUserModel
                .builder()
                .name("Alex")
                .job("AQA")
                .build();


        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .and()
                .body(updateBody)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void createUserTest() {
        UpdateUserModel updateBody = UpdateUserModel
                .builder()
                .name("Alex")
                .job("AQA")
                .build();


        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .and()
                .body(updateBody)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void createMileStoneTest() {
        String body = "{\"title\":\"NewStone2\",\"description\":\"Some\",\"status\":\"active\",\"due_date\":1663416589}";

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Token", "2f6df94a25af2dd51f5ffe1cd97540684accd9ba")
                .and()
                .body(body)
                .when()
                .post("https://api.qase.io/v1/milestone/SHARELANE")
                .then()
                .statusCode(200);
    }

    @Test
    public void rtrtrt() {
        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highloadsdd");
        System.out.println(collection.stream().sorted().collect(Collectors.toList()));
    }
}
