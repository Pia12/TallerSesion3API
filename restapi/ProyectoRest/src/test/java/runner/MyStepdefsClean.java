package runner;

import clientAPI.FactoryRequest;
import clientAPI.RequestInformation;
import configuration.Constantes;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.JsonHelper;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


import static configuration.Constantes.*;

public class MyStepdefsClean {
    public Response response;
    public Map<String,String> variables = new HashMap<>();

    @Given("^I have token ready to use in Todo\\.ly$")
    public void iHaveTokenReadyToUseInTodoLy() {
        RequestInformation requestInformation = new RequestInformation();
        requestInformation.setUrl(URL_GET_TOKEN);
        requestInformation.setBody("");
        this.response=FactoryRequest.make(GET).send(requestInformation);
        Constantes.TOKEN_VALUE=response.then().extract().path("TokenString");
    }

    @When("^I send a POST request (.*) with json body$")
    public void iSendAPOSTRequestHttpTodoLyApiProjectsJsonWithJsonBody(String url,String body) {
        RequestInformation requestInformation = new RequestInformation();
        requestInformation.setUrl(url);
        requestInformation.setBody(body);
        this.response=FactoryRequest.make(POST).send(requestInformation);
        this.response.prettyPrint();
    }

    @Then("^I expected the response code (\\d+)$")
    public void iExpectedTheResponseCode(int expectedResponseCode) {
        this.response.then().
                statusCode(expectedResponseCode);
    }

    @And("^I expected the jsonBody$")
    public void iExpectedTheJsonBody(String expectedResultJson) {
        boolean isEqual=JsonHelper.areEqualJsons(expectedResultJson,this.response.body().asString())  && JsonHelper.areEqualJsons(this.response.body().asString(),expectedResultJson);
        Assert.assertTrue("ERROR los json no son igual",isEqual);
    }

    @And("^I expectedRevers the jsonBody$")
    public void iExpectedTheJsonBodys(String expectedResultJson) {
        boolean isEqual=JsonHelper.areEqualJsons(this.response.body().asString(),expectedResultJson);
        Assert.assertTrue("ERROR los json no son igual",isEqual);
    }

    @And("^I get the value the attribute (.*) and save in (.*)$")
    public void iGetTheValueTheAttributeIdAndSaveInID_EYNAR(String attribute, String nameVariable) {
        variables.put(nameVariable,this.response.then().extract().path(attribute)+"");
    }

    @And("^I send a (PUT|DELETE) request (.*) with json body$")
    public void iSendAPUTRequestHttpTodoLyApiProjectsID_EYNARJsonWithJsonBody(String method,String url,String body) {
        RequestInformation requestInformation = new RequestInformation();
        requestInformation.setUrl(this.remplazar(url));
        requestInformation.setBody(this.remplazar(body));
        this.response=FactoryRequest.make(method).send(requestInformation);
        this.response.prettyPrint();


    }

    public String remplazar(String value){
        for (String key:variables.keySet()) {
            value=value.replace(key,variables.get(key));
        }
        return value;
    }

}
