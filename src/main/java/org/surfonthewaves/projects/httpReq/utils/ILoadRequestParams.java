package org.surfonthewaves.projects.httpReq.utils;

import org.surfonthewaves.projects.httpReq.ExitException;

public interface ILoadRequestParams {

    void setConnectProperties(IConnectionProperties inConnectionProperties);

    String getUrlConnect() throws ExitException;

    String getUserNameAndPasswd() throws ExitException;

}
