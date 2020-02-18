package com.tabowa.rfid_app.model;

public class Election {

    private String registrationNumber;
    private String contestantName;
    private String position;
    private String electionDate;
    private String clearanceStatus;
    private String votingStatus;

    public Election(String registrationNumber, String contestantName, String position, String electionDate, String clearanceStatus, String votingStatus) {
        this.registrationNumber = registrationNumber;
        this.contestantName = contestantName;
        this.position = position;
        this.electionDate = electionDate;
        this.clearanceStatus = clearanceStatus;
        this.votingStatus = votingStatus;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getContestantName() {
        return contestantName;
    }

    public void setContestantName(String contestantName) {
        this.contestantName = contestantName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getElectionDate() {
        return electionDate;
    }

    public void setElectionDate(String electionDate) {
        this.electionDate = electionDate;
    }

    public String getClearanceStatus() {
        return clearanceStatus;
    }

    public void setClearanceStatus(String clearanceStatus) {
        this.clearanceStatus = clearanceStatus;
    }

    public String getVotingStatus() {
        return votingStatus;
    }

    public void setVotingStatus(String votingStatus) {
        this.votingStatus = votingStatus;
    }
}
