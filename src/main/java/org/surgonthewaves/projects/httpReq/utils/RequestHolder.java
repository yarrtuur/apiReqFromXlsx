package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class RequestHolder {
    private String userNameAndPasswd;
    private String postUrl;
    private Collection<RequestNode> requestList;
    private Map<String, Object> requestMap;

    public RequestHolder(Collection<RequestNode> requestList) throws ExitException {
        LoadRequestParams loader = new LoadRequestParams();
        this.postUrl = loader.getUrlConnect();
        //this.userNameAndPasswd = loader.getUserNameAndPasswd();
        this.requestList = requestList;
    }

    public Map<String, String> sendRequest(String key, String condition) throws ExitException {
        for (RequestNode step : requestList) {
            requestMap = step.getDynamicCols();
            if (requestMap.get(key).equals(condition)) {
                String urlParameters = makeUrlParameters();
                HttpUrlRequest httpUrlRequest = new HttpUrlRequest();
                return httpUrlRequest.postRequest(postUrl, urlParameters);
            }
        }
        return Collections.emptyMap();
    }
    public Map<String, String> sendRequest() throws ExitException {
        for (RequestNode step : requestList) {
            requestMap = step.getDynamicCols();
            String urlParameters = makeUrlParameters();
            HttpUrlRequest httpUrlRequest = new HttpUrlRequest();
            return httpUrlRequest.postRequest(postUrl, urlParameters);
        }
        return Collections.emptyMap();
    }

    private String makeUrlParameters() {
        StringBuilder requestParams = new StringBuilder();
        for (Map.Entry<String, Object> step : requestMap.entrySet()) {
            requestParams.append(step.getKey()).append("=").append(step.getValue()).append("&");
        }
        requestParams.append(userNameAndPasswd);
        return requestParams.toString();
    }
}
