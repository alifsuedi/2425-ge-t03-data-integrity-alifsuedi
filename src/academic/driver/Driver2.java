package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

/**
 * @author 12S23025-Alif Aflah Suedi
 * @author 12S23039-Prisca R. Manurung
 */
public class Driver2 {
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
                            if (courses.stream().noneMatch(c -> c.getCode().equals(code))) {
                                String name = segments[2];
                                int credits = Integer.parseInt(segments[3]);
                                String grade = segments[4];
                                courses.add(new Course(code, name, credits, grade));
                            }
                        }
                        break;
                    case "student-add":
                        if (segments.length == 5) {
                            String id = segments[1];
                            if (students.stream().noneMatch(s -> s.getId().equals(id))) {
                                String name = segments[2];
                                int year = Integer.parseInt(segments[3]);
                                String major = segments[4];
                                students.add(new Student(id, name, year, major));
                            }
                        }
                        break;
                    case "enrollment-add":
                        if (segments.length == 5) {
                            String courseCode = segments[1];
                            String studentId = segments[2];
                            String academicYear = segments[3];
                            String semester = segments[4];
                            if (enrollments.stream().noneMatch(e -> e.getCourseCode().equals(courseCode) && e.getStudentId().equals(studentId) && e.getAcademicYear().equals(academicYear) && e.getSemester().equals(semester))) {
                                enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
                            }
                        }
                        break;
                }
            }
        }

        // Sorting lists
        courses.sort(Comparator.comparing(Course::getCode));
        students.sort(Comparator.comparing(Student::getId));
        enrollments.sort(Comparator.comparing(Enrollment::getCourseCode).thenComparing(Enrollment::getStudentId));

        // Print sorted lists
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