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
public class VDI {

    private int vdiID;
    private int type;
    private String ip;
    private String knoxID;
    private int status;

    public VDI(int vdiID, int type, String ip, String knoxID, int status) {
        this.vdiID = vdiID;
        this.type = type;
        this.ip = ip;
        this.knoxID = knoxID;
        this.status = status;
    }

    public int getVdiID() {
        return vdiID;
    }

    public void setVdiID(int vdiID) {
        this.vdiID = vdiID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getKnoxID() {
        return knoxID;
    }

    public void setKnoxID(String knoxID) {
        this.knoxID = knoxID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
