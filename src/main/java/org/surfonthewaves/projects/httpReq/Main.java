package org.surfonthewaves.projects.httpReq;

import org.surfonthewaves.projects.httpReq.containers.*;
import org.surfonthewaves.projects.httpReq.utils.*;

import java.util.Collection;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try {
            //todo - develop a concept to filfull config object
            ConfigDataObj configDataObj = new ConfigDataObj();
            configDataObj.setConnectFile("./connsrv.properties");
            configDataObj.setRequestFile("./requestFields.csv");
            configDataObj.setResponseFile("./responseFile.csv");
            configDataObj.setAccessLevel(AccessLevel.FULL);

            IRequestDataReader requestDataReader = new RequestDataReader();
            Collection<RequestNode> collectionRequests = requestDataReader.getRequestData(configDataObj);

            IConnectionProperties connectionProperties = new ConnectionProperties();
            connectionProperties.setConnParams(configDataObj);

            ILoadRequestParams loaderRequestParams = new LoadRequestParams();
            loaderRequestParams.setConnectProperties(connectionProperties);

            IRequestHolder requestHolder = new RequestHolder();
            LinkedList<String> responseList = requestHolder.sendRequest(collectionRequests, loaderRequestParams);

            //todo - make upload data module
            for (String s : responseList) {
                System.out.println(s);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
