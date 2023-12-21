package lab_4;

import java.util.Objects;

public class Student {
    private int studentId;
    private String name;

    public Student() {
        // Default constructor for Jackson
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

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
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
            validate();
            return new Student(this);
        }

        private void validate() {
            if (studentId < 0) {
                throw new IllegalArgumentException("Student ID must be a non-negative value.");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Student name cannot be empty or null.");
            }
        }
    }
}