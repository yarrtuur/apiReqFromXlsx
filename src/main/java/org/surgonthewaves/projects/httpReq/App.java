package org.surgonthewaves.projects.httpReq;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App{
    public static void main(String[] args) {
        ConnSrvConf propFilesReader = new ConnSrvConf();
        String postUrl = propFilesReader.getServer();
        if(postUrl == null){
            return;
        }
        //todo read xls files with param

        ReaderFromXlsx readerFromXlsx = new ReaderFromXlsx();
        //String urlParameters = readerFromXlsx.readFromExcel();
        String urlParameters = "nReg=AA0001AA&type=1";

        ResponseGetData responseGetData = new ResponseGetData(postUrl, urlParameters);
        HttpResponse<String>  response1;
        try {

            response1 = responseGetData.requestMaked();
            //todo make class to write data into xls file from response1 variable
            InputStream in = response1.getRawBody();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            System.out.println(reader.readLine());

        }catch(UnirestException | IOException ex){
            ex.printStackTrace();
        }
    }
}
