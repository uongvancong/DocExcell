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
public class Staff {

    private int staffID;
    private int genID;
    private String name;
    private String knoxID;
    private String numberPhone;
    private String address;
    private Timestamp birthday;
    private int partID;

    public Staff(int staffID, int genID, String name, String knoxID, String numberPhone, String address, Timestamp birthday, int partID) {
        this.staffID = staffID;
        this.genID = genID;
        this.name = name;
        this.knoxID = knoxID;
        this.numberPhone = numberPhone;
        this.address = address;
        this.birthday = birthday;
        this.partID = partID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getGenID() {
        return genID;
    }

    public void setGenID(int genID) {
        this.genID = genID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKnoxID() {
        return knoxID;
    }

    public void setKnoxID(String knoxID) {
        this.knoxID = knoxID;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

}
