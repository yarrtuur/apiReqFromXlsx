package org.surfonthewaves.projects.httpReq.utils;

import com.mashape.unirest.http.HttpResponse;
import org.surfonthewaves.projects.httpReq.ExitException;

public interface IHttpUrlRequest {

    HttpResponse<String> postRequest(String postUrl, String urlParameters) throws ExitException;

}
