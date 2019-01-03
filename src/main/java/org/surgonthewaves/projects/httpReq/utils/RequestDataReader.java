package org.surgonthewaves.projects.httpReq.utils;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;
import org.surgonthewaves.projects.httpReq.ExitException;

import java.io.File;
import java.util.Collection;

public class RequestDataReader implements IRequestDataReader {
    private String requestData;

    public Collection<RequestNode> getRequestData(String requestFile) throws ExitException {
        this.requestData = requestFile;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            Xcelite xcelite = new Xcelite(new File(classloader.getResource(requestData).getFile()));
            XceliteSheet sheet = xcelite.getSheet("TZ");
            SheetReader<RequestNode> reader = sheet.getBeanReader(RequestNode.class);
            Collection<RequestNode> requestNode = reader.read();
            return requestNode;
        }catch ( Exception ex){
            throw new ExitException(ex.getStackTrace().toString());
        }
    }
}
