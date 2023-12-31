package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import testData.TestDataJsonPlace;

import java.util.HashMap;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {
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
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    @Test
    public void put01(){

        //url ve Req body
        specJsonPlace.pathParams("pp1","posts", "pp2", 70);

        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();
        HashMap<String, Object> reqBody = testDataJsonPlace.requestBodyOlusturMap();


    }
}
