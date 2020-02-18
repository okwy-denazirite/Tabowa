package com.tabowa.rfid_app.model;

public class Course {

    private int id;
    private String regNo;
    private String program;
    private String category;
    private String session;
    private String semester;
    private String courseTitle;
    private String courseCode;
    private String units;

    public Course(int id, String regNo, String program, String category, String session, String semester, String courseTitle, String courseCode, String units) {
        this.id = id;
        this.regNo = regNo;
        this.program = program;
        this.category = category;
        this.session = session;
        this.semester = semester;
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.units = units;
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

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
