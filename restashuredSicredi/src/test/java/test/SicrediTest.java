package test;


import base.RequestBase;
import org.junit.Assert;
import request.RequestBody;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

public class SicrediTest {

    Setenviroment env = new Setenviroment();
    RequestBase base = new RequestBase();
    RequestBody body = new RequestBody();


    @DisplayName("Valida POST da api de Auth")
    @ParameterizedTest(name = "Teste auth do usuario: {0} deve retornar {2}")
    @CsvSource({
            "emilys, emilyspass, 200",
            "michaelw, michaelwpass, 200",
            "teste, teste, 400, ",
            ", , 400",
            "michaelw, , 400",
            ", michaelwpass, 400"
    })
    public void validaMetodoPostAuth(String username, String password, int statusCode){
        String jsonBody = body.jsonMetodoPostAuth(username,password);
        Response teste = base.executePostMethod(env.setEnviromentPost("endpoint.post.auth"),jsonBody);
        Assertions.assertEquals(teste.statusCode(), statusCode);
        Assertions.assertEquals(statusCode, teste.statusCode(), "Status code diferente do esperado");
        String accessToken = teste.jsonPath().getString("accessToken");
        if (statusCode == 200) {
            Assertions.assertNotNull(accessToken, "O accessToken não deveria ser null");
        } else {
            Assert.assertEquals(teste.path("message"),"Invalid credentials");
        }

    }

    @Test
    @DisplayName("Valida Metodo Get Users todos os usuarios")
    public void validaMetodoGetUser(){
        Response teste = base.executeGetMethod(env.setEnviromentGet("endpoint.get.users"));
        Assertions.assertEquals(teste.statusCode(), 200);
       // Assert.assertNotNull(teste.path("/users"));
    }

    @DisplayName("Valida GET da api de Users por ID")
    @ParameterizedTest(name = "TEste de busca por usuario codigo: {0} deve retornar {1}")
    @CsvSource({
            "1, 200",
            "5, 200",
            "500000, 404"
    })
    public void validaMetodoGetUserId(int idUsr, int statusCode){
        Response teste = base.executeGetMethod(env.setEnviromentGetId("endpoint.get.usersId", idUsr));
        Assertions.assertEquals(teste.statusCode(), statusCode);
        Assertions.assertEquals(statusCode, teste.statusCode(), "Status code diferente do esperado");
        String accessToken = teste.jsonPath().getString("id");
        if (statusCode == 200) {
            Assertions.assertNotNull(accessToken, "O id não deveria ser null");
        } else {
            Assertions.assertTrue(accessToken == null || accessToken.isEmpty(), "O id deveria ser null ou vazio");
        }
    }

    @Test
    @DisplayName("Valida Metodo Get Test")
    public void validaMetodoGetTest(){
        Response teste = base.executeGetMethod(env.setEnviromentGet("endpoint.get.test"));
        Assertions.assertEquals(teste.statusCode(), 200);
        Assert.assertEquals(teste.path("status"),"ok");
    }

    @Test
    @DisplayName("Valida Metodo Get Auth Products")
    public void validaMetodoGetAuthProducts(){
        Response teste = base.executeGetMethodToken(env.setEnviromentGet("endpoint.get.auth.pro.ducts"));
        Assertions.assertEquals(teste.statusCode(), 200);
        Assertions.assertNotNull(teste.path("products"));
    }

    @Test
    @DisplayName("Valida Metodo Post Product Add")
    public void validaMetodoPostProductAdd(){
        Map<String, Object> jsonBody = RequestBody.jsonMetodoPostProductAdd("Perfume Oil", "Mega Discount, Impression of A...", 11, 10, 4.26, 50, "Impression of Acqua Di Gio", "fragrances");
        Response teste = base.executePostMethod(env.setEnviromentPost("endpoint.post.product.add"),jsonBody);
        Assertions.assertEquals(teste.statusCode(), 201);
        Assertions.assertNotNull(teste.path("id"));
        Assert.assertEquals(teste.path("title"),"Perfume Oil");
        int lastId = 195; // Exemplo: último ID antes do teste
        int id = teste.jsonPath().getInt("id");
        Assertions.assertTrue(id > lastId, "O ID deve ser maior que o último ID");
    }


    @Test
    @DisplayName("Valida Metodo Get Products")
    public void validaMetodoGetProducts() {
        Response teste = base.executeGetMethod(env.setEnviromentGet("endpoint.get.pducts"));
        Assertions.assertEquals(teste.statusCode(), 200);
        // Assert.assertNotNull(teste.path("/users"));
    }

    @Test
    @DisplayName("Valida Metodo Get Products Por ID")
    public void validaMetodoGetProductsId() {
        Response teste = base.executeGetMethod(env.setEnviromentGetId("endpoint.get.pductsId", 1));
        Assertions.assertEquals(teste.statusCode(), 200);
        // Assert.assertNotNull(teste.path("/users"));
    }

}

/**
 * Carlos Eduardo de Moura Saores
 */