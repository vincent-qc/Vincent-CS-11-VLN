/**
 * The Student class contains FirstName, LastName, Grade and ID fields
 */
public class Student {
    // Initialize a counter for the IDs
    private static int count = 1;

    private String fName;
    private String lName;
    private int grade;
    private int id = count; // Assign their ID to the current count

    /**
     * The Constructor for Student
     *
     * @param fName First Name
     * @param lName Last Name
     * @param grade Their Grade
     */
    Student(String fName, String lName, int grade) {
        this.fName = fName;
        this.lName = lName;
        this.grade = grade;
        count++;
    }

    /**
     * Prints the student's info in the format:
     *
     * [Name]
     * [Grade]
     */
    public void printInfo() {
        System.out.println("Name: " + fName + " " + lName + "\n" +
                "Grade: " + grade + "\n");
    }

    // Getters and Setters

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
