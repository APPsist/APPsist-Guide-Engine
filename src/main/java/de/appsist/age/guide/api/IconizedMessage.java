/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.api;

/**
 * Model for a message with icon, e.g., for usage in warning lists.
 * @author jens.bienias(at)im-c.de
 */
public interface IconizedMessage {
    /**
     * Sets the text for the message.
     * @param text Text to display.
     */
    public void setText(String text);
    
    /**
     * Returns the message text.
     * @return Text to display.
     */
    public String getText();
    
    /**
     * Sets the icon path.
     * @param path Path or URL for the icon to be displayed with the message.
     */
    public void setIcon(String path);
    
    /**
     * Returns the icon path.
     * @return Path or URL for the icon to be displayed. May be <code>null</code>.
     */
    public String getIcon();
}
