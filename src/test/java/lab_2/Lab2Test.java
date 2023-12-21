package lab_2;

import lab_1.Student;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Lab2Test {

    @Test(dataProvider = "serializeToJSONTest")
    public void serializeProviderTest(String fileName, Serialize<Student> serializer, List<Student> objs) throws IOException, ClassNotFoundException {
        serializer.writeToFile(objs, fileName);
        List<Student> res = serializer.readFromFile(fileName);
        assertEquals(res, objs);
    }

    @DataProvider
    public Object[][] serializeToJSONTest() {
        List<Student> list = Arrays.asList(
                new Student.StudentBuilder().setStudentId(1).setName("Alice Johnson").build(),
                new Student.StudentBuilder().setStudentId(2).setName("Bob Williams").build()
        );
        return new Object[][]
                {
                        {"test_json.json", new SerializeToJSON(), list},
                        {"test_xml.xml", new SerializeToXml(), list},
                        {"test_txt.txt", new SerializeToTxt(), list}
                };
    }
}
