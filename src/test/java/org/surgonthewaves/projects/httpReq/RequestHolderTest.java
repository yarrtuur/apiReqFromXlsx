package org.surgonthewaves.projects.httpReq;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.surgonthewaves.projects.httpReq.ExitException;
import org.surgonthewaves.projects.httpReq.utils.*;
import org.surgonthewaves.projects.httpReq.data_containers.*;

import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RequestHolderTest {
   /* private RequestDataReader requestDataReader = new RequestDataReader("requestFile.xlsx");
    private Collection<RequestNode> collectionRequests = requestDataReader.getRequestData();
    private RequestHolder requestHolder = new RequestHolder(collectionRequests);
    private Map<String, String> responseMap;

    public RequestHolderTest() throws ExitException {
    }

    @Before
    public void setBefore() {
        System.out.println("Start test");
    }

    @After
    public void setAfter() {
        System.out.println("End test");
    }

    @Test
    public void sendResponseCodeExpectedA01() throws ExitException {
        responseMap = requestHolder.sendRequest("amount", "5000");
        assertEquals("A01", responseMap.get("responseCode"));
    }

    @Test
    public void sendResponseCodeExpectedD03() throws ExitException {
        responseMap = requestHolder.sendRequest("amount", "12500");
        assertEquals("D03", responseMap.get("responseCode"));
    }

    @Test
    public void sendResponseCodeExpectedD05() throws ExitException {
        responseMap = requestHolder.sendRequest("amount", "7500");
        assertEquals("D05", responseMap.get("responseCode"));
    }

    @Test
    public void sendResponseCodeExpectedE02() throws ExitException {
        responseMap = requestHolder.sendRequest("amount", "13500");
        assertEquals("E02", responseMap.get("responseCode"));
    }

    @Test
    public void sendAVSVerificationExpected00() throws ExitException {
        responseMap = requestHolder.sendRequest("zipCode", "11111");
        assertEquals("00", responseMap.get("avsResponseCode"));
    }

    @Test
    public void sendAVSVerificationExpected46() throws ExitException {
        responseMap = requestHolder.sendRequest("zipCode", "22222");
        assertEquals("46", responseMap.get("avsResponseCode"));
    }

    @Test
    public void sendAVSVerificationExpected43() throws ExitException {
        responseMap = requestHolder.sendRequest("zipCode", "33333");
        assertEquals("43", responseMap.get("avsResponseCode"));
    }

    @Test
    public void sendAVSVerificationExpected40() throws ExitException {
        responseMap = requestHolder.sendRequest("zipCode", "44444");
        assertEquals("40", responseMap.get("avsResponseCode"));
    }

    @Test
    public void sendCSCVerificationExpectedM() throws ExitException {
        responseMap = requestHolder.sendRequest("csc", "111");
        assertEquals("M", responseMap.get("cscResponseCode"));
    }

    @Test
    public void sendCSCVerificationExpectedN() throws ExitException {
        responseMap = requestHolder.sendRequest("csc", "222");
        assertEquals("N", responseMap.get("cscResponseCode"));
    }

    @Test
    public void sendCSCVerificationExpectedP() throws ExitException {
        responseMap = requestHolder.sendRequest("csc", "333");
        assertEquals("P", responseMap.get("cscResponseCode"));
    }

    @Test
    public void sendCSCVerificationExpectedS() throws ExitException {
        responseMap = requestHolder.sendRequest("csc", "444");
        assertEquals("S", responseMap.get("cscResponseCode"));
    }
*/
}
