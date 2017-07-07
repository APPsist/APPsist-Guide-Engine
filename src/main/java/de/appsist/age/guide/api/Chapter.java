/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.api;

/**
 * @author jens.bienias(at)im-c.de
 */
public interface Chapter extends Step {
    @Override
    default String getType() {
        return "chapter";
    }
    
    public void setTarget(String guideId);
    public String getTarget();
}
