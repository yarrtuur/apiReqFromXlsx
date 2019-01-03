package org.surgonthewaves.projects.httpReq;

import org.surgonthewaves.projects.httpReq.utils.*;
import org.surgonthewaves.projects.httpReq.data_containers.*;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        try {

            IRequestDataReader requestDataReader = new RequestDataReader();
            Collection<RequestNode> collectionRequests = requestDataReader.getRequestData("./requestFields.xlsx");
            ILoadRequestParams loaderRequestParams = new LoadRequestParams();
            //todo - make method which gets connection properties file for loaderRequestParams

            IRequestHolder requestHolder = new RequestHolder(collectionRequests);
            requestHolder.sendRequest(collectionRequests, loaderRequestParams);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
