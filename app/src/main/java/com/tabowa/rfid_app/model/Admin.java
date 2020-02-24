package com.tabowa.rfid_app.model;

public class Admin {

    private int id;
    private String regNo;
    private String program;
    private String category;
    private String session;
    private String datePayment;
    private String modeOfPayment;
    private String amountPaid;
    private String purposePayment;

    public Admin(int id, String regNo, String program, String category, String session, String datePayment, String modeOfPayment, String amountPaid, String purposePayment) {
        this.id = id;
        this.regNo = regNo;
        this.program = program;
        this.category = category;
        this.session = session;
        this.datePayment = datePayment;
        this.modeOfPayment = modeOfPayment;
        this.amountPaid = amountPaid;
        this.purposePayment = purposePayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPurposePayment() {
        return purposePayment;
    }

    public void setPurposePayment(String purposePayment) {
        this.purposePayment = purposePayment;
    }
}