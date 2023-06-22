package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceRequestBodyPOJO;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
     body’e sahip bir PUT request yolladigimizda donen response’in
     response body’sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */
    @Test
    public void put01(){
        specJsonPlace.pathParams("pp1","posts", "pp2", 70);

        JsonPlaceRequestBodyPOJO reqBody = new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);

        System.out.println("reqBody= " + reqBody);

        //Expected data hazirla

        JsonPlaceRequestBodyPOJO expBody = new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);

        //Response'u kaydet
        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(reqBody).put("/{pp1}/{pp2}");

        response.prettyPrint();

        //Assertion

       // JsonPath respJP = response.jsonPath();
       // HashMap<String, Object> respMap= response.as(HashMap.class);

        JsonPlaceRequestBodyPOJO respPOJO = response.as(JsonPlaceRequestBodyPOJO.class);
        assertEquals(expBody.getTitle(),respPOJO.getTitle());
        assertEquals(expBody.getBody(),respPOJO.getBody());
        assertEquals(expBody.getId(),respPOJO.getId());
        assertEquals(expBody.getUserId(),respPOJO.getUserId());



    }
}
