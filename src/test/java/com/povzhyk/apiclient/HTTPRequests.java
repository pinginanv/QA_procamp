package com.povzhyk.apiclient;

import com.povzhyk.configuration.models.Configuration;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HTTPRequests {
    public Response sendPostRequest(Configuration configuration, String endPoint){
        String url =  configuration.getHost() + endPoint;
        Response response = given()
                .post(url);

        return response;
    }

    public Response sendGetRequest(Configuration configuration, String endPoint){

        String url =  configuration.getHost() + endPoint;
        Response response = given()
                .get(url);

        return response;
    }

    public void sendPutRequest(){
        //TODO
    }

    public void sendDeleteRequest(){
        //TODO
    }
}
