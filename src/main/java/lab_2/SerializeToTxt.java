package lab_2;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab_1.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SerializeToTxt implements lab_2.Serialize<Student> {

    private final ObjectMapper mapper;

    public SerializeToTxt() {
        mapper = new ObjectMapper();
    }

    @Override
    public void writeToFile(List<Student> students, String fileName) throws IOException {
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
        List<String> lines = Arrays.asList(jsonString.split("\n"));
        Files.write(Paths.get(fileName), lines);
    }

    @Override
    public List<Student> readFromFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        Student[] studentsArray = mapper.readValue(content, Student[].class);
        return Arrays.asList(studentsArray);
    }
}
