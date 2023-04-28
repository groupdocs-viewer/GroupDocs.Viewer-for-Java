package com.groupdocs.ui.viewer.demosapitests.cases;

import java.util.HashMap;
import java.util.Map;

public class LoadDocumentDescriptionCase {
    private String sourceGuid;
    private String sourcePassword;
    private LoadDocumentDescription expectedObject;
    private Map<Integer, Map<String, String>> externalData = new HashMap<>();

    public String getSourceGuid() {
        return sourceGuid;
    }

    public void setSourceGuid(String sourceGuid) {
        this.sourceGuid = sourceGuid;
    }

    public String getSourcePassword() {
        return sourcePassword;
    }

    public void setSourcePassword(String sourcePassword) {
        this.sourcePassword = sourcePassword;
    }

    public LoadDocumentDescription getExpectedObject() {
        return expectedObject;
    }

    public void setExpectedObject(LoadDocumentDescription expectedObject) {
        this.expectedObject = expectedObject;
    }

    /**
     * page number to map of external relative link to it's content (or content length in string format for png resources)
     */
    public Map<Integer, Map<String, String>> getExternalData() {
        return externalData;
    }

    public void setExternalData(Map<Integer, Map<String, String>> externalData) {
        this.externalData = externalData;
    }
}
