package lab_4;

import java.util.Objects;

public class Teacher {
    private final int teacherId;
    private final String name;

    private Teacher(TeacherBuilder builder) {
        this.teacherId = builder.teacherId;
        this.name = builder.name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId && name.equals(teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, name);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                '}';
    }

    public static class TeacherBuilder {
        private int teacherId;
        private String name;

        public TeacherBuilder setTeacherId(int teacherId) {
            this.teacherId = teacherId;
            return this;
        }

        public TeacherBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Teacher build() {
            validate();
            return new Teacher(this);
        }

        private void validate() {
            if (teacherId < 0) {
                throw new IllegalArgumentException("Teacher ID must be a non-negative value.");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Teacher name cannot be empty or null.");
            }
        }
    }
}