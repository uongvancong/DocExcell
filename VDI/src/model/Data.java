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
public class Data {

    private String no;
    private String name;
    private String company;
    private String projectName;
    private String knoxID;
    private String ipDEV;
    private String ipOPER;
    private String placeOfWork;
    private String partName;
    private String remark1;
    private String connectGDCVDI;
    private String connectionTime;
    private String connectionStatus;
    private String remark2;
    private String issue;
    

    public Data(String no, String name, String company, String projectName, String knoxID, String ipDEV, String ipOPER, String placeOfWork, String partName, String remark1, String connectGDCVDI, String connectionTime, String connectionStatus, String remark2, String issue ) {
        this.no = no;
        this.name = name;
        this.company = company;
        this.projectName = projectName;
        this.knoxID = knoxID;
        this.ipDEV = ipDEV;
        this.ipOPER = ipOPER;
        this.placeOfWork = placeOfWork;
        this.partName = partName;
        this.remark1 = remark1;
        this.connectGDCVDI = connectGDCVDI;
        this.connectionTime = connectionTime;
        this.connectionStatus = connectionStatus;
        this.remark2 = remark2;
        this.issue = issue;
        
    }

    public Data() {

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getKnoxID() {
        return knoxID;
    }

    public void setKnoxID(String knoxID) {
        this.knoxID = knoxID;
    }

    public String getIpDEV() {
        return ipDEV;
    }

    public void setIpDEV(String ipDEV) {
        this.ipDEV = ipDEV;
    }

    public String getIpOPER() {
        return ipOPER;
    }

    public void setIpOPER(String ipOPER) {
        this.ipOPER = ipOPER;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getConnectGDCVDI() {
        return connectGDCVDI;
    }

    public void setConnectGDCVDI(String connectGDCVDI) {
        this.connectGDCVDI = connectGDCVDI;
    }

    public String getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(String connectionTime) {
        this.connectionTime = connectionTime;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    

    @Override
    public String toString() {

        return this.no + ", " + this.name + ", " + this.company + ", " + this.projectName + ", " + this.knoxID + ", "
                + this.ipDEV + ", " + this.ipOPER + ", " + this.placeOfWork + ", " + this.partName + ", " + this.remark1
                + ", " + this.connectGDCVDI + ", " + this.connectionTime + ", " + this.connectionStatus + ", "
                + this.remark2 + ", " + this.issue;
    }

    
}
