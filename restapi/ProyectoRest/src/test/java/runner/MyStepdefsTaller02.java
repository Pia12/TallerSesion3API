package runner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;



public class MyStepdefsTaller02 {

    private String token;
    private Response response;
    private String idItem;


    @Given("^yo tengo un token usando mi usuario: (.*) y password: (.*)$")
    public void yoTengoUnTokenUsandoMiUsuarioUSERYPassword(String usuario, String pwd) {
        // get proyecto
        response =
                given().
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


    @When("^yo envio un POST a la url (.*) con json body$")
    public void yoEnvioUnPOSTALaUrlHttpsTodoLyApiItemsJsonConJsonBody(String url, String jsonBody) {
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

    @Then("^espero que mi codigo de respuesta sea (\\d+)$")
    public void esperoQueMiCodigoDeRespuestaSea(int respondeCode) {
        this.response.then().statusCode(200);
        System.out.println("Verificacion de codigo de respuesta");
    }

    @And("^yo espero que la propiedad : (.*) creado sea (.*)$")
    public void yoEsperoQueLaPropiedadContentCreadoSeaItem_Taller(String propiedad, String expectedResult) {
        response.then().
                statusCode(200).
                body(propiedad, equalTo(expectedResult));

    }

    @And("^guardo el valor de (.*) en la variable ID_ITEM$")
    public void guardoElValorDeIdEnLaVariableID_ITEM(String attribute) {
        idItem = this.response.then().extract().path(attribute)+"";
    }

    @When("^envio un PUT request a la url (.*) usando el ID : ID_ITEM con json body$")
    public void envioUnPUTRequestALaUrlHttpsTodoLyApiItemsIDJsonUsandoElIDID_ITEMConJsonBody(String url, String jsonBody) {
        url=url.replace("ID",idItem);
        this.response = given().
                header("Token",token).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonBody).
                when().
                put(url);

    }



    @When("^envio un DELETE request a la url (.*) usando el ID : ID_ITEM$")
    public void envioUnDELETERequestALaUrlHttpsTodoLyApiItemsIDJsonUsandoElIDID_ITEM(String url) {
        url=url.replace("ID",idItem);
        this.response = given().
                header("Token",token).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                delete(url);

    }
}
