package org.surfonthewaves.projects.httpReq.utils;

import org.surfonthewaves.projects.httpReq.ExitException;
import org.surfonthewaves.projects.httpReq.containers.RequestNode;

import java.util.*;

public class RequestHolder implements IRequestHolder{
    private String userNameAndPasswd;
    private Map<String, Object> requestMap;

    public LinkedList<String> sendRequest(Collection<RequestNode> requestListIn, ILoadRequestParams loaderRequestParams) throws ExitException {
        String postUrl = loaderRequestParams.getUrlConnect();
        LinkedList<String> responseList = new LinkedList<>();
        for (RequestNode step : requestListIn) {
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
