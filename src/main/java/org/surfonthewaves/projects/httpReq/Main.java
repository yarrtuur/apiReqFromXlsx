package org.surfonthewaves.projects.httpReq;

import org.surfonthewaves.projects.httpReq.data_containers.FileNamesDict;
import org.surfonthewaves.projects.httpReq.data_containers.RequestNode;
import org.surfonthewaves.projects.httpReq.utils.IRequestDataReader;
import org.surfonthewaves.projects.httpReq.utils.RequestDataReader;
import org.surfonthewaves.projects.httpReq.utils.*;

import java.util.Collection;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try {

            FileNamesDict fileNamesDict = new FileNamesDict();
            fileNamesDict.setConnectFile("./connsrv.properties");
            fileNamesDict.setRequestFile("./requestFields.csv");
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
