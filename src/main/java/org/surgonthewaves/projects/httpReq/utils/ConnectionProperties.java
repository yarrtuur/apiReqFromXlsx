package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionProperties {
    private static final String CONNECT_PROPERTIES = "connsrv.properties";
    private Properties connProperties = new Properties();

    public ConnectionProperties() throws ExitException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (
                InputStream in = classloader.getResourceAsStream(CONNECT_PROPERTIES)
        ) {
            connProperties.load(in);
        } catch (IOException | NullPointerException e) {
            throw new ExitException("No file .properties found in " + e.getMessage());
        }
    }

    public String getConnUserName() {
        return connProperties.getProperty("userName");
    }

    public String getConnPasswd() {
        return connProperties.getProperty("password");
    }

    public String getConnUrlConnect() {
        return connProperties.getProperty("urlConnect");
    }

}
