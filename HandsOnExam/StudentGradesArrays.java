import java.util.Scanner;

public class StudentGradesArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        System.out.print("Enter the number of assignments: ");
        int numAssignments = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[][] grades = new double[numStudents][numAssignments];
        double[] averageScores = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.next();

            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter score for " + studentNames[i] + " in Assignment " + (j + 1) + ": ");
                grades[i][j] = scanner.nextDouble();
            }
        }

        for (int i = 0; i < numStudents; i++) {
            double total = 0;
            for (int j = 0; j < numAssignments; j++) {
                total += grades[i][j];
            }
            averageScores[i] = total / numAssignments;
        }

        System.out.println("\nStudent Report:");
        System.out.println("------------------------------------------------------------");
        System.out.println("Name\t\tAssignments\t\tAverage\t\tGrade");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < numStudents; i++) {
            System.out.print(studentNames[i] + "\t\t");

            for (int j = 0; j < numAssignments; j++) {
                System.out.print(grades[i][j] + "\t");
            }

            String letterGrade = calculateLetterGrade(averageScores[i]);
            System.out.println("\t" + averageScores[i] + "\t\t" + letterGrade);
        }

        double highestAvg = averageScores[0], lowestAvg = averageScores[0];
        String highestStudent = studentNames[0], lowestStudent = studentNames[0];

        for (int i = 1; i < numStudents; i++) {
            if (averageScores[i] > highestAvg) {
                highestAvg = averageScores[i];
                highestStudent = studentNames[i];
            }

            if (averageScores[i] < lowestAvg) {
                lowestAvg = averageScores[i];
                lowestStudent = studentNames[i];
            }
        }

        System.out.println("\nHighest Average: " + highestStudent + " with " + highestAvg);
        System.out.println("Lowest Average: " + lowestStudent + " with " + lowestAvg);

        sortByAverage(studentNames, grades, averageScores);

        System.out.println("\nSorted Student Report by Average Score:");
        System.out.println("------------------------------------------------------------");
        System.out.println("Name\t\tAssignments\t\tAverage\t\tGrade");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < numStudents; i++) {
            System.out.print(studentNames[i] + "\t\t");

            for (int j = 0; j < numAssignments; j++) {
                System.out.print(grades[i][j] + "\t");
            }

            String letterGrade = calculateLetterGrade(averageScores[i]);
            System.out.println("\t" + averageScores[i] + "\t\t" + letterGrade);
        }

        scanner.close();
    }

    public static String calculateLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void sortByAverage(String[] names, double[][] grades, double[] averages) {
        int n = averages.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (averages[j] < averages[j + 1]) {
               
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
           
                    double[] tempGrades = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrades;
                }
            }
        }
    }
}
