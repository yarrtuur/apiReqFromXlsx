package org.surfonthewaves.projects.httpReq.utils;

import org.surfonthewaves.projects.httpReq.ExitException;
import org.surfonthewaves.projects.httpReq.data_containers.FileNamesDict;
import org.surfonthewaves.projects.httpReq.data_containers.RequestNode;

import java.util.Collection;

public interface IRequestDataReader {

    Collection<RequestNode> getRequestData(FileNamesDict fileNamesDict) throws ExitException;

}
