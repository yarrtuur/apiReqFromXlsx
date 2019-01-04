package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.data_containers.FileNamesDict;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;

import java.util.Collection;

public interface IRequestDataReader {

    Collection<RequestNode> getRequestData(FileNamesDict fileNamesDict) throws ExitException;

}
