public class Student {
    private static int count = 1;

    private String fName;
    private String lName;
    private int grade;
    private int id = count;

    Student(String fName, String lName, int grade) {
        this.fName = fName;
        this.lName = lName;
        this.grade = grade;
        count++;
    }

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
