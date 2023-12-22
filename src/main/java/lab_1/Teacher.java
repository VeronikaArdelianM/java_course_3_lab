package lab_1;

import java.util.Objects;

public class Teacher {
    private final int teacherId;
    private final String name;
    private final String position;

    private Teacher(TeacherBuilder builder) {
        this.teacherId = builder.teacherId;
        this.name = builder.name;
        this.position = builder.position;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId && name.equals(teacher.name) && position.equals(teacher.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, name, position);
    }

    public static class TeacherBuilder {
        private int teacherId;
        private String name;
        private String position;

        public TeacherBuilder setTeacherId(int teacherId) {
            this.teacherId = teacherId;
            return this;
        }

        public TeacherBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public TeacherBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }
    }
}
