/**
 * The Teacher class contains FirstName, LastName and Subject fields
 */
public class Teacher {
    private String fName;
    private String lName;
    private String subject;

    /**
     * The constructor for Teacher
     *
     * @param fName First Name
     * @param lName Last Name
     * @param subject The Subject
     */
    Teacher(String fName, String lName, String subject) {
        this.fName = fName;
        this.lName = lName;
        this.subject = subject;
    }

    /**
     * Prints the Info of the teacher in format:
     *
     * [Name]
     * [Subject]
     */
    public void printInfo() {
        System.out.println("Name: " + fName + " " + lName + "\n" +
                "Subject: " + subject + "\n");
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
