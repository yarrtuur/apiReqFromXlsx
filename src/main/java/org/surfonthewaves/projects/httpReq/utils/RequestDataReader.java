package org.surfonthewaves.projects.httpReq.utils;

import org.surfonthewaves.projects.httpReq.data_containers.FileNamesDict;
import org.surfonthewaves.projects.httpReq.data_containers.RequestNode;

import java.io.*;
import java.util.*;

public class RequestDataReader implements IRequestDataReader {
    private List<RequestNode> reqCollection = new LinkedList<>();

    public Collection<RequestNode> getRequestData(FileNamesDict fileNamesDict)  {
        String requestData = fileNamesDict.getRequestFile();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(classloader.getResourceAsStream(requestData)));)
        {
            getDataCollectionFromFile(reader);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return reqCollection;
    }

    private void getDataCollectionFromFile(BufferedReader reader) throws  IOException{
        String[] headerColumns = reader.readLine().split(",");
        while(reader.ready()){
            String[] dataColumns = reader.readLine().split(",");
            reqCollection.add(new RequestNode(fillUpMap(headerColumns, dataColumns)));
        }
    }

    private Map<String, Object> fillUpMap(String[] headerColumns, String[] dataColumns) {
        Map<String, Object> reqFieldsMapOut = new LinkedHashMap<>();
        for (int i = 0; i < dataColumns.length; i++) {
            reqFieldsMapOut.put(headerColumns[i], dataColumns[i]);
        }
        return reqFieldsMapOut;
    }

}
