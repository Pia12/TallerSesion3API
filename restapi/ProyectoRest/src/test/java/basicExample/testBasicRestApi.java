package basicExample;

import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class testBasicRestApi {
    //init data
    // seteo de requerimientos


    @Before
    public void before(){
        System.out.println("before");
    }


    @Test
    public void verifyGetProject(){
       // System.out.println("test1");
       //given // when // then

        given().
                auth().preemptive().basic("javierapi@api.com","api123").
        when().
                get("http://todo.ly/api/projects.json").
        then().
                log().all();

    }

    @Test
    public void verifyGetProject02(){
        // System.out.println("test1");
        //given // when // then
        Response response = given().
                auth().preemptive().basic("javierapi@api.com","api123").
        when().
                get("http://todo.ly/api/projects.json");


        System.out.println("-----------prettyPrint-----------");
        response.prettyPrint();
        System.out.println("-----------fin prettyPrint-----------");
        response.body().print();


        response.then().statusCode(200);
    }

    @Test
    public void verifyGetProject3(){
        // given  / when  / then

        Response response=given().
                header("Authorization","Basic amF2aWVyYXBpQGFwaS5jb206YXBpMTIz").
                header("Accept","*/*").
                when().
                get("http://todo.ly/api/projects.json");


        response.prettyPrint();

        // verificacion
        response.then().statusCode(200);

    }


    @Test
    public void verifyGetProject4(){
        // given  / when  / then

        Response response=given().
                header("Authorization","Basic amF2aWVyYXBpQGFwaS5jb206YXBpMTIz").
                header("Accept","*/*").
                when().
                get("http://todo.ly/api/projects.json");


        response.prettyPrint();

        // verificacion
        response.then().statusCode(200);

    }

    //limpiar datos
    @After
    public void after(){
        System.out.println("after");
    }


}
