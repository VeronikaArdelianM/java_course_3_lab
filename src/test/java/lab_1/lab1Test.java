package lab_1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class lab1Test {

    @Test(dataProvider = "equalTeacherObjects")
    public void equalTeacherObjectsTest(Teacher obj1, Teacher obj2, boolean res) {
        assertEquals(Objects.equals(obj1, obj2), res);
    }

    @DataProvider
    public Object[][] equalTeacherObjects() {
        Teacher teacher1 = new Teacher.TeacherBuilder().setTeacherId(1).setName("John Doe").setPosition("Math Teacher").build();
        Teacher teacher2 = new Teacher.TeacherBuilder().setTeacherId(2).setName("Jane Smith").setPosition("Science Teacher").build();

        return new Object[][]{{teacher1, teacher1, true}, {teacher1, teacher2, false}};
    }

    @Test(dataProvider = "hashEqualTeacherObjects")
    public void hashEqualTeacherObjectsTest(Teacher obj1, Teacher obj2) {
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @DataProvider
    public Object[][] hashEqualTeacherObjects() {
        Teacher.TeacherBuilder teacherBuilder = new Teacher.TeacherBuilder();
        teacherBuilder.setTeacherId(1);
        teacherBuilder.setName("John Doe");
        teacherBuilder.setPosition("Math Teacher");

        return new Object[][]{{teacherBuilder.build(), teacherBuilder.build()}};
    }

    @Test(dataProvider = "equalStudentObjects")
    public void equalStudentObjectsTest(Student obj1, Student obj2, boolean res) {
        assertEquals(Objects.equals(obj1, obj2), res);
    }

    @DataProvider
    public Object[][] equalStudentObjects() {
        Student student1 = new Student.StudentBuilder().setStudentId(1).setName("Alice Johnson").setDate(LocalDate.of(2000, 5, 15)).build();
        Student student2 = new Student.StudentBuilder().setStudentId(2).setName("Bob Williams").setDate(LocalDate.of(1999, 10, 20)).build();

        return new Object[][]{{student1, student1, true}, {student1, student2, false}};
    }

    @Test(dataProvider = "hashEqualStudentObjects")
    public void hashEqualStudentObjectsTest(Student obj1, Student obj2) {
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @DataProvider
    public Object[][] hashEqualStudentObjects() {
        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
        studentBuilder.setStudentId(1);
        studentBuilder.setName("Alice Johnson");
        studentBuilder.setDate(LocalDate.of(2000, 5, 15));

        return new Object[][]{{studentBuilder.build(), studentBuilder.build()}};
    }
}
