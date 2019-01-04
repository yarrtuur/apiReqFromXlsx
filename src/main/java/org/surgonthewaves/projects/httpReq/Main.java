package org.surgonthewaves.projects.httpReq;

import org.surgonthewaves.projects.httpReq.utils.*;
import org.surgonthewaves.projects.httpReq.data_containers.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try {

            //todo make class that contain ways and files with request, connect and response data
            FileNamesDict fileNamesDict = new FileNamesDict();
            fileNamesDict.setConnectFile("./connsrv.properties");
            fileNamesDict.setRequestFile("./requestFields.xlsx");
            fileNamesDict.setResponseFile("./responseFile.csv");

            IRequestDataReader requestDataReader = new RequestDataReader();
            Collection<RequestNode> collectionRequests = requestDataReader.getRequestData(fileNamesDict.getRequestFile());

            IConnectionProperties connectionProperties = new ConnectionProperties();
            connectionProperties.setConnParams(fileNamesDict.getConnectFile());

            ILoadRequestParams loaderRequestParams = new LoadRequestParams();
            loaderRequestParams.setConnectProperties(connectionProperties);


            IRequestHolder requestHolder = new RequestHolder();
            LinkedList<String> responseList = requestHolder.sendRequest(collectionRequests, loaderRequestParams);
            Iterator<String> it = responseList.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
