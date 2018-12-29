package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpUrlRequest {
    private HttpURLConnection myUrlCon;

    public Map<String, String> postRequest(String postUrl, String urlParameters) throws ExitException {
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        try {
            URL myUrl = new URL(postUrl);
            myUrlCon = (HttpURLConnection) myUrl.openConnection();
            setMyUrlConProperties(postDataLength);
            System.out.println(String.format("Request sent: %s", urlParameters));
            sendData(myUrlCon, postData);
            return receiveData(myUrlCon.getInputStream());
        } catch (IOException | ExitException ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    private void setMyUrlConProperties(int postDataLength) throws ProtocolException {
        myUrlCon.setRequestMethod("POST");
        myUrlCon.setDoOutput(true);
        myUrlCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        myUrlCon.setRequestProperty("charset", "utf-8");
        myUrlCon.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        myUrlCon.setUseCaches(false);
    }

    private void sendData(HttpURLConnection con, byte[] postData) throws IOException {
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(postData);
            wr.flush();
        } catch (IOException ex) {
            throw ex;
        }
    }

    private Map<String, String> receiveData(InputStream in) throws ExitException {
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))
        ) {
            while (reader.ready()) {
                sb.append(reader.readLine());
            }
        } catch (IOException ex) {
            throw new ExitException(ex.getMessage());
        }
        return makeResponseMap(sb.toString());
    }

    private Map<String, String> makeResponseMap(String responseLine) {
        String[] divideResponse = responseLine.split("&");
        Map<String, String> responseMap = new LinkedHashMap<>();
        for (String step : divideResponse) {
            String[] divStep = step.split("=");
            if (divStep.length > 1) {
                responseMap.put(divStep[0], divStep[1]);
            } else {
                responseMap.put(divStep[0], null);
            }
        }
        System.out.println(String.format("Response received: %s", responseLine));
        return responseMap;
    }

}
