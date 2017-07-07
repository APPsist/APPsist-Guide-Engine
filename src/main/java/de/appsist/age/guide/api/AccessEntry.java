/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.api;

/**
 * Model for a access entry.
 * @author jens.bienias(at)im-c.de
 */
public interface AccessEntry {
    public enum Type {
        USER,
        GROUP,
        ALL
    }
    
    /**
     * Returns the type of the entry.
     * @return See @link{AccessEntry.Type} for details.
     */
    public Type getType();
    
    /**
     * Returns the target indentifier.
     * @return Target identifier. May be <code>null</code> depending on type.
     */
    public String getId();
}
