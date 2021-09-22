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
public class ManagerVDILog {

    private int mID;
    private String name;
    private Timestamp dateTimeConnect;
    private float connectTime;

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDateTimeConnect() {
        return dateTimeConnect;
    }

    public void setDateTimeConnect(Timestamp dateTimeConnect) {
        this.dateTimeConnect = dateTimeConnect;
    }

    public float getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(float connectTime) {
        this.connectTime = connectTime;
    }
}
