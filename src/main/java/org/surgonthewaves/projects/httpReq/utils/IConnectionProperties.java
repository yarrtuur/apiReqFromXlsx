package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;

public interface IConnectionProperties {

    public void setConnParams(String fileName) throws ExitException;

    public String getConnUserName() throws ExitException;

    public String getConnPasswd() throws ExitException;

    public String getConnUrlConnect() throws ExitException;

}
