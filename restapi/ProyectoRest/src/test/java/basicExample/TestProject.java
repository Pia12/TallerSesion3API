package basicExample;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class TestProject {


@Test
public void createProject(){

    // Crear Proyecto
     Response response = given().
            auth().preemptive().basic("javierapi@api.com","api123").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body("{\n" +
                    "   \"Content\" : \"MyRestAssure4\",\n" +
                    "   \"Icon\":4\n" +
                    "}\n").
            when().
            post("http://todo.ly/api/projects.json");

     response.then().
            statusCode(200).
            body("Content",equalTo("MyRestAssure4")).
            body("Icon",equalTo(4)).
            body("Deleted",equalTo(false));
    //  log().all();

    String idProject = response.then().extract().path("id");


    // ACTUALIZAR PROJECT
     response = given().
            auth().preemptive().basic("javierapi@api.com","api123").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body("{\n" +
                    "   \"Content\" : \"UPDATE\",\n" +
                    "   \"Icon\":4\n" +
                    "}\n").
            when().
             put("http://todo.ly/api/projects/"+idProject+".json");

    response.then().
            statusCode(200).
            body("Content",equalTo("UPDATE")).
            body("Icon",equalTo(4)).
            body("Deleted",equalTo(false));
    //  log().all();


    //BORRAR PROJECT
//borrar un proyecto
    response = given().
            auth().preemptive().basic("javierapi@api.com","api123").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            when().
            delete("http://todo.ly/api/projects/"+idProject+".json");
    response.then().
            statusCode(200).
            body("Deleted", equalTo(true));

    // get proyecto
    response = given().
            auth().preemptive().basic("javierapi@api.com","api123").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            when().
            get("http://todo.ly/api/projects/"+idProject+".json");

    response.then().
            statusCode(200);


}



}
