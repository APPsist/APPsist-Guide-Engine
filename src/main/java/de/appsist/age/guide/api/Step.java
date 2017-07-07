/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.api;

import java.util.Map;

/**
 * @author jens.bienias(at)im-c.de
 */
public interface Step {
    public String getType();
    public String getId();
    
    public String getContentId(String languageId);
    public Map<String, String> getContentIds();
    public void setContentId(String languageId, String contentId);
    public void removeContentId(String languageId);
    
    public void setNext(String stepId);
    public void removeNext();
    public String getNext();
}
