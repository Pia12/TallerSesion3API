package basicExample;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestCreateProject {


    @Test
    public void createProject(){
        given().
                auth().preemptive().basic("javierapi@api.com","api123").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body("{\n" +
                        "   \"Content\" : \"MyRestAssure\",\n" +
                        "   \"Icon\":4\n" +
                        "}\n").
        when().
                post("http://todo.ly/api/projects.json").
        then().
                statusCode(200).
                body("Content",equalTo("MyRestAssure")).
                body("Icon",equalTo(4)).
                body("Deleted",equalTo(false));
              //  log().all();

    }



    @Test
    public void createProject2(){
        given().
                auth().preemptive().basic("javierapi@api.com","api123").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(new File("D:\\ClasesTESTING\\RestApi\\ProyectoRest\\src\\test\\resources\\crearProyecto.json")).
                when().
                post("http://todo.ly/api/projects.json").
                then().
                statusCode(200).
                body("Content",equalTo("SESSION02")).
                body("Icon",equalTo(4)).
                body("Deleted",equalTo(false));
        //  log().all();

    }


    @Test
    public void createProject3(){
        /*
            {
              "Content" : "SESSION02",
              "Icon":4
            }
         */

        JSONObject body = new JSONObject();
        body.put("Content","SESSION3");
        body.put("Icon","4");

        given().
                auth().preemptive().basic("javierapi@api.com","api123").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(body.toString()).
                when().
                post("http://todo.ly/api/projects.json").
                then().
                statusCode(200).
                body("Content",equalTo("SESSION3")).
                body("Icon",equalTo(4)).
                body("Deleted",equalTo(false)).
                body(matchesJsonSchemaInClasspath("schemaVerification.json"));
        //  log().all();

    }


}
