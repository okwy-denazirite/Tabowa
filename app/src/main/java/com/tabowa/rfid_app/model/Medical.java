package com.tabowa.rfid_app.model;

public class Medical {

    private int id;

    private String medicalCardNumber;
    private String bloodGroup;
    private String condition;
    private String allergy;
    private String medicalHistory;
    private String attendantDoctor;
    private String attendantDoctorPhone;

    public Medical(int id, String medicalCardNumber, String bloodGroup, String condition, String allergy, String medicalHistory, String attendantDoctor, String attendantDoctorPhone) {
        this.id = id;
        this.medicalCardNumber = medicalCardNumber;
        this.bloodGroup = bloodGroup;
        this.condition = condition;
        this.allergy = allergy;
        this.medicalHistory = medicalHistory;
        this.attendantDoctor = attendantDoctor;
        this.attendantDoctorPhone = attendantDoctorPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setMedicalCardNumber(String medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAttendantDoctor() {
        return attendantDoctor;
    }

    public void setAttendantDoctor(String attendantDoctor) {
        this.attendantDoctor = attendantDoctor;
    }

    public String getAttendantDoctorPhone() {
        return attendantDoctorPhone;
    }

    public void setAttendantDoctorPhone(String attendantDoctorPhone) {
        this.attendantDoctorPhone = attendantDoctorPhone;
    }
}
