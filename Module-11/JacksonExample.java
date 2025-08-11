import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * This is an example found in FasterXML. (2023). Jackson-databind User Guide. Retrieved from https://github.com/FasterXML/jackson-databind.
 */

class Person {
    public String name;
    public int age;
}

public class JacksonExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // JSON to Java object
        String json = "{\"name\":\"Alice\",\"age\":30}";
        Person person = mapper.readValue(json, Person.class);
        System.out.println("Name: " + person.name + ", Age: " + person.age);

        // Java object to JSON
        person.age = 31;
        String updatedJson = mapper.writeValueAsString(person);
        System.out.println("Updated JSON: " + updatedJson);
    }
}

