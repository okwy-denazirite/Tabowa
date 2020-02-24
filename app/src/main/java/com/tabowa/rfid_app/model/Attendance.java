package com.tabowa.rfid_app.model;

public class Attendance {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String registrationNumber;
    private String program;
    private String ctergory;
    private String session;
    private String semester;
    private String courseTitle;
    private String courseCode;
    private String attendace;
    private String dateAttendance;

    public Attendance(int id, String registrationNumber, String program, String ctergory, String session, String semester, String courseTitle, String courseCode, String attendace, String dateAttendance) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.program = program;
        this.ctergory = ctergory;
        this.session = session;
        this.semester = semester;
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.attendace = attendace;
        this.dateAttendance = dateAttendance;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCtergory() {
        return ctergory;
    }

    public void setCtergory(String ctergory) {
        this.ctergory = ctergory;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getAttendace() {
        return attendace;
    }

    public void setAttendace(String attendace) {
        this.attendace = attendace;
    }

    public String getDateAttendance() {
        return dateAttendance;
    }

    public void setDateAttendance(String dateAttendance) {
        this.dateAttendance = dateAttendance;
    }
}
