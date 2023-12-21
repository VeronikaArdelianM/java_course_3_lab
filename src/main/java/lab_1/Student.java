package lab_1;

import java.util.Objects;

public class Student {
    private int studentId;
    private String name;

    public Student() {
        // Пустий конструктор за замовчуванням для Jackson
    }

    public Student(StudentBuilder builder) {
        this.studentId = builder.studentId;
        this.name = builder.name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return studentId == student.studentId && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name);
    }

    public static class StudentBuilder {
        private int studentId;
        private String name;

        public StudentBuilder setStudentId(int studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
