package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.data_containers.FileNamesDict;

public interface IConnectionProperties {

    public void setConnParams(FileNamesDict fileNamesDict) throws ExitException;

    public String getConnUserName() throws ExitException;

    public String getConnPasswd() throws ExitException;

    public String getConnUrlConnect() throws ExitException;

}
