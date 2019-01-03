package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;

import java.util.Map;

public interface IHttpUrlRequest {

    public Map<String, String> postRequest(String postUrl, String urlParameters) throws ExitException;

}
