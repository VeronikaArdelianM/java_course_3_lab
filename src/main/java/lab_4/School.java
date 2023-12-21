package lab_4;

import lab_1.Student;
import lab_1.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class School {
    private final int schoolId;
    private final List<Teacher> teachers;
    private final List<Student> students;

    private School(SchoolBuilder builder) {
        this.schoolId = builder.schoolId;
        this.teachers = new ArrayList<>(builder.teachers);
        this.students = new ArrayList<>(builder.students);
    }

    public int getSchoolId() {
        return schoolId;
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;
        School school = (School) o;
        return schoolId == school.schoolId && teachers.equals(school.teachers) && students.equals(school.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolId, teachers, students);
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", teachers=" + teachers +
                ", students=" + students +
                '}';
    }

    public static class SchoolBuilder {
        private int schoolId;
        private List<Teacher> teachers = new ArrayList<>();
        private List<Student> students = new ArrayList<>();

        public SchoolBuilder setSchoolId(int schoolId) {
            this.schoolId = schoolId;
            return this;
        }

        public SchoolBuilder addTeacher(Teacher teacher) {
            this.teachers.add(teacher);
            return this;
        }

        public SchoolBuilder addStudent(Student student) {
            this.students.add(student);
            return this;
        }

        public School build() {
            validate();
            return new School(this);
        }

        private void validate() {
            if (schoolId < 0) {
                throw new IllegalArgumentException("School ID must be a non-negative value.");
            }
        }
    }
}