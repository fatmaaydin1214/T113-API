package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_Get_BodyTekrarlaedanKurtulma {
    /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                    "firstname“in,"Susan",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 609,
                    ve "depositpaid“in,false,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */
    @Test
    public void get01(){

        //url hazirla

        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);
        response.prettyPrint();
/*
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("firstname", Matchers.equalTo("Susan"),
                        "lastname",Matchers.equalTo("Wilson"),
                        "totalprice",Matchers.equalTo(609),
                        "depositpaid",Matchers.equalTo(false),
                        "additionalneeds",Matchers.equalTo("Breakfast"));

 */

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Susan"),
                        "lastname",equalTo("Wilson"),
                        "totalprice",equalTo(609),
                        "depositpaid",equalTo(false),
                        "additionalneeds",equalTo("Breakfast"));


    }
}
