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
public class ProjectStaff {

    private int psID;
    private int projectID;
    private int staffID;
    private int role;
    private Timestamp inDate;
    private Timestamp outDate;

    public ProjectStaff(int psID, int projectID, int staffID, int role, Timestamp inDate, Timestamp outDate) {
        this.psID = psID;
        this.projectID = projectID;
        this.staffID = staffID;
        this.role = role;
        this.inDate = inDate;
        this.outDate = outDate;
    }

    public int getPsID() {
        return psID;
    }

    public void setPsID(int psID) {
        this.psID = psID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Timestamp getInDate() {
        return inDate;
    }

    public void setInDate(Timestamp inDate) {
        this.inDate = inDate;
    }

    public Timestamp getOutDate() {
        return outDate;
    }

    public void setOutDate(Timestamp outDate) {
        this.outDate = outDate;
    }

}
