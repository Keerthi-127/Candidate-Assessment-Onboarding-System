package com.onboarding.service;

import com.onboarding.exception.InvalidAssessmentException;
import com.onboarding.model.Candidate;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AssessmentService {
    private Map<String, Candidate> candidateMap = new HashMap<>();
    private static final String DATA_FILE = "candidates.dat";

    @SuppressWarnings("unchecked")
    public AssessmentService() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                candidateMap = (Map<String, Candidate>) ois.readObject();
            } catch (Exception e) {
                System.err.println("Warning: Could not load candidate records. Starting fresh.");
            }
        }
    }

    public void registerCandidate(Candidate candidate) {
        candidateMap.put(candidate.getCandidateId(), candidate);
        saveData();
        System.out.println("Candidate registered successfully! ID: " + candidate.getCandidateId());
    }

    public void recordScore(String candidateId, int score) throws InvalidAssessmentException {
        Candidate candidate = candidateMap.get(candidateId);

        if (candidate == null) {
            throw new InvalidAssessmentException("Candidate ID " + candidateId + " not found.");
        }

        if (score < 0 || score > 100) {
            throw new InvalidAssessmentException("Score must be between 0 and 100.");
        }

        candidate.setAssessmentScore(score);

        if (score >= 70) {
            candidate.setStatus("SHORTLISTED");
        } else {
            candidate.setStatus("REJECTED");
        }

        saveData();
        System.out.println("Score updated! Status: " + candidate.getStatus());
    }

    public List<Candidate> getShortlistedCandidates() {
        return candidateMap.values().stream()
                .filter(c -> "SHORTLISTED".equalsIgnoreCase(c.getStatus()))
                .sorted(Comparator.comparingInt(Candidate::getAssessmentScore).reversed())
                .collect(Collectors.toList());
    }

    public List<Candidate> getAllCandidates() {
        return new ArrayList<>(candidateMap.values());
    }

    private void saveData() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(candidateMap);
        } catch (IOException e) {
            System.err.println("Error persisting data: " + e.getMessage());
        }
    }
}
