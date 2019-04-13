package com.face.entity;

public class Face {
    private Integer id;

    private String faceid;

    private String readyone;

    private String readytwo;

    private String readythree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFaceid() {
        return faceid;
    }

    public void setFaceid(String faceid) {
        this.faceid = faceid == null ? null : faceid.trim();
    }

    public String getReadyone() {
        return readyone;
    }

    public void setReadyone(String readyone) {
        this.readyone = readyone == null ? null : readyone.trim();
    }

    public String getReadytwo() {
        return readytwo;
    }

    public void setReadytwo(String readytwo) {
        this.readytwo = readytwo == null ? null : readytwo.trim();
    }

    public String getReadythree() {
        return readythree;
    }

    public void setReadythree(String readythree) {
        this.readythree = readythree == null ? null : readythree.trim();
    }
}