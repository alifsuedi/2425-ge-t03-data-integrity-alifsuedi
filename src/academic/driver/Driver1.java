package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

/**
 * @author 12S23025-Alif Aflah Suedi
 * @author 12S23039-Prisca R. Manurung
 */
public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }
            String[] segments = input.split("#");
            if (segments.length > 0) {
                String command = segments[0];
                switch (command) {
                    case "course-add":
                        if (segments.length == 5) {
                            String code = segments[1];
                            String name = segments[2];
                            int credits = Integer.parseInt(segments[3]);
                            String grade = segments[4];
                            courses.add(new Course(code, name, credits, grade));
                        }
                        break;
                    case "student-add":
                        if (segments.length == 5) {
                            String id = segments[1];
                            String name = segments[2];
                            int year = Integer.parseInt(segments[3]);
                            String major = segments[4];
                            students.add(new Student(id, name, year, major));
                        }
                        break;
                    case "enrollment-add":
                        if (segments.length == 5) {
                            String courseCode = segments[1];
                            String studentId = segments[2];
                            String academicYear = segments[3];
                            String semester = segments[4];
                            enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
                        }
                        break;
                }
            }
        }

        // Sorting students by ID to fix t03-01-01 issue
        students.sort(Comparator.comparing(Student::getId));
        
        // Sorting enrollments by course code and then student ID
        enrollments.sort(Comparator.comparing(Enrollment::getCourseCode)
                .thenComparing(Enrollment::getStudentId));
        
        // Sorting courses by code
        courses.sort(Comparator.comparing(Course::getCode));

        for (Course course : courses) {
            System.out.println(course.getCode() + "|" + course.getName() + "|" + course.getCredits() + "|" + course.getGrade());
        }

        for (Student student : students) {
            System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getMajor());
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.getCourseCode() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|None");
        }

        scanner.close();
    }
}
