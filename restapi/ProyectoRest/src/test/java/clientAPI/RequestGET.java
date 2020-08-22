package clientAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static configuration.Constantes.*;
import static io.restassured.RestAssured.given;

public class RequestGET implements HttpRequest {


    @Override
    public Response send(RequestInformation requestInformation) {
        Response response = given().
                auth().
                preemptive().
                basic(USER, PWD).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                get(requestInformation.getUrl());
        return response;
    }




}
