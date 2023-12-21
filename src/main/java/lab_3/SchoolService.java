package lab_3;

import lab_1.Student;
import lab_1.Teacher;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SchoolService {

    // Сервісний метод для сортування вчителів за іменем (Comparator)
    public static void sortTeachersByName(List<Teacher> teachers) {
        teachers.sort(Comparator.comparing(Teacher::getName));
    }

    // Сервісний метод для отримання студентів за вказаним іменем
    public static List<Student> getStudentsByName(List<Student> students, String name) {
        return students.stream()
                .filter(student -> student.getName().equals(name))
                .collect(Collectors.toList());
    }

    // Сервісний метод для отримання унікальних імен вчителів
    public static List<String> getUniqueTeacherNames(List<Teacher> teachers) {
        return teachers.stream()
                .map(Teacher::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    // Сервісний метод для обчислення середнього ID вчителів
    public static double calculateAverageTeacherId(List<Teacher> teachers) {
        return teachers.stream()
                .mapToDouble(Teacher::getTeacherId)
                .average()
                .orElse(0.0);
    }
}
