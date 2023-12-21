package lab_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab_1.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializeToJSON implements lab_2.Serialize<Student> {

    @Override
    public void writeToFile(List<Student> students, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), students);
    }

    @Override
    public List<Student> readFromFile(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), new TypeReference<List<Student>>() {});
    }
}
