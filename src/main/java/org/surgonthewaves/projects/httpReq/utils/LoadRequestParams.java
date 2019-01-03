package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;

public class LoadRequestParams implements ILoadRequestParams{
    private IConnectionProperties connectionProperties;

    public LoadRequestParams() throws ExitException {
        connectionProperties = new ConnectionProperties();
    }

    public String getUrlConnect() {
        return connectionProperties.getConnUrlConnect();
    }

    public String getUserNameAndPasswd() {
        StringBuilder sb = new StringBuilder();
        return sb.append("userName=").append(connectionProperties.getConnUserName())
                .append("&password=").append(connectionProperties.getConnPasswd()).toString();
    }
}
