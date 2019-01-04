package org.surgonthewaves.projects.httpReq.utils;

import com.mashape.unirest.http.HttpResponse;
import org.surgonthewaves.projects.httpReq.ExitException;

public interface IHttpUrlRequest {

    HttpResponse<String> postRequest(String postUrl, String urlParameters) throws ExitException;

}
