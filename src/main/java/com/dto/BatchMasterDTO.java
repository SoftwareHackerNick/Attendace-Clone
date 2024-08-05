package com.dto;

public class BatchMasterDTO {
    private int bid;
    private String bname;
    private String sdate;
    private String edate;
    private int trainerId;
    private int courseId;

    // Default constructor
    public BatchMasterDTO() {
    }

    // Parameterized constructor
    public BatchMasterDTO(int bid, String bname, String sdate, String edate, int trainerId, int courseId) {
        this.bid = bid;
        this.bname = bname;
        this.sdate = sdate;
        this.edate = edate;
        this.trainerId = trainerId;
        this.courseId = courseId;
    }

    // Getters and setters
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
