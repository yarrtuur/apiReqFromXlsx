package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;

public interface ILoadRequestParams {

    void setConnectProperties(IConnectionProperties inConnectionProperties);

    String getUrlConnect() throws ExitException;

    String getUserNameAndPasswd() throws ExitException;

}
