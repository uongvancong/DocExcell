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
public class Department {

    private int partID;
    private String name;
    private int partLeader;

    public Department(int partID, String name, int partLeader) {
        this.partID = partID;
        this.name = name;
        this.partLeader = partLeader;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartLeader() {
        return partLeader;
    }

    public void setPartLeader(int partLeader) {
        this.partLeader = partLeader;
    }
    
}
