package com.onboarding;

import com.onboarding.exception.InvalidAssessmentException;
import com.onboarding.model.Candidate;
import com.onboarding.service.AssessmentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AssessmentService service = new AssessmentService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=================================================");
        System.out.println("  CANDIDATE ASSESSMENT & ONBOARDING SYSTEM");
        System.out.println("=================================================");

        while (running) {
            System.out.println("\n1. Register Candidate");
            System.out.println("2. Record Assessment Score");
            System.out.println("3. View Shortlisted Candidates");
            System.out.println("4. View All Applications");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Candidate ID (e.g., C101): ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Primary Skill (Java/SQL/Web): ");
                    String skill = scanner.nextLine();

                    service.registerCandidate(
                            new Candidate(id, name, email, skill)
                    );
                    break;

                case 2:
                    System.out.print("Enter Candidate ID: ");
                    String cId = scanner.nextLine();
                    System.out.print("Enter Score (0-100): ");
                    int score = scanner.nextInt();

                    try {
                        service.recordScore(cId, score);
                    } catch (InvalidAssessmentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\n--- Shortlisted Candidates (Leaderboard) ---");
                    service.getShortlistedCandidates().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("\n--- All Registered Candidates ---");
                    service.getAllCandidates().forEach(System.out::println);
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting system. Data persisted.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
