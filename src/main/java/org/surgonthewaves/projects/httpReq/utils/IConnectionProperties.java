package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.data_containers.FileNamesDict;

public interface IConnectionProperties {

    void setConnParams(FileNamesDict fileNamesDict) throws ExitException;

    String getConnUserName() throws ExitException;

    String getConnPasswd() throws ExitException;

    String getConnUrlConnect() throws ExitException;

}
