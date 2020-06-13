package com.wez.drools.carboncopy.entity;

import java.util.List;

public class CarbonCopyRole {

    /** 项目名称 */
    private String projectName;
    /** 角色名称 */
    private List<String> roleNames;
    
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public List<String> getRoleNames() {
        return roleNames;
    }
    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }
    
}
