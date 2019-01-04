package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;

public interface ILoadRequestParams {

    public void setConnectProperties(IConnectionProperties inConnectionProperties);

    public String getUrlConnect() throws ExitException;

    public String getUserNameAndPasswd() throws ExitException;

}
