package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;

import java.util.Collection;

public interface IRequestHolder {

    public void sendRequest(Collection<RequestNode> collectionRequests, ILoadRequestParams loader) throws ExitException;

}
