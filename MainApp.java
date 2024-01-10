import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AttendanceManager attendanceManager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);

        // Adding sample students
        Student student1 = new Student("1", "John Doe");
        Student student2 = new Student("2", "Jane Smith");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Is the student present? (true/false): ");
                    boolean present = scanner.nextBoolean();

                    Student selectedStudent = null;
                    if (studentId.equals(student1.getStudentId())) {
                        selectedStudent = student1;
                    } else if (studentId.equals(student2.getStudentId())) {
                        selectedStudent = student2;
                    } else {
                        System.out.println("Student not found.");
                        continue;
                    }

                    attendanceManager.markAttendance(selectedStudent, present);
                    break;

                case 2:
                    attendanceManager.printAttendanceReport();
                    break;

                case 3:
                    isRunning = false;
                    System.out.println("Exiting Attendance System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

