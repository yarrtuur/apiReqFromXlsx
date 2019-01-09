package org.surfonthewaves.projects.httpReq.utils;

import org.surfonthewaves.projects.httpReq.ExitException;
import org.surfonthewaves.projects.httpReq.data_containers.FileNamesDict;

public interface IConnectionProperties {

    void setConnParams(FileNamesDict fileNamesDict) throws ExitException;

    String getConnUserName() throws ExitException;

    String getConnPasswd() throws ExitException;

    String getConnUrlConnect() throws ExitException;

}
