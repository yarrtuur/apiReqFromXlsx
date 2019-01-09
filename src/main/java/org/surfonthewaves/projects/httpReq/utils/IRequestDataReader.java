package org.surfonthewaves.projects.httpReq.utils;

import org.surfonthewaves.projects.httpReq.ExitException;
import org.surfonthewaves.projects.httpReq.containers.ConfigDataObj;
import org.surfonthewaves.projects.httpReq.containers.RequestNode;

import java.util.Collection;

public interface IRequestDataReader {

    Collection<RequestNode> getRequestData(ConfigDataObj configDataObj) throws ExitException;

}
