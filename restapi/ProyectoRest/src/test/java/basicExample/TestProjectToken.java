package basicExample;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class TestProjectToken {


@Test
public void createProject(){

// get proyecto
    Response response = given().
            auth().
            preemptive().
            basic("javierapi@api.com","api123").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            when().
            get("http://todo.ly/api/authentication/token.json");

    response.then().
            statusCode(200);

    String token= response.then().extract().path("TokenString");


    // crear proyecto
    response = given().
            header("Token",token).
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body("{\n" +
                    "   \"Content\" : \"My New Project\",\n" +
                    "   \"Icon\":4\n" +
                    "}").
            when().
            post("http://todo.ly/api/projects.json");

    response.then().
            statusCode(200).
            body("Content", equalTo("My New Project")).
            body("Icon", equalTo(4)).
            body("Deleted", equalTo(false));


    String idProject = response.then().extract().path("Id")+"";

    // actualizar un proyecto

    response = given().
            header("Token",token).
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body("{\n" +
                    "   \"Content\" : \"UPDATED\",\n" +
                    "   \"Icon\":4\n" +
                    "}").
            when().
            put("http://todo.ly/api/projects/"+idProject+".json");
    response.then().
            statusCode(200).
            body("Content", equalTo("UPDATED")).
            body("Icon", equalTo(4)).
            body("Deleted", equalTo(false));

    //borrar un proyecto
    response = given().
            header("Token",token).
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            when().
            delete("http://todo.ly/api/projects/"+idProject+".json");
    response.then().
            statusCode(200).
            body("Content", equalTo("UPDATED")).
            body("Icon", equalTo(4)).
            body("Deleted", equalTo(true));


}



}
