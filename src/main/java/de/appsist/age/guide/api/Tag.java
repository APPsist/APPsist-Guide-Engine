/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.api;

import java.util.AbstractMap;

/**
 * Model for a tag.
 * Tags are either typed or custom. Typed tags represent static values, whilst
 * custom tags can contain any string value.
 * @author simon.schwantzer(at)im-c.de
 */
public interface Tag {
    public enum Type {
        TYPED,
        CUSTOM
    }
    
    public Type getType();
    
    /**
     * Returns the value of a tag.
     * @return 
     */
    public String getValue();
    
    /**
     * Returns the tag value as key value pair, esp. relevant for typed tags.
     * Expects a tag with value string "[key]:[value]", otherwise the value will be empty.
     * @return 
     */
    default AbstractMap.SimpleImmutableEntry asEntry() {
        String[] splittedValue = getValue().split(":");
        return new AbstractMap.SimpleImmutableEntry(splittedValue[0], splittedValue.length > 1 ? getValue().substring(splittedValue[0].length()) : null);
    }
}
