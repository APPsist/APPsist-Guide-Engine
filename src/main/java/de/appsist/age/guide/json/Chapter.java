/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.json;

import com.fasterxml.jackson.databind.node.ObjectNode;
import de.appsist.age.guide.json.util.JsonUtil;

/**
 * JSON wrapper implementation for chapter model interface.
 * @author jens.bienias(at)im-c.de
 */
public class Chapter extends JsonStep implements de.appsist.age.guide.api.Chapter {
    
    public Chapter(String id, String target) {
        super(id);
        json.put("target", target);
    }
    
    protected Chapter(ObjectNode json) throws IllegalArgumentException {
        super(json);
        validate(json);
    }
    
    private static void validate(ObjectNode json) throws IllegalArgumentException {
        JsonUtil.validateTextNode(json.path("target"), "target", false);
    }

    @Override
    public void setTarget(String guideId) {
        json.put("target", guideId);
        updatePerformed();
    }

    @Override
    public String getTarget() {
        return json.path("target").asText(null);
    }
}
