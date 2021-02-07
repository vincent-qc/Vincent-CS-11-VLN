import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Create School
        School school = new School("Churchill", true, "Vancouver");

        // Initialize Arrays of Subjects, Students and Teachers
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

        // Set the School's courses as the subjects (Array is turned into arraylist)
        school.setCourses(new ArrayList<>(Arrays.asList(subjects)));

        // Create a random class for later
        Random r = new Random();

        // Iterates through students and ads it to the school
        // First and Last name are parsed by splitting it at the [space]
        // Assigns student random grade from 1 - 12
        for(String studentName : studentNames) {
            school.addStudent(new Student(
                    studentName.split(" ")[0],
                    studentName.split(" ")[1],
                    r.nextInt(12) + 1
            ));
        }

        // Same goes for the teachers
        for(String teacherName : teacherNames) {
            school.addTeacher(new Teacher(
                    teacherName.split(" ")[0],
                    teacherName.split(" ")[1],
                    subjects[r.nextInt(8)]
            ));
        }

        // Original
        school.printInfo();

        // Remove students + teachers
        school.removeStudent(school.getStudents().get(r.nextInt(school.getStudents().size())));
        school.removeStudent(school.getStudents().get(r.nextInt(school.getStudents().size())));
        school.removeTeacher(school.getTeachers().get(r.nextInt(school.getTeachers().size())));

        System.out.println("Removed 2 Students and 1 Teacher");

        // After
        school.printInfo();
    }
}
