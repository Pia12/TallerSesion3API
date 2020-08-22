package clientAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static configuration.Constantes.TOKEN;
import static configuration.Constantes.TOKEN_VALUE;
import static io.restassured.RestAssured.given;

public class RequestPATCH implements HttpRequest {


    @Override
    public Response send(RequestInformation requestInformation) {
        Response response = given().
                header(TOKEN,TOKEN_VALUE).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(requestInformation.getBody()).
                when().
                patch(requestInformation.getUrl());
        return response;
    }




}
