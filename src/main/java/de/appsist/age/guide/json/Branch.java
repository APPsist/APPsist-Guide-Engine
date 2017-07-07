/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.json;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * JSON wrapper implementation of the branch model interface.
 * @author jens.bienias(at)im-c.de
 */
public abstract class Branch extends JsonStep implements de.appsist.age.guide.api.Branch {
    protected Branch(String id) {
        super(id);
    }
    
    protected Branch(ObjectNode json) throws IllegalArgumentException {
        super(json);
    }
}
