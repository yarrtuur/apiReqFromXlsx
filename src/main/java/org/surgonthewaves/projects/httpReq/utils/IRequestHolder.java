package org.surgonthewaves.projects.httpReq.utils;

import org.surgonthewaves.projects.httpReq.ExitException;

import java.util.Map;

public interface IRequestHolder {

    public Map<String, String> sendRequest() throws ExitException;

    public Map<String, String> sendRequest(String key, String condition) throws ExitException;
}
