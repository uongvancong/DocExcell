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
public class PlanStaff {

    private int staffID;
    private Timestamp dateWork;
    private int placeOfWork;
    private String description;

    public PlanStaff(int staffID, Timestamp dateWork, int placeOfWork, String description) {
        this.staffID = staffID;
        this.dateWork = dateWork;
        this.placeOfWork = placeOfWork;
        this.description = description;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public Timestamp getDateWork() {
        return dateWork;
    }

    public void setDateWork(Timestamp dateWork) {
        this.dateWork = dateWork;
    }

    public int getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(int placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
