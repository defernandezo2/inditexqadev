package features;

import ApiObjects.Pet;
import ApiObjects.User;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ApiTest extends BaseApiTest {

    Faker faker = new Faker();


    @Test
    @Description("create user")
    public void createUser() {
        setupRestAssured();
        CreateRandomUser();
    }

    @Test
    @Description("get user ")
    public void getUser() {
        setupRestAssured();
        User user = CreateRandomUser();
        User resultUser = given().pathParam("username", user.username)
                .contentType("application/json")
                .when().get("/user/{username}").as(User.class);

        Assertions.assertEquals(user.firstName, resultUser.firstName);
    }

    @Test
    @Description("get user with rest assured test")
    public void getUserAssertionRa() {
        setupRestAssured();
        User user = CreateRandomUser();
        given().pathParam("username", user.username)
                .contentType("application/json")
                .when()
                .get("/user/{username}")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("username", equalTo(user.username))
                .body("firstName", equalTo(user.firstName));
    }


    private User CreateRandomUser() {
        User user = new User().withUsername("user" + faker.number().digits(4)).withFirstName(faker.name().firstName()).withLastName(faker.name().lastName());
        given().
                contentType("application/json").
                body(user).when().post("/user");
        return user;
    }
}
