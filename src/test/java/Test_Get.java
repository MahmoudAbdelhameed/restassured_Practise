import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public  class Test_Get {
//    @Test
//    void Get_test() {
//        Response response = get("https://reqres.in/api/users?page=2");
////        Response response = get("https://case-api.trella.app/marketplace?lng=30&lat=30");
////        Response response = RestAssured.get("https://case-api.trella.app/marketplace?lng=30&lat=30");
//        System.out.println(response.getBody().asString());
//    }
//
//
//    @Test
//    void Get_test2()
//    {
//        JSONObject request = new JSONObject();
//        given()
//                .header("Authorization","test@mail100.com")
////                .contentType(ContentType.JSON)
////                .param("latitude",)
//                .accept(ContentType.JSON)
//                .body(request.toJSONString())
////                .pathParam("longitude").pat
//                .get("https://case-api.trella.app/marketplace?lng=30&lat=30").then().statusCode(200);
////        System.out.println(request.toJSONString());
////        Response response = RestAssured.get("https://case-api.trella.app/marketplace?lng=30&lat=30");
//    }
    @Test
    void Get_test3() {
        given()
                .header("Authorization","test@mail100.com")
                .contentType(ContentType.JSON)
                .when().get("https://case-api.trella.app/marketplace")
                .then().log().body()
                .statusCode(200)
                .assertThat()
                .body("size()", is(7));
//                .body(everyItem(co("KEY")));

    }

    @Test
    void Get_test4() {
        given()
                .header("Authorization", "test@mail100.com")
                .queryParam("lat", "30")
                .queryParam("lng", "30")
                .when().get("https://case-api.trella.app/marketplace")
                .then().statusCode(200)
                .assertThat().body("size()", is(3))
                //////////
//                .assertThat().body(everyItem(hasKey("price")));    }
//                .assertThat().body(contains());    }
                .body("$", hasKey("price"));
    }
    }
