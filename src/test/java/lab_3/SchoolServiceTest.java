package lab_3;

import lab_1.Student;
import lab_1.Teacher;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SchoolServiceTest {

    @Test
    public void testSortTeachersByName() {
        List<Teacher> teachers = Arrays.asList(
                new Teacher.TeacherBuilder().setTeacherId(1).setName("John").build(),
                new Teacher.TeacherBuilder().setTeacherId(2).setName("Alice").build(),
                new Teacher.TeacherBuilder().setTeacherId(3).setName("Bob").build()
        );

        SchoolService.sortTeachersByName(teachers);

        List<String> sortedNames = teachers.stream()
                .map(Teacher::getName)
                .collect(Collectors.toList());

        List<String> expectedNames = Arrays.asList("Alice", "Bob", "John");

        Assert.assertEquals(sortedNames, expectedNames);
    }

    @Test
    public void testGetStudentsByName() {
        List<Student> students = Arrays.asList(
                new Student.StudentBuilder().setStudentId(1).setName("Alice").build(),
                new Student.StudentBuilder().setStudentId(2).setName("Bob").build(),
                new Student.StudentBuilder().setStudentId(3).setName("Alice").build()
        );

        String targetName = "Alice";

        List<Student> result = SchoolService.getStudentsByName(students, targetName);

        List<Student> expectedStudents = Arrays.asList(
                new Student.StudentBuilder().setStudentId(1).setName("Alice").build(),
                new Student.StudentBuilder().setStudentId(3).setName("Alice").build()
        );

        Assert.assertEquals(result, expectedStudents);
    }

    @Test
    public void testGetUniqueTeacherNames() {
        List<Teacher> teachers = Arrays.asList(
                new Teacher.TeacherBuilder().setTeacherId(1).setName("John").build(),
                new Teacher.TeacherBuilder().setTeacherId(2).setName("Alice").build(),
                new Teacher.TeacherBuilder().setTeacherId(3).setName("John").build()
        );

        List<String> result = SchoolService.getUniqueTeacherNames(teachers);

        List<String> expectedNames = Arrays.asList("John", "Alice");

        Assert.assertEquals(result, expectedNames);
    }

    @Test
    public void testCalculateAverageTeacherId() {
        List<Teacher> teachers = Arrays.asList(
                new Teacher.TeacherBuilder().setTeacherId(1).setName("John").build(),
                new Teacher.TeacherBuilder().setTeacherId(2).setName("Alice").build(),
                new Teacher.TeacherBuilder().setTeacherId(3).setName("Bob").build()
        );

        double result = SchoolService.calculateAverageTeacherId(teachers);

        double expectedAverage = (1 + 2 + 3) / 3.0;

        Assert.assertEquals(result, expectedAverage);
    }
}
