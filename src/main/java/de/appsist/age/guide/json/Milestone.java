package de.appsist.age.guide.json;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * JSON wrapper implementation of the milestone interface model-
 * @author simon.schwantzer(at)im-c.de
 */
public class Milestone extends JsonStep implements de.appsist.age.guide.api.Milestone {
    public Milestone(String id) {
        super(id);
    }
    
    public Milestone(ObjectNode json) throws IllegalArgumentException {
        super(json);
        validate(json);
    }
    
    private static void validate(ObjectNode json) throws IllegalArgumentException {
        // nothing;
    }
}
