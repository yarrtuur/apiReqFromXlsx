package org.surgonthewaves.projects.httpReq;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ResponseGetData {

    StringBuilder postString = new StringBuilder();

    public ResponseGetData(String postUrl, String urlParameters) {
        this.postString.append(postUrl).append(urlParameters);
    }

    public HttpResponse<String> requestMaked() throws UnirestException{
        HttpResponse<String> response1 = requestMaked(postString);;
        return response1;
    }

    private HttpResponse<String> requestMaked(StringBuilder postString) throws UnirestException {
        HttpResponse<String> responsel = Unirest.post(postString.toString())
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("cache-control", "no-cache")
                .body("undefined=")
                .asString();
        return responsel;
    }
}
