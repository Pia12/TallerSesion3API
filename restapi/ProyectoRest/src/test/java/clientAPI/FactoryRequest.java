package clientAPI;

import static configuration.Constantes.*;

public class FactoryRequest {

    public static HttpRequest make(String tipoRequest){
        HttpRequest request;
        switch (tipoRequest.toLowerCase()){
            case GET:
                request= new RequestGET();
                break;
            case PUT:
                request= new RequestPUT();
                break;
            case POST:
                request= new RequestPOST();
                break;
            case DELETE:
                request= new RequestDELETE();
                break;
            case PATCH:
                request= new RequestPATCH();
                break;
            default:
                request= new RequestGET();
                break;

        }
        return request;
    }


}
