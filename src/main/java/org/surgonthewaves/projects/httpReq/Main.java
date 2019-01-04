package org.surgonthewaves.projects.httpReq;

import org.surgonthewaves.projects.httpReq.utils.*;
import org.surgonthewaves.projects.httpReq.data_containers.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try {

            FileNamesDict fileNamesDict = new FileNamesDict();
            fileNamesDict.setConnectFile("./connsrv.properties");
            fileNamesDict.setRequestFile("./requestFields.xlsx");
            fileNamesDict.setResponseFile("./responseFile.csv");

            IRequestDataReader requestDataReader = new RequestDataReader();
            Collection<RequestNode> collectionRequests = requestDataReader.getRequestData(fileNamesDict);

            IConnectionProperties connectionProperties = new ConnectionProperties();
            connectionProperties.setConnParams(fileNamesDict);

            ILoadRequestParams loaderRequestParams = new LoadRequestParams();
            loaderRequestParams.setConnectProperties(connectionProperties);

            IRequestHolder requestHolder = new RequestHolder();
            LinkedList<String> responseList = requestHolder.sendRequest(collectionRequests, loaderRequestParams);


            for (String s : responseList) {
                System.out.println(s);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
