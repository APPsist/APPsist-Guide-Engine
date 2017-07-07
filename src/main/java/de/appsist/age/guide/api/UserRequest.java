/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.appsist.age.guide.api;

import java.util.List;

/**
 * @author jens.bienias(at)im-c.de
 */
public interface UserRequest extends Branch {
    @Override
    default BranchType getBranchType() {
        return BranchType.USER_REQUEST;
    }
    
    public List<? extends Option> getOptions();
    public void addOption(Option option);
    public void removeOption(Option option);
}
