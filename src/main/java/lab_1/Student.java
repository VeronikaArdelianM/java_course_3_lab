package lab_1;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private int studentId;
    private String name;
    private LocalDate date;

    public Student() {
    }

    private Student(StudentBuilder builder) {
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.date = builder.date;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return studentId == student.studentId && name.equals(student.name) && Objects.equals(date, student.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, date);
    }

    public static class StudentBuilder {
        private int studentId;
        private String name;
        private LocalDate date;

        public StudentBuilder setStudentId(int studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
