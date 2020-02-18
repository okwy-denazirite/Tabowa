package com.tabowa.rfid_app.model;

public class Grade {

    private String gradeRegno;
    private String program;
    private String category;
    private String session;
    private String semester;
    private String cousrseTitle;
    private String courseCode;
    private String units;
    private String class_attendance;
    private String score;
    private String examination;
    private String total;
    private String grade;

    public Grade(String gradeRegno, String program, String category, String session, String semester, String cousrseTitle, String courseCode, String units, String class_attendance, String score, String examination, String total, String grade) {
        this.gradeRegno = gradeRegno;
        this.program = program;
        this.category = category;
        this.session = session;
        this.semester = semester;
        this.cousrseTitle = cousrseTitle;
        this.courseCode = courseCode;
        this.units = units;
        this.class_attendance = class_attendance;
        this.score = score;
        this.examination = examination;
        this.total = total;
        this.grade = grade;
    }

    public String getGradeRegno() {
        return gradeRegno;
    }

    public void setGradeRegno(String gradeRegno) {
        this.gradeRegno = gradeRegno;
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

    public String getCousrseTitle() {
        return cousrseTitle;
    }

    public void setCousrseTitle(String cousrseTitle) {
        this.cousrseTitle = cousrseTitle;
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

    public String getClass_attendance() {
        return class_attendance;
    }

    public void setClass_attendance(String class_attendance) {
        this.class_attendance = class_attendance;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
