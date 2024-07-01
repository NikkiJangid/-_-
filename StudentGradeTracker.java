import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        double numberOfStudents = scanner.nextDouble();

        for (double i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            grades.add(grade);
        }

        if (grades.size() > 0) {
        	System.out.println("-------------------------------------------");
            System.out.println("Average grade: " + calculateAverage(grades));
            System.out.println("Highest grade: " + calculateHighest(grades));
            System.out.println("Lowest grade: " + calculateLowest(grades));
        } else {
            System.out.println("No grades were entered.");
        }
        
        scanner.close();
    }
    
    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
    
    private static double calculateHighest(ArrayList<Double> grades) {
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }
    
    private static double calculateLowest(ArrayList<Double> grades) {
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}

