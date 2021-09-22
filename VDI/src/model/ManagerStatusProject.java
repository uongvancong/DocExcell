/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class ManagerStatusProject {

    private int mspID;
    private int projectID;
    private String name;
    private int sqID;
    private Timestamp startDate;
    private Timestamp endDate;
    private String description;

    public ManagerStatusProject(int mspID, int projectID, String name, int sqID, Timestamp startDate, Timestamp endDate, String description) {
        this.mspID = mspID;
        this.projectID = projectID;
        this.name = name;
        this.sqID = sqID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public int getMspID() {
        return mspID;
    }

    public void setMspID(int mspID) {
        this.mspID = mspID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSqID() {
        return sqID;
    }

    public void setSqID(int sqID) {
        this.sqID = sqID;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
