package runner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    @Given("^yo tengo acceso a (.*)$")
    public void yoTengoAccesoATodoLy(String pagina) {
        System.out.println("Este paso esta funcionando con cucumber : "+pagina);
    }

    @And("^usando mi cuenta de administrador$")
    public void usandoMiCuentaDeAdministrador() {
    }

    @When("^lleno el campo (email|password) con (.*)$")
    public void llenoElCampoEmailConCucumberCucumberCom(String control, String value) {
        System.out.println(control+ "tiene el valor: "+value);
    }


    @Then("^yo deberia ingresar en la pagina principal$")
    public void yoDeberiaIngresarEnLaPaginaPrincipal() {
    }
}
