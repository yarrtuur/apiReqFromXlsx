package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;

public class LoadRequestParams implements ILoadRequestParams{
    private IConnectionProperties connectionProperties;

    public void setConnectProperties(IConnectionProperties inConnectionProperties) {
        this.connectionProperties = inConnectionProperties;
    }

    public String getUrlConnect()  throws ExitException{
        if(chkConnectionProperties()) {
            return connectionProperties.getConnUrlConnect();
        }else{
            throw new ExitException("No connection properties for get URL connect");
        }
    }

    public String getUserNameAndPasswd() throws ExitException {
        if (chkConnectionProperties()) {
            StringBuilder sb = new StringBuilder();
            return sb.append("userName=").append(connectionProperties.getConnUserName())
                    .append("&password=").append(connectionProperties.getConnPasswd()).toString();
        } else {
            throw new ExitException("No connection properties for get username and passwd");
        }
    }

    private boolean chkConnectionProperties(){
        return (connectionProperties != null) ? true : false;
    }
}
