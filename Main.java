// Import the Scanner class from the java.util package to read user input from the console.
import java.util.Scanner;

/**
 * Main class for the Student Management System.
 * This class serves as the entry point for the application. It creates the user
 * interface in the console and handles user interaction.
 */
public class Main {

    /**
     * The main method, where the program execution begins.
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create an instance of StudentManager to handle all student-related operations.
        StudentManager manager = new StudentManager();
        // Create a Scanner object to read input from the standard input stream (keyboard).
        Scanner scanner = new Scanner(System.in);
        // Declare an integer variable 'choice' to store the user's menu selection.
        int choice;

        // Use a do-while loop to repeatedly display the menu and process user actions
        // until the user chooses to exit (by entering 7).
        do {
            // Display the menu options to the user.
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Show Statistics");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's choice as a line of text and parse it into an integer.
            // Using nextLine() followed by parsing helps prevent input scanner issues.
            choice = Integer.parseInt(scanner.nextLine());

            // A switch statement to execute code based on the user's choice.
            // This is a more efficient and readable alternative to multiple if-else statements.
            switch (choice) {
                case 1 -> manager.addStudent();      // If choice is 1, call the addStudent method.
                case 2 -> manager.viewStudents();    // If choice is 2, call the viewStudents method.
                case 3 -> manager.updateStudent();   // If choice is 3, call the updateStudent method.
                case 4 -> manager.deleteStudent();   // If choice is 4, call the deleteStudent method.
                case 5 -> manager.searchStudent();   // If choice is 5, call the searchStudent method.
                case 6 -> manager.showStatistics();  // If choice is 6, call the showStatistics method.
                case 7 -> System.out.println("Exiting program..."); // If choice is 7, print an exit message.
                default -> System.out.println("Invalid choice. Try again."); // If choice is anything else, inform the user.
            }

        } while (choice != 7); // The loop continues as long as the choice is not 7.
        scanner.close(); // Close the scanner to prevent resource leak
    }
}