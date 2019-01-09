package org.surfonthewaves.projects.httpReq.data_containers;

import java.util.Map;
import java.util.Objects;

public class RequestNode {
    private Map<String, Object> dynamicCols;

    public RequestNode(Map<String, Object> mapStructure){
        dynamicCols = mapStructure;
    }

    public Map<String, Object> getDynamicCols() {
        return dynamicCols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestNode that = (RequestNode) o;
        return Objects.equals(dynamicCols, that.dynamicCols);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dynamicCols);
    }

    @Override
    public String toString() {
        return "RequestNode{" +
                "dynamicCols=" + dynamicCols +
                '}';
    }

}
