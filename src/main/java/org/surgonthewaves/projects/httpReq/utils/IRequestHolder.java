package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;

import java.util.Collection;
import java.util.LinkedList;

public interface IRequestHolder {

    LinkedList<String> sendRequest(Collection<RequestNode> collectionRequests, ILoadRequestParams loader) throws ExitException;

}
