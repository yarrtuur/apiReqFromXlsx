package org.surgonthewaves.projects.httpReq.utils;


import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;
import org.surgonthewaves.projects.httpReq.ExitException;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpUrlRequest implements IHttpUrlRequest{

    public Map<String, String> postRequest(String postUrl, String urlParameters) throws ExitException {
        try {
            HttpResponse <String> response = Unirest.post(String.format("%s?%s", postUrl, urlParameters))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("cache-control", "no-cache")
                    .asString();
            return receiveData(response);
        } catch (UnirestException | IOException ex) {
            throw new ExitException(ex.getStackTrace().toString());
        }
    }

    private Map<String, String> receiveData(HttpResponse response) throws IOException {
        return makeResponseMap(response.getBody().toString());
    }

    private Map<String, String> makeResponseMap(String responseLine) {
        String[] divideResponse = responseLine.split("&");
        Map<String, String> responseMap = new LinkedHashMap<>();
        for (String step : divideResponse) {
            String[] divStep = step.split("=");
            if (divStep.length > 1) {
                responseMap.put(divStep[0], divStep[1]);
            } else {
                responseMap.put(divStep[0], null);
            }
        }
        System.out.println(String.format("Response received: %s", responseLine));
        return responseMap;
    }

}
