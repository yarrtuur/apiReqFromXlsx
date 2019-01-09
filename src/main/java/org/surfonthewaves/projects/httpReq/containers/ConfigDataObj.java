package org.surfonthewaves.projects.httpReq.containers;

public class ConfigDataObj {
    private String requestFile;
    private String connectFile;
    private String responseFile;
    private AccessLevel accessLevel;

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getRequestFile() {
        return requestFile;
    }

    public void setRequestFile(String requestFile) {
        this.requestFile = requestFile;
    }

    public String getConnectFile() {
        return connectFile;
    }

    public void setConnectFile(String connectFile) {
        this.connectFile = connectFile;
    }

    public String getResponseFile() {
        return responseFile;
    }

    public void setResponseFile(String responseFile) {
        this.responseFile = responseFile;
    }
}
