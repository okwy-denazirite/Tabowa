package com.tabowa.rfid_app.model;

public class Security {
    private int id;
    private String wanted;
    private String wantedDate;
    private String acquitted;
    private String close_investigationDate;
    private String crimeName;
    private String num_registerdOffences;
    private String listOfCrimes;
    private String dateOfArrest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Security(int id, String wanted, String wantedDate, String acquitted, String close_investigationDate, String crimeName, String num_registerdOffences, String listOfCrimes, String dateOfArrest) {
        this.id = id;
        this.wanted = wanted;
        this.wantedDate = wantedDate;
        this.acquitted = acquitted;
        this.close_investigationDate = close_investigationDate;
        this.crimeName = crimeName;
        this.num_registerdOffences = num_registerdOffences;
        this.listOfCrimes = listOfCrimes;
        this.dateOfArrest = dateOfArrest;
    }

    public String getWanted() {
        return wanted;
    }

    public void setWanted(String wanted) {
        this.wanted = wanted;
    }

    public String getWantedDate() {
        return wantedDate;
    }

    public void setWantedDate(String wantedDate) {
        this.wantedDate = wantedDate;
    }

    public String getAcquitted() {
        return acquitted;
    }

    public void setAcquitted(String acquitted) {
        this.acquitted = acquitted;
    }

    public String getClose_investigationDate() {
        return close_investigationDate;
    }

    public void setClose_investigationDate(String close_investigationDate) {
        this.close_investigationDate = close_investigationDate;
    }

    public String getCrimeName() {
        return crimeName;
    }

    public void setCrimeName(String crimeName) {
        this.crimeName = crimeName;
    }

    public String getNum_registerdOffences() {
        return num_registerdOffences;
    }

    public void setNum_registerdOffences(String num_registerdOffences) {
        this.num_registerdOffences = num_registerdOffences;
    }

    public String getListOfCrimes() {
        return listOfCrimes;
    }

    public void setListOfCrimes(String listOfCrimes) {
        this.listOfCrimes = listOfCrimes;
    }

    public String getDateOfArrest() {
        return dateOfArrest;
    }

    public void setDateOfArrest(String dateOfArrest) {
        this.dateOfArrest = dateOfArrest;
    }
}
