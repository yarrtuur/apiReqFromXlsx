package org.surfonthewaves.projects.httpReq.utils;

import org.surfonthewaves.projects.httpReq.ExitException;
import org.surfonthewaves.projects.httpReq.containers.ConfigDataObj;

public interface IConnectionProperties {

    void setConnParams(ConfigDataObj configDataObj) throws ExitException;

    String getConnUserName() throws ExitException;

    String getConnPasswd() throws ExitException;

    String getConnUrlConnect() throws ExitException;

}
