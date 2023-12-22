package lab_3;

import lab_1.Student;
import lab_1.Teacher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SchoolService {

    public static void sortTeachersByName(List<Teacher> teachers) {
        teachers.sort(Comparator.comparing(Teacher::getName));
    }


    public static List<Student> getStudentsByNameWithoutStream(List<Student> students, String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public static List<Student> getStudentsByName(List<Student> students, String name) {
        return students.stream()
                .filter(student -> student.getName().equals(name))
                .collect(Collectors.toList());
    }


    public static List<String> getUniqueTeacherNames(List<Teacher> teachers) {
        return teachers.stream()
                .map(Teacher::getName)
                .distinct()
                .collect(Collectors.toList());
    }


    public static double calculateAverageTeacherId(List<Teacher> teachers) {
        return teachers.stream()
                .mapToDouble(Teacher::getTeacherId)
                .average()
                .orElse(0.0);
    }
}
