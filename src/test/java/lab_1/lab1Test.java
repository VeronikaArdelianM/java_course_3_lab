package lab_1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class lab1Test {
    @Test(dataProvider = "equalSchoolObjects")
    public void equalSchoolObjectsTest(School obj1, School obj2, boolean res) {
        assertEquals(Objects.equals(obj1, obj2), res);
    }

    @DataProvider
    public Object[][] equalSchoolObjects() {
        Teacher teacher1 = new Teacher.TeacherBuilder().setTeacherId(1).setName("John Doe").build();
        Teacher teacher2 = new Teacher.TeacherBuilder().setTeacherId(2).setName("Jane Smith").build();

        Student student1 = new Student.StudentBuilder().setStudentId(1).setName("Alice Johnson").build();
        Student student2 = new Student.StudentBuilder().setStudentId(2).setName("Bob Williams").build();

        School school1 = new School.SchoolBuilder().setSchoolId(1).addTeacher(teacher1).addStudent(student1).build();
        School school2 = new School.SchoolBuilder().setSchoolId(2).addTeacher(teacher2).addStudent(student2).build();

        return new Object[][]{{school1, school1, true}, {school1, school2, false}};
    }

    @Test(dataProvider = "hashEqualSchoolObjects")
    public void hashEqualSchoolObjectsTest(School obj1, School obj2) {
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @DataProvider
    public Object[][] hashEqualSchoolObjects() {
        Teacher.TeacherBuilder teacherBuilder = new Teacher.TeacherBuilder();
        teacherBuilder.setTeacherId(1);
        teacherBuilder.setName("John Doe");

        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
        studentBuilder.setStudentId(1);
        studentBuilder.setName("Alice Johnson");

        School.SchoolBuilder schoolBuilder1 = new School.SchoolBuilder();
        schoolBuilder1.setSchoolId(1).addTeacher(teacherBuilder.build()).addStudent(studentBuilder.build());

        School.SchoolBuilder schoolBuilder2 = new School.SchoolBuilder();
        schoolBuilder2.setSchoolId(1).addTeacher(teacherBuilder.build()).addStudent(studentBuilder.build());

        return new Object[][]{{schoolBuilder1.build(), schoolBuilder2.build()}};
    }
}
