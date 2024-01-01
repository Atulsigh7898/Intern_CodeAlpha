import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        ArrayList<Integer> grades = new ArrayList<>();

        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Enter grade for student " + i + ": ");
            int grade = scanner.nextInt();

            grades.add(grade);
        }

        if (!grades.isEmpty()) {
            double average = calculateAverage(grades);
            int highest = findHighest(grades);
            int lowest = findLowest(grades);

            System.out.println("\nAverage Score: " + average);
            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);
        } else {
            System.out.println("No grades entered.");
        }

        scanner.close();
    }
    private static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
    private static int findHighest(ArrayList<Integer> grades) {
        return Collections.max(grades);
    }
    private static int findLowest(ArrayList<Integer> grades) {
        return Collections.min(grades);
    }
}