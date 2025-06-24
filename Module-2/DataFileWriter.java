import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class DataFileWriter {

    public static void main(String[] args) {
        String fileName = "NilamDataFile.dat";
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.print("Integers: ");
            for (int i = 0; i < 5; i++) {
                int num = random.nextInt(100); // Random integer 0-99
                writer.print(num + " ");
            }
            writer.println();

            writer.print("Doubles: ");
            for (int i = 0; i < 5; i++) {
                double d =  random.nextDouble() * 100; // Random double 0-100\
                writer.printf("%.2f", d);
            }
            writer.println();
            writer.print("---"); // Separator

            System.out.println("Data written to file successfully.");

        } catch (IOException e) {
            System.out.println("Enter writing to file: " + e.getMessage());
        }
    }
}
