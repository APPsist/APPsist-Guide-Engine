package de.appsist.age.guide.json;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.appsist.age.guide.json.util.JsonUtil;

/**
 * JSON wrappper implementation for a media reference in the content descriptor model.
 * @author simon.schwantzer(at)im-c.de
 */
public class Media implements de.appsist.age.guide.api.Media, UpdateListener {
    private final ObjectNode json;
    private JsonContent parent;
    
    public Media(String mimeType, String path) {
        json = JsonNodeFactory.instance.objectNode();
        json.put("mimeType", mimeType);
        json.put("path", path);
    }
    
    public Media(ObjectNode json) throws IllegalArgumentException {
        validate(json);
        this.json = json;
    }
    
    public void setParent(JsonContent parent) {
        this.parent = parent;
    }
    
    public JsonContent getParent() {
        return parent;
    }
    
    @Override
    public void updatePerformed() {
        if (parent != null) parent.updatePerformed();
    }
    
    private static void validate(ObjectNode json) throws IllegalArgumentException {
        JsonUtil.validateTextNode(json.path("mimeType"), "mimeType", false);
        JsonUtil.validateTextNode(json.path("path"), "path", false);
    }

    @Override
    public void setMimeType(String mimeType) {
        json.put("mimeType", mimeType);
        updatePerformed();
    }

    @Override
    public String getMimeType() {
        return json.path("mimeType").asText(null);
    }

    @Override
    public void setPath(String url) {
        json.put("path", url);
        updatePerformed();
    }

    @Override
    public String getPath() {
        return json.path("path").asText(null);
    }
    
    /**
     * Returns the JSON object wrapped by this object.
     * @return JSON object representing the media object.
     */
    public ObjectNode asJson() {
        return json;
    }
}
