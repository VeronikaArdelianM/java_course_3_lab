package lab_2;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lab_1.Student;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SerializeToXml implements lab_2.Serialize<Student> {

    @Override
    public void writeToFile(List<Student> students, String fileName) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File(fileName), students);
    }

    @Override
    public List<Student> readFromFile(String fileName) throws IOException {
        XmlMapper mapper = new XmlMapper();
        return Arrays.asList(mapper.readValue(new File(fileName), Student[].class));
    }
}
