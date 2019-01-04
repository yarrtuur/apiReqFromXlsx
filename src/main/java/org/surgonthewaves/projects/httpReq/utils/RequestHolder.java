package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;

import java.util.*;

public class RequestHolder implements IRequestHolder{
    private String userNameAndPasswd;
    private String postUrl;
    private Collection<RequestNode> requestList;
    private Map<String, Object> requestMap;
    private LinkedList<String> responseList;

    public LinkedList<String> sendRequest(Collection<RequestNode> requestListIn, ILoadRequestParams loaderRequestParams) throws ExitException {
        this.postUrl = loaderRequestParams.getUrlConnect();
        this.requestList = requestListIn;
        this.responseList = new LinkedList<>();
        for (RequestNode step : requestList) {
            requestMap = step.getDynamicCols();
            String urlParameters = makeUrlParameters();
            IHttpUrlRequest httpUrlRequest = new HttpUrlRequest();
            responseList.add(httpUrlRequest.postRequest(postUrl, urlParameters).getBody());
        }
        return responseList;
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
