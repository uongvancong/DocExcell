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
public class StatusProject {
    private int sqID;
    private int status;
    private String description;

    public StatusProject(int sqID, int status, String description) {
        this.sqID = sqID;
        this.status = status;
        this.description = description;
    }

    public int getSqID() {
        return sqID;
    }

    public void setSqID(int sqID) {
        this.sqID = sqID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
