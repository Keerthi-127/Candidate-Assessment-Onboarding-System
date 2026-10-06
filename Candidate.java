package com.onboarding.model;

import java.io.Serializable;

public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String candidateId;
    private String name;
    private String email;
    private String primarySkill;
    private int assessmentScore;
    private String status;

    public Candidate(String candidateId, String name, String email, String primarySkill) {
        this.candidateId = candidateId;
        this.name = name;
        this.email = email;
        this.primarySkill = primarySkill;
        this.assessmentScore = 0;
        this.status = "APPLIED";
    }

    public String getCandidateId() { return candidateId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPrimarySkill() { return primarySkill; }
    public int getAssessmentScore() { return assessmentScore; }
    public void setAssessmentScore(int assessmentScore) { this.assessmentScore = assessmentScore; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Name: %-15s | Skill: %-10s | Score: %-3d | Status: %s",
                candidateId, name, primarySkill, assessmentScore, status);
    }
}
