// Import necessary classes from the java.util package.
// HashMap is used for efficient key-value storage of students.
// Map is the interface that HashMap implements.
// Scanner is for reading user input.
import java.util.*;

/**
 * Manages all student-related operations (CRUD, search, statistics).
 * This class contains the business logic for the application. It handles the
 * collection of students and provides methods to interact with that collection.
 */
public class StudentManager {
    // A Map to store Student objects. The key is the student's ID (String),
    // and the value is the Student object itself. Using a HashMap provides
    // fast lookup, insertion, and deletion based on the student ID.
    private Map<String, Student> students = new HashMap<>();
    // A Scanner object to read input within the manager's methods.
    private Scanner scanner = new Scanner(System.in);

    /**
     * Adds a new student to the system.
     * It prompts the user for student details, validates the ID for uniqueness,
     * creates a new Student object, and adds it to the map.
     */
    public void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        // Check if a student with this ID already exists to ensure uniqueness.
        if (students.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return; // Exit the method if ID is not unique.
        }

        // Prompt for and read the rest of the student details.
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Branch: ");
        String branch = scanner.nextLine();
        System.out.print("Enter Year: ");
        // Parse the string input to an integer for the year.
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Marks: ");
        // Parse the string input to a double for the marks.
        double marks = Double.parseDouble(scanner.nextLine());

        // Create a new Student object with the collected data.
        Student student = new Student(id, name, branch, year, marks);
        // Add the new student to the map with their ID as the key.
        students.put(id, student);
        System.out.println("Student added successfully.");
    }

    /**
     * Displays the details of all students currently in the system.
     */
    public void viewStudents() {
        // First, check if the student map is empty.
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            // If not empty, iterate through the values (Student objects) of the map
            // and print each one. The custom toString() method in the Student class is called automatically.
            for (Student s : students.values()) {
                System.out.println(s);
            }
        }
    }

    /**
     * Updates the details of an existing student.
     * It asks for the student's ID, finds the student, and then prompts for the new information.
     */
    public void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        // Check if the student exists before attempting to update.
        if (!students.containsKey(id)) {
            System.out.println("Student not found.");
            return; // Exit method if student doesn't exist.
        }

        // Retrieve the existing student object from the map.
        Student student = students.get(id);
        // Prompt the user for the new details and update the student object using its setters.
        while(true){
            System.out.println("Choose what to update");
            System.out.println("1. Name");
            System.out.println("2. Branch");
            System.out.println("3. Year");
            System.out.println("4. Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int updateChoice=Integer.parseInt(scanner.nextLine());
            switch (updateChoice) {
                case 1 -> {
                    System.out.print("Enter New Name: ");
                    student.setName(scanner.nextLine());
                }
                case 2 -> {
                    System.out.print("Enter New Branch: ");
                    student.setBranch(scanner.nextLine());
                }
                case 3 -> {
                    System.out.print("Enter New Year: ");
                    student.setYear(Integer.parseInt(scanner.nextLine()));
                }
                case 4 -> {
                    System.out.print("Enter New Marks: ");
                    student.setMarks(Double.parseDouble(scanner.nextLine()));
                }
                case 5 -> {
                    System.out.println("Exiting update menu.");
                    return; // Exit the update menu.
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Deletes a student from the system based on their ID.
     */
    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        // The remove() method of HashMap returns the value associated with the key if it exists,
        // or null otherwise. This is a concise way to check if the deletion was successful.
        if (students.remove(id) != null) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    /**
     * Searches for a student by either their ID or name.
     */
    public void searchStudent() {
        System.out.print("Enter Student ID or Name to search: ");
        String input = scanner.nextLine();
        boolean found = false; // A flag to track if any match is found.

        // Iterate through all students in the map.
        for (Student student : students.values()) {
            // Check if the input matches the student's ID or name (case-insensitive).
            if (student.getStudentId().equalsIgnoreCase(input) ||
                student.getName().equalsIgnoreCase(input)) {
                System.out.println(student); // Print the details of the found student.
                found = true; // Set flag to true.
            }
        }
        // If after checking all students, no match was found, inform the user.
        if (!found) System.out.println("Student not found.");
    }

    /**
     * Calculates and displays statistics like average marks and the top scorer.
     */
    public void showStatistics() {
        // Check if there are any students to generate statistics from.
        if (students.isEmpty()) {
            System.out.println("No data for statistics.");
            return;
        }

        double totalMarks = 0;
        // Initialize maxMarks with the smallest possible double value to ensure the first student's marks are higher.
        double maxMarks = Double.MIN_VALUE;
        String topScorer = "";

        // Iterate through all students to perform calculations.
        for (Student student : students.values()) {
            // Add the current student's marks to the total.
            totalMarks += student.getMarks();
            // Check if the current student's marks are higher than the current max.
            if (student.getMarks() > maxMarks) {
                maxMarks = student.getMarks();      // Update the max marks.
                topScorer = student.getName(); // Update the name of the top scorer.
            }
        }

        // Calculate the average by dividing the total marks by the number of students.
        double averageMarks = totalMarks / students.size();
        System.out.println("Average Marks: " + averageMarks);
        System.out.println("Top Scorer: " + topScorer + " (with " + maxMarks + " marks)");
    }
    
}
