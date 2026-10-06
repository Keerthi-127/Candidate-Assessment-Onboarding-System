# Candidate Assessment & Onboarding System

A console-based Java application designed to manage candidate registration, assessment scores, automatic shortlisting, and candidate records using Core Java concepts.

## 📌 Project Overview

The **Candidate Assessment & Onboarding System** helps organizations manage candidates during the recruitment and assessment process.

The system allows users to:

* Register new candidates
* Store candidate information
* Record assessment scores
* Automatically shortlist candidates based on their score
* Reject candidates who do not meet the required score
* View shortlisted candidates as a leaderboard
* View all registered candidates
* Persist candidate data using file handling

## 🛠️ Technologies Used

* **Java 24.0.1**
* Core Java
* Object-Oriented Programming (OOP)
* Java Collections
* HashMap
* ArrayList
* File I/O
* Serialization
* Custom Exception Handling
* Java Streams
* Comparator
* Console-based user interface

## 🧠 Java Concepts Demonstrated

### 1. Encapsulation

Candidate information is stored using private variables with public getter and setter methods.

### 2. Collections

A `HashMap` is used to store candidates using their unique Candidate ID.

```java
Map<String, Candidate> candidateMap = new HashMap<>();
```

### 3. Custom Exception Handling

The application uses a custom exception:

```text
InvalidAssessmentException
```

It handles invalid candidate IDs and assessment scores.

### 4. File I/O and Persistence

Candidate records are stored in:

```text
candidates.dat
```

Java serialization is used to save and load candidate data.

### 5. Java Streams

Streams are used to filter and sort shortlisted candidates based on their assessment scores.

### 6. OOP Principles

The project demonstrates:

* Classes and Objects
* Encapsulation
* Abstraction of business logic into a service layer
* Separation of Model, Service, Exception, and Application layers

## 📂 Project Structure

```text
CandidateAssessmentOnboardingSystem/
│
├── src/
│   └── com/
│       └── onboarding/
│           │
│           ├── Main.java
│           │
│           ├── model/
│           │   └── Candidate.java
│           │
│           ├── exception/
│           │   └── InvalidAssessmentException.java
│           │
│           └── service/
│               └── AssessmentService.java
│
├── out/
│   └── Compiled .class files
│
├── candidates.dat
│   └── Automatically generated persistent data file
│
└── README.md
```

## ⚙️ Requirements

Before running the project, make sure you have:

* Java JDK 8 or later
* VS Code (recommended)
* Java Extension Pack for VS Code (recommended)

This project was tested with:

```text
Java 24.0.1
```

Check your Java version using:

```powershell
java -version
```

Check the Java compiler using:

```powershell
javac -version
```

## ▶️ How to Run

### Step 1: Open the Project

Extract the project ZIP and open the following folder in VS Code:

```text
CandidateAssessmentOnboardingSystem
```

### Step 2: Open Terminal

In VS Code, select:

```text
Terminal → New Terminal
```

### Step 3: Compile the Project

Run:

```powershell
javac -d out src/com/onboarding/model/Candidate.java src/com/onboarding/exception/InvalidAssessmentException.java src/com/onboarding/service/AssessmentService.java src/com/onboarding/Main.java
```

### Step 4: Run the Application

Run:

```powershell
java -cp out com.onboarding.Main
```

## 🖥️ Application Menu

When the application starts, the following menu is displayed:

```text
=================================================
  CANDIDATE ASSESSMENT & ONBOARDING SYSTEM
=================================================

1. Register Candidate
2. Record Assessment Score
3. View Shortlisted Candidates
4. View All Applications
5. Exit
Select an option:
```

## 📝 Example Usage

### Register Candidate

Select:

```text
1
```

Enter:

```text
Candidate ID: C101
Name: Anu
Email: anu@gmail.com
Primary Skill: Java
```

The system displays:

```text
Candidate registered successfully! ID: C101
```

### Record Assessment Score

Select:

```text
2
```

Enter:

```text
Candidate ID: C101
Score: 85
```

Since the score is greater than or equal to **70**, the candidate is automatically shortlisted.

```text
Score updated! Status: SHORTLISTED
```

If the score is below 70:

```text
Score updated! Status: REJECTED
```

### View Shortlisted Candidates

Select:

```text
3
```

The shortlisted candidates are displayed in descending order of their assessment score.

Example:

```text
--- Shortlisted Candidates (Leaderboard) ---

ID: C101     | Name: Anu             | Skill: Java      | Score: 85  | Status: SHORTLISTED
ID: C102     | Name: Priya           | Skill: SQL       | Score: 78  | Status: SHORTLISTED
```

### View All Applications

Select:

```text
4
```

This displays all registered candidates, including shortlisted and rejected candidates.

## 🔐 Validation & Exception Handling

The application validates assessment scores.

Valid range:

```text
0 - 100
```

For example, if the user enters:

```text
120
```

the application displays:

```text
Error: Score must be between 0 and 100.
```

If an invalid Candidate ID is entered:

```text
Error: Candidate ID C999 not found.
```

## 💾 Data Persistence

The application automatically saves candidate information to:

```text
candidates.dat
```

The file is created automatically when candidate data is registered or updated.

When the application is started again, previously saved candidate records are loaded automatically.

## 🎯 Shortlisting Logic

The project uses a simple assessment benchmark:

| Assessment Score | Status      |
| ---------------: | ----------- |
|         70 – 100 | SHORTLISTED |
|           0 – 69 | REJECTED    |

This logic is implemented in the `recordScore()` method.

## 🏗️ Architecture

The project follows a simple layered structure:

```text
             Main.java
                 │
                 ▼
       AssessmentService
                 │
        ┌────────┴────────┐
        ▼                 ▼
   Candidate       Exception Handling
        │
        ▼
 candidates.dat
```

### Model Layer

Contains candidate data and related methods.

```text
Candidate.java
```

### Service Layer

Contains recruitment and assessment business logic.

```text
AssessmentService.java
```

### Exception Layer

Contains custom application exceptions.

```text
InvalidAssessmentException.java
```

### Application Layer

Contains the main console application.

```text
Main.java
```

## 🚀 Future Enhancements

The application can be extended with:

* Candidate login
* Admin login
* Resume upload
* Multiple assessment rounds
* Interview scheduling
* Email notifications
* Database integration using MySQL
* REST API using Spring Boot
* Web-based frontend
* Advanced candidate search and filtering
* Role-based access control
* Candidate onboarding workflow

## 👩‍💻 Author

**Candidate Assessment & Onboarding System**

Built using Core Java and Object-Oriented Programming concepts as a console-based recruitment management project.

## 📄 License

This project is created for educational, learning, and portfolio purposes.
