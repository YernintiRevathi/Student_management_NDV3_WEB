/**
 * Represents a Student entity.
 * This class is a Plain Old Java Object (POJO) or a model class that holds the data for a single student.
 * It encapsulates the student's attributes and provides methods to access and modify them.
 */
public class Student {
    // Private attributes to store student information.
    // They are private to ensure encapsulation, meaning they can only be accessed
    // through the public methods (getters and setters) of this class.
    private String studentId;
    private String name;
    private String branch;
    private int year;
    private double marks;

    /**
     * Constructor for the Student class.
     * It is used to create a new Student object and initialize its attributes with the provided values.
     *
     * @param studentId The unique identifier for the student.
     * @param name      The name of the student.
     * @param branch    The academic branch of the student (e.g., "Computer Science").
     * @param year      The current academic year of the student.
     * @param marks     The marks obtained by the student.
     */
    public Student(String studentId, String name, String branch, int year, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.branch = branch;
        this.year = year;
        this.marks = marks;
    }

    // --- Getters and Setters ---
    // Getters are methods used to retrieve the value of a private attribute.
    // Setters are methods used to change the value of a private attribute.

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getBranch() { return branch; }
    public int getYear() { return year; }
    public double getMarks() { return marks; }

    // Note: The studentId is typically not changed, so it doesn't have a setter.
    public void setName(String name) { this.name = name; }
    public void setBranch(String branch) { this.branch = branch; }
    public void setYear(int year) { this.year = year; }
    public void setMarks(double marks) { this.marks = marks; }

    /**
     * Overrides the default toString() method from the Object class.
     * This provides a custom, human-readable string representation of a Student object,
     * which is very useful for printing the object's details to the console.
     *
     * @return A formatted string containing the student's details.
     */
    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Branch: " + branch +
               ", Year: " + year + ", Marks: " + marks;
    }
}