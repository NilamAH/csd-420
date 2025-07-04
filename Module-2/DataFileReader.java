import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataFileReader {

    public static void main (String[] args) {
        String fileName = "NilamDataFile.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
