package runner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MyStepdefs2 {

    private String token;
    private Response response;
    private String idProject;

    @Given("^yo tengo mi token usando mi usuario: (.*) y password: (.*)$")
    public void yoTengoMiTokenUsandoMiUsuarioJavierapiApiComYPasswordApi(String usuario, String pwd) {
        // get proyecto
         response = given().
                auth().
                preemptive().
                basic(usuario,pwd).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                get("http://todo.ly/api/authentication/token.json");

        response.then().
                statusCode(200);

        this.token= response.then().extract().path("TokenString");
        System.out.println("INFO : TOKEN "+ this.token);

    }

    @When("^yo envio un POST request a la url (.*) con json body$")
    public void yoEnvioUnPOSTRequestALaUrlHttpTodoLyApiProjectsJsonConJsonBody(String url, String jsonBody) {
        response = given().
                header("Token",this.token).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonBody).
                when().
                post(url);
        System.out.println("INFO >  Post Request Executed");
        response.prettyPrint();


    }

    @Then("^yo espero que mi codigo de respuesta sea (\\d+)$")
    public void yoEsperoQueMiCodigoDeRespuestaSea(int respondeCode) {
        this.response.then().statusCode(200);
        System.out.println("Verificacion de codigo de respuesta");

    }

    @And("^espero que la propiedad : (.*) creado sea (.*)$")
    public void esperoQueMiNombreDelProyectoCreadoSeaSESSION(String propiedad, String expectedResult) {

        response.then().
                statusCode(200).
                body(propiedad, equalTo(expectedResult));

    }


    @And("^espero que la propiedad int : (.*) creado sea (.*)$")
    public void esperoQueLaPropiedadIntIconCreadoSea(String propiedad,int expectedResult) {
        this.response.then().
                body(propiedad, equalTo(expectedResult));
    }

    @And("^yo guardo el valor de (.*) en la variable ID_PROYECTO$")
    public void yoGuardoElValorDeIdEnLaVariableID_PROYECTO(String attribute) {
            idProject = this.response.then().extract().path(attribute)+"";

    }

    @When("^yo envio un PUT request a la url (.*) usando el ID : ID_PROYECTO con json body$")
    public void yoEnvioUnPUTRequestALaUrlHttpTodoLyApiProjectsIDJsonUsandoElIDID_PROYECTOConJsonBody(String url, String jsonBody) {
        url=url.replace("ID",idProject);
        this.response = given().
                header("Token",token).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonBody).
                when().
                put(url);
    }

    @When("^yo envio un DELETE request a la url (.*) usando el ID : ID_PROYECTO$")
    public void yoEnvioUnDELETERequestALaUrlHttpTodoLyApiProjectsIDJsonUsandoElIDID_PROYECTO(String url) {
        url=url.replace("ID",idProject);
        this.response = given().
                header("Token",token).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                delete(url);

    }
}
