import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students in the class: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();  

        String[] names = new String[numStudents];
        double[][] scores = new double[numStudents][];
        double[] averages = new double[numStudents];
        char[] grades = new char[numStudents];

        double totalClassScore = 0;
        double highestScore = Double.MIN_VALUE;
        double lowestScore = Double.MAX_VALUE;

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter the name of student " + (i + 1) + ": ");
            names[i] = scanner.nextLine();

            System.out.print("Enter the number of assignments for " + names[i] + ": ");
            int numAssignments = scanner.nextInt();
            scores[i] = new double[numAssignments];

            double totalStudentScore = 0;
            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                while (true) {
                    try {
                        double score = scanner.nextDouble();
                        if (score >= 0 && score <= 100) {
                            scores[i][j] = score;
                            totalStudentScore += score;
                            break;
                        } else {
                            System.out.println("Score must be between 0 and 100. Please try again.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid score.");
                        scanner.next(); 
                    }
                }
            }

            double averageScore = totalStudentScore / numAssignments;
            averages[i] = averageScore;
            totalClassScore += averageScore;

            if (averageScore >= 90) {
                grades[i] = 'A';
            } else if (averageScore >= 80) {
                grades[i] = 'B';
            } else if (averageScore >= 70) {
                grades[i] = 'C';
            } else if (averageScore >= 60) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }

            if (averageScore > highestScore) {
                highestScore = averageScore;
            }
            if (averageScore < lowestScore) {
                lowestScore = averageScore;
            }

            scanner.nextLine();  
        }

        double classAverage = totalClassScore / numStudents;

        System.out.println("\nStudent Results:");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%s: Average Score = %.2f, Grade = %c\n", names[i], averages[i], grades[i]);
        }

        System.out.printf("\nClass Average Score: %.2f\n", classAverage);
        System.out.printf("Highest Average Score: %.2f\n", highestScore);
        System.out.printf("Lowest Average Score: %.2f\n", lowestScore);

        scanner.close();
    }
}