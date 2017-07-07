/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.api;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Model for a asssistence guide.
 * @author jens.bienias(at)im.c
 */
public interface Guide {
    public String getId();
    
    public String getContentId(String languageId);
    public Map<String, String> getContentIds();
    public void setContentId(String languageId, String contentId);
    public void removeContentId(String languageId);
    
    public List<? extends AccessEntry> getAllAccessEntries();
    public boolean hasUserAccess(String userId);
    public boolean hasGroupAccess(String groupId);
    public boolean hasAllAccess();
    public void grantUserAccess(String userId);
    public void grantGroupAccess(String groupId);
    public void grantAllAccess();
    public void revokeUserAccess(String userId);
    public void revokeGroupAccess(String groupId);
    public void revokeAllAccess();
    
    public List<? extends Tag> getAllTags();
    public List<String> getCustomTags();
    public List<String> getTypedTags();
    public void addCustomTag(String value);
    public void removeCustomTag(String value);
    public void addTypedTag(String value);
    public void removeTypedTag(String value);
    
    public List<? extends Step> getSteps();
    public Step getStep(String stepId);
    public int indexOfStep(String stepId);
    public void addStep(int index, Step step);
    public void addStep(Step step);
    public Step removeStep(String stepId);
    
    public OffsetDateTime getLastUpdate();
}
