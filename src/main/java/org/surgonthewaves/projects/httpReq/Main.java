package org.surgonthewaves.projects.httpReq;

import org.surgonthewaves.projects.httpReq.utils.*;
import org.surgonthewaves.projects.httpReq.data_containers.*;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        try {

            IRequestDataReader requestDataReader = new RequestDataReader();
            Collection<RequestNode> collectionRequests = requestDataReader.getRequestData("./requestFields.xlsx");

            IConnectionProperties connectionProperties = new ConnectionProperties();
            connectionProperties.setConnParams("./connsrv.properties");

            ILoadRequestParams loaderRequestParams = new LoadRequestParams();
            loaderRequestParams.setConnectProperties(connectionProperties);

            IRequestHolder requestHolder = new RequestHolder(collectionRequests);
            requestHolder.sendRequest(collectionRequests, loaderRequestParams);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
