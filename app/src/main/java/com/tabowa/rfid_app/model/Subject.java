package com.tabowa.rfid_app.model;

public class Subject {
    private int id;
    private String name;
    private String code;
    private double credit;

    public Subject(int id, String name, String code, double credit) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
