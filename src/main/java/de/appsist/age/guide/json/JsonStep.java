package de.appsist.age.guide.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.appsist.age.guide.json.util.JsonUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * JSON implementation for the step model.
 * @author simon.schwantzer(at)im-c.de
 */
public abstract class JsonStep implements de.appsist.age.guide.api.Step, UpdateListener {
    protected final ObjectNode json;
    private final Map<String, String> content;
    private JsonGuide parent;
    
    public JsonStep(String id) {
        json = JsonNodeFactory.instance.objectNode();
        json.put("id", id);
        json.put("type", getType());
        content = new LinkedHashMap<>();
    }
    
    public void setParent(JsonGuide guide) {
        this.parent = guide;
    }
    
    public JsonGuide getParent() {
        return parent;
    }
    
    @Override
    public void updatePerformed() {
        if (parent != null) parent.updatePerformed();
    }
    
    protected JsonStep(ObjectNode json) throws IllegalArgumentException {
        validate(json);
        this.json = json;
        this.content = new LinkedHashMap<>();
        if (json.path("content").isObject()) {
            ObjectNode contentObject = (ObjectNode) json.path("content");
            Iterator<Map.Entry<String, JsonNode>> fieldIterator = contentObject.fields();
            while (fieldIterator.hasNext()) {
                Map.Entry<String, JsonNode> field = fieldIterator.next();
                content.put(field.getKey(), field.getValue().asText());
            }
        }
    }
    
    private static void validate(ObjectNode json) throws IllegalArgumentException {
        JsonUtil.validateTextNode(json.path("id"), "id", false);
        JsonUtil.validateTextNode(json.path("type"), "type", false);
        JsonUtil.validateStringMap(json.path("content"), "content", true);
        JsonUtil.validateTextNode(json.path("next"), "next", true);
    }
    
    public static JsonStep fromJson(ObjectNode stepNode) throws IllegalArgumentException {
        if (stepNode.path("type").isMissingNode()) {
            throw new IllegalArgumentException("Missing or invalid field [type], string expected.");
        }
        JsonStep step;
        String type = stepNode.path("type").asText("<unknown>");
        switch (type) {
            case "action":
                step = new JsonAction(stepNode);
                break;
            case "milestone":
                step = new Milestone(stepNode);
                break;
            case "chapter":
                step = new Chapter(stepNode);
                break;
            case "branch":
                JsonNode userRequestNode = stepNode.get("userRequest");
                if (userRequestNode.isMissingNode() || !userRequestNode.isObject()) {
                    throw new IllegalArgumentException("Wrong or missing userReques field, expects object.");
                }
               step = new UserRequest(stepNode);
                break;
                
            default:
                throw new IllegalArgumentException("Invalid step type: " + type);
        }
        return step;
    }
    
    @Override
    public String getId() {
        return json.path("id").asText(null);
    }

    @Override
    public String getContentId(String languageId) {
        return content.get(languageId);
    }

    @Override
    public Map<String, String> getContentIds() {
        return Collections.unmodifiableMap(content);
    }

    @Override
    public void setContentId(String languageId, String contentId) {
        content.put(languageId, contentId);
        JsonUtil.getOrCreateObject(json, "content").set(languageId, JsonNodeFactory.instance.textNode(contentId));
        updatePerformed();
    }

    @Override
    public void removeContentId(String languageId) {
        if (!content.containsKey(languageId)) return;
        content.remove(languageId);
        JsonUtil.getOrCreateObject(json, "content").remove(languageId);
        if (content.isEmpty()) {
            json.remove("content");
        }
        updatePerformed();
    }

    @Override
    public void setNext(String stepId) {
        json.put("next", stepId);
        updatePerformed();
    }

    @Override
    public void removeNext() {
        json.remove("next");
        updatePerformed();
    }

    @Override
    public String getNext() {
        return json.path("next").asText(null);
    }
    
    /**
     * Returns the json object wrapped by this object.
     * @return Json object representing a step.
     */
    public ObjectNode asJson() {
        return json;
    }
}
