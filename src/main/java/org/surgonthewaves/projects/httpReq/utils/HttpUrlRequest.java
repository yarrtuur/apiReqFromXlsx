package org.surgonthewaves.projects.httpReq.utils;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;
import org.surgonthewaves.projects.httpReq.ExitException;

public class HttpUrlRequest implements IHttpUrlRequest{

    public HttpResponse<String> postRequest(String postUrl, String urlParameters) throws ExitException {
        try {
            return Unirest.post(String.format("%s?%s", postUrl, urlParameters))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("cache-control", "no-cache")
                    .asString();
        } catch (UnirestException  ex) {
            throw new ExitException(ex.getStackTrace().toString());
        }
    }

}
