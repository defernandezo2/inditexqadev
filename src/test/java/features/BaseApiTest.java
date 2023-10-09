package features;

import configurations.Configurations;
import io.restassured.RestAssured;

public abstract class BaseApiTest {

    public void setupRestAssured() {
        RestAssured.baseURI= Configurations.getInstance().getProperty("TEST_API_TARGET_URL");
    }
}
