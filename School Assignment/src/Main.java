import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        School school = new School("Churchill", true, "Vancouver");

        String[] subjects = {
                "Math",
                "English",
                "Science",
                "Socials",
                "French",
                "Arts",
                "Physical Education",
                "Computer Science"
        };

        String[] studentNames = {
                "Vincent Qi",
                "John Doe",
                "James Miller",
                "Joseph Chan",
                "Stephen Smith",
                "Sabrina Anders",
                "Paul McCarthy",
                "Lily Sanders",
                "Jack Davis",
                "Sophia Oliver"
        };

        String[] teacherNames = {
                "Daniel MacDonald",
                "Ella Anderson",
                "Peter Mann"
        };

        school.setCourses(new ArrayList<>(Arrays.asList(subjects)));

        Random r = new Random();

        for(String studentName : studentNames) {
            school.addStudent(new Student(
                    studentName.split(" ")[0],
                    studentName.split(" ")[1],
                    r.nextInt(12) + 1
            ));
        }

        for(String teacherName : teacherNames) {
            school.addTeacher(new Teacher(
                    teacherName.split(" ")[0],
                    teacherName.split(" ")[1],
                    subjects[r.nextInt(8)]
            ));
        }

        school.printInfo();

        school.removeStudent(school.getStudents().get(r.nextInt(school.getStudents().size())));
        school.removeStudent(school.getStudents().get(r.nextInt(school.getStudents().size())));
        school.removeTeacher(school.getTeachers().get(r.nextInt(school.getTeachers().size())));

        System.out.println("Removed 2 Students and 1 Teacher");

        school.printInfo();

    }
}
