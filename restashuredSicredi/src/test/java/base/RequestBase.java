package base;

import io.restassured.response.Response;
import request.PreRequest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestBase {
    protected Map<String, Object> headers = new HashMap<String, Object>();

    public RequestBase(){
        headers.put("Content-Type", "application/json");
    }

    public Response executeGetMethod(String path){
        Response results =
                given()
                    .headers(headers)
                    .log().all()
                .when()
                    .get(path)
                .then()
                    .log().all()
                    .extract()
                    .response();
        return results;
    }

    public Response executePostMethod(String path, Object jsonBody){
        Response results =
                given()
                        .headers(headers)
                        .log().all()
                        .body(jsonBody)
                        .when()
                        .post(path)
                        .then()
                        .log().all()
                        .extract()
                        .response();
        return results;
    }

    public Response executePathMethod(String path, String jsonBody){
        Response results =
                given()
                        .headers(headers)
                        .log().all()
                .when()
                        .patch(path)
                .then()
                        .log().all()
                        .extract()
                        .response();
        return results;
    }


    public Response executeGetMethodToken(String path){
        String token = PreRequest.acessToken();
        Response results =
                given()
                        .headers(headers)
                        .headers("Authorization","Bearer "+ token)
                        .log().all()
                        .when()
                        .get(path)
                        .then()
                        .log().all()
                        .extract()
                        .response();
        return results;
    }

}
