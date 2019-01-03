package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;

import java.util.Collection;

public interface IRequestDataReader {

    public Collection<RequestNode> getRequestData(String requestFile) throws ExitException;

}
