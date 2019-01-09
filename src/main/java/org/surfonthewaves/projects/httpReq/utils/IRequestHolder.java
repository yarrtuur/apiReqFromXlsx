package org.surfonthewaves.projects.httpReq.utils;

import org.surfonthewaves.projects.httpReq.ExitException;
import org.surfonthewaves.projects.httpReq.containers.RequestNode;

import java.util.Collection;
import java.util.LinkedList;

public interface IRequestHolder {

    LinkedList<String> sendRequest(Collection<RequestNode> collectionRequests, ILoadRequestParams loader) throws ExitException;

}
