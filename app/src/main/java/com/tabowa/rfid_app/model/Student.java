package com.tabowa.rfid_app.model;

import android.net.Uri;

public class Student {
    private int id;
    private Uri photo;
    private String name;
    private String registrationNumber;
    private String phone;
    private String email;
    private String department;
    private String school;
    private String program;
    private String category;
    private String session;
    private String bloodGroup;
    private String noK;
    private String noKAddr;
    private String noKPhone;
    private String state;
    private String lGA;
    private String homeTown;
    private String healthCardNo;
    private String doB;
    private String expiryDate;
    private String gender;
    private long   niN;
    private String medicalCardNo;
    private String thumbPrint;



//    public Student(int id, String name, long registrationNumber, String phone, String email) {
//        this.id = id;
//        this.name = name;
//        this.registrationNumber = registrationNumber;
//        this.phone = phone;
//        this.email = email;
//    }



    public Student(int id, Uri photo, String name, String registrationNumber, String phone, String email, String department, String school, String program, String category, String session, String bloodGroup, String noK, String noKAddr, String noKPhone, String state, String lGA, String homeTown, String healthCardNo, String doB, String expiryDate, String gender, long niN, String medicalCardNo, String thumbPrint) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.phone = phone;
        this.email = email;
        this.department = department;
        this.school = school;
        this.program = program;
        this.category = category;
        this.session = session;
        this.bloodGroup = bloodGroup;
        this.noK = noK;
        this.noKAddr = noKAddr;
        this.noKPhone = noKPhone;
        this.state = state;
        this.lGA = lGA;
        this.homeTown = homeTown;
        this.healthCardNo = healthCardNo;
        this.doB = doB;
        this.expiryDate = expiryDate;
        this.gender = gender;
        this.niN = niN;
        this.medicalCardNo = medicalCardNo;
        this.thumbPrint = thumbPrint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getNoK() {
        return noK;
    }

    public void setNoK(String noK) {
        this.noK = noK;
    }

    public String getNoKAddr() {
        return noKAddr;
    }

    public void setNoKAddr(String noKAddr) {
        this.noKAddr = noKAddr;
    }

    public String getNoKPhone() {
        return noKPhone;
    }

    public void setNoKPhone(String noKPhone) {
        this.noKPhone = noKPhone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getlGA() {
        return lGA;
    }

    public void setlGA(String lGA) {
        this.lGA = lGA;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getNiN() {
        return niN;
    }

    public void setNiN(long niN) {
        this.niN = niN;
    }

    public String getMedicalCardNo() {
        return medicalCardNo;
    }

    public void setMedicalCardNo(String medicalCardNo) {
        this.medicalCardNo = medicalCardNo;
    }

    public String getThumbPrint() {
        return thumbPrint;
    }

    public void setThumbPrint(String thumbPrint) {
        this.thumbPrint = thumbPrint;
    }
}
