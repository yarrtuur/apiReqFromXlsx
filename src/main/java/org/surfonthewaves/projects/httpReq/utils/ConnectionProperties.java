package org.surfonthewaves.projects.httpReq.utils;

import org.surfonthewaves.projects.httpReq.ExitException;
import org.surfonthewaves.projects.httpReq.containers.ConfigDataObj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionProperties implements IConnectionProperties{
    private String connParamFile;
    private Properties connProperties = new Properties();

    private boolean chkConnParamFile(){
        return connParamFile != null;
    }

    public void setConnParams(ConfigDataObj configDataObj) throws ExitException {
        connParamFile = configDataObj.getConnectFile();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (
                InputStream in = classloader.getResourceAsStream(connParamFile)
        ) {
            connProperties.load(in);
        } catch (IOException | NullPointerException e) {
            throw new ExitException("No file .properties found in " + e.getMessage());
        }
    }

    public String getConnUserName() throws ExitException{
        if(chkConnParamFile()) {
            return connProperties.getProperty("conn.userName");
        }else{
                throw new ExitException("Don`t have file with user name");
            }
    }

    public String getConnPasswd() throws ExitException {
         if(chkConnParamFile()) {
             return connProperties.getProperty("conn.password");
         }else {
             throw new ExitException("Don`t have file with password");
         }
    }

    public String getConnUrlConnect() throws ExitException {
        if(chkConnParamFile()) {
            return connProperties.getProperty("conn.urlConnect");
        }else {
            throw new ExitException("Don`t have file with urlConnect");
        }
    }

}
