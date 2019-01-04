package org.surgonthewaves.projects.httpReq.utils;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import org.surgonthewaves.projects.httpReq.data_containers.FileNamesDict;
import org.surgonthewaves.projects.httpReq.data_containers.RequestNode;
import org.surgonthewaves.projects.httpReq.ExitException;

import java.io.File;
import java.util.Collection;

public class RequestDataReader implements IRequestDataReader {

    public Collection<RequestNode> getRequestData(FileNamesDict fileNamesDict) throws ExitException {
        String requestData = fileNamesDict.getRequestFile();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            Xcelite xcelite = new Xcelite(new File(classloader.getResource(requestData).getFile()));
            XceliteSheet sheet = xcelite.getSheet("TZ");
            SheetReader<RequestNode> reader = sheet.getBeanReader(RequestNode.class);
            return reader.read();
        }catch ( Exception ex){
            throw new ExitException(ex.getStackTrace().toString());
        }
    }
}
