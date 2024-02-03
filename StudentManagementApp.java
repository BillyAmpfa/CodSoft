import java.util.Scanner;

public class StudentManagementApp {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem sms = new StudentManagementSystem();

    public static void main(String[] args) {
		System.out.println("\t\tWelcome To Ampfa's Student Management System");
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            handleUserChoice(choice);
        }
    }

    private static void displayMenu() {
        System.out.println("\n\n1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Save to File");
        System.out.println("6. Load from File");
        System.out.println("7. Exit");
    }

    private static void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                // Add Student
                addStudent();
                break;
            case 2:
                // Remove Student
                removeStudent();
                break;
            case 3:
                // Search Student
                searchStudent();
                break;
            case 4:
                // Display All Students
                sms.displayAllStudents();
                break;
            case 5:
                // Save to File
                saveToFile();
                break;
            case 6:
                // Load from File
                loadFromFile();
                break;
            case 7:
                // Exit
                System.out.println("Exiting Student Management System.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
        }
    }

    private static void addStudent() {
        
        String name = getStringInput("Enter name: ");

        int rollNumber = getIntInput("Enter roll number: ");

       
        String grade = getStringInput("Enter grade: ");

        Student newStudent = new Student(name, rollNumber, grade);
        sms.addStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        int rollNumber = getIntInput("Enter roll number to remove: ");
        sms.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }

    private static void searchStudent() {
        int rollNumber = getIntInput("Enter roll number to search: ");
        Student foundStudent = sms.searchStudent(rollNumber);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void saveToFile() {
        String fileName = getStringInput("Enter file name to save: ");
        sms.saveToFile(fileName);
    }

    private static void loadFromFile() {
        String fileName = getStringInput("Enter file name to load: ");
        sms.loadFromFile(fileName);
    }

    private static int getIntInput(String prompt) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return input;
    }

    private static String getStringInput(String prompt) {
        String input;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());

        return input;
    }
}
