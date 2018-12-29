package org.surgonthewaves.projects.httpReq.utils;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;
import org.surgonthewaves.projects.httpReq.ExitException;

import java.io.File;
import java.util.Collection;

public class RequestDataReader {
    private String configRequestData;

    public RequestDataReader(String configRequestData) {
        this.configRequestData = configRequestData;
    }

    public Collection<RequestNode> getRequestData() throws ExitException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            Xcelite xcelite = new Xcelite(new File(classloader.getResource(configRequestData).getFile()));
            XceliteSheet sheet = xcelite.getSheet("TZ");
            SheetReader<RequestNode> reader = sheet.getBeanReader(RequestNode.class);
            Collection<RequestNode> requestNode = reader.read();
            return requestNode;
        } catch (Exception e) {
            throw new ExitException(e.getMessage());
        }
    }
}
