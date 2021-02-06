import java.util.ArrayList;

public class School {
    private String name;
    private boolean isPublic = true; // Defaults to true
    private String address;

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<String> courses = new ArrayList<>();

    School(String name, boolean isPublic, String address) {
        this.name = name;
        this.isPublic = isPublic;
        this.address = address;
    }

    public void printInfo() {
        System.out.println("School Name: " + name);
        System.out.println("This school is " + (isPublic ? "" : "not") + "public");
        System.out.println("Address: " + address + "\n");
        System.out.println("\u001b[31m" + "Teachers" + "\u001b[0m");
        listTeachers();
        System.out.print("\n");
        System.out.println("\u001b[31m" + "Students" + "\u001b[0m");
        listStudents();
    }

    private void listStudents() {
        for(Student student : students) student.printInfo();
    }

    private void listTeachers() {
        for(Teacher teacher : teachers) teacher.printInfo();
    }

    // Add and Delete Students or Teachers

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
    }

    // Set Original Students, Teachers and Courses

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
