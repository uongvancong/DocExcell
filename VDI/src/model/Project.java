/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Project {

    private int propjectID;
    private String name;
    private String projectCode;
    private String description;

    public Project(int propjectID, String name, String projectCode, String description) {
        this.propjectID = propjectID;
        this.name = name;
        this.projectCode = projectCode;
        this.description = description;
    }

    public int getPropjectID() {
        return propjectID;
    }

    public void setPropjectID(int propjectID) {
        this.propjectID = propjectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
