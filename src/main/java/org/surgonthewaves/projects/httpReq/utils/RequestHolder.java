package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class RequestHolder implements IRequestHolder{
    private String userNameAndPasswd;
    private String postUrl;
    private Collection<RequestNode> requestList;
    private Map<String, Object> requestMap;

    public RequestHolder(Collection<RequestNode> requestList) throws ExitException {
        ILoadRequestParams loader = new LoadRequestParams();
        this.postUrl = loader.getUrlConnect();
        this.requestList = requestList;
    }

    public void sendRequest() throws ExitException {
        for (RequestNode step : requestList) {
            requestMap = step.getDynamicCols();
            String urlParameters = makeUrlParameters();
            IHttpUrlRequest httpUrlRequest = new HttpUrlRequest();
            httpUrlRequest.postRequest(postUrl, urlParameters).getBody();
        }

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
