package request;


import base.RequestBase;
import io.restassured.response.Response;
import org.junit.Assert;
import test.Setenviroment;

public class PreRequest {


    static Setenviroment env = new Setenviroment();
    static RequestBase base = new RequestBase();
    static RequestBody body = new RequestBody();


        public static String acessToken() {
            String jsonBody = body.jsonMetodoPostAuth("emilys","emilyspass");
            Response teste = base.executePostMethod(env.setEnviromentPost("endpoint.post.auth"),jsonBody);
            Assert.assertEquals(teste.statusCode(), 200);
            return teste.jsonPath().getString("accessToken");
        }
    }

