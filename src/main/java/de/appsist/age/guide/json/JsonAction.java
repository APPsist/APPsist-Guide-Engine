/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.json;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author jens.bienias(at)im-c.de
 */
public class JsonAction extends JsonStep implements de.appsist.age.guide.api.Action {

    public JsonAction(String id) {
        super(id);
    }
    
    public JsonAction(ObjectNode actionNode) throws IllegalArgumentException {
        super(actionNode);
        validate(actionNode);
    }
    
    private static void validate(ObjectNode json) throws IllegalArgumentException {
        // nothing
    }
}
