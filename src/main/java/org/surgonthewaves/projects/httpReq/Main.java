package org.surgonthewaves.projects.httpReq;

import org.surgonthewaves.projects.httpReq.utils.*;
import org.surgonthewaves.projects.httpReq.data_containers.*;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        try {

            RequestDataReader requestDataReader = new RequestDataReader("./requestFields.xlsx");
            Collection<RequestNode> collectionRequests = requestDataReader.getRequestData();



            IRequestHolder requestHolder = new RequestHolder(collectionRequests);
            requestHolder.sendRequest();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
