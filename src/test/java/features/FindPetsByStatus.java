package features;

import ApiObjects.Pet;
import ApiObjects.User;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FindPetsByStatus extends BaseApiTest{

    @Test
    @Description("find dogs solds with the same name")
    public void findSoldItems() {
        setupRestAssured();
        Pet[] pets = given().queryParam("status", "sold")
                .contentType("application/json")
                .when()
                .get("pet/findByStatus").as(Pet[].class);
        Map<String, String> tuple = new HashMap<>();

        Arrays.stream(pets).forEach(element -> {
            tuple.put(element.getId().toString(), element.getName());
        });
        findElementsWithSameName(tuple);
    }

    private Map<String, Integer> findElementsWithSameName(Map<String, String> pets) {
        Map<String, Integer> result = new HashMap<>();
        ArrayList<String> names =  new ArrayList<>(pets.values());
        for (int i = 0; i < names.size() ; i++) {
            String name = names.get(i);
            int resultCount = 1;
            for (int j = 0; j < names.size() ; j++) {
                String namej = names.get(j);
                if(name.equals(namej) && i!=j)
                {
                    resultCount++;
                }
                if (resultCount>1)
                {
                    result.put(name,resultCount);
                }
            }
        }
        result.forEach((key, value) -> System.out.println(key + ":" + value));
        return result;
    }
}
