package org.surgonthewaves.projects.httpReq;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnSrvConf {
    private Properties property = new Properties();
    private String postUrl;
    private final String path = "./connsrv.properties";

    public String getServer() {
        try ( FileInputStream fis = new FileInputStream(path);) {
            property.load(fis);
            postUrl = property.getProperty("conn.server");
        }catch(IOException ex) {
            System.err.println("ОШИБКА: Файл свойств отсуствует! ");
            ex.printStackTrace();
        }
        return postUrl;
    }
}
