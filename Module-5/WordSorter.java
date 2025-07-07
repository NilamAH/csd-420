// Name: Nilam Abdul-Haqq
// Date: 07/01/2025
// Assignment: Non-Duplicate Word Sort
// Purpose: Read a file and display unique words in ascending and descending order.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collections;

public class WordSorter {

    public static void main(String[] args) {
        // TreeSet to store non-duplicate words in sorter order
        TreeSet<String> wordSet = new TreeSet<>();

        try {
            File wordFile = new File("collection_of_words/collection_of_words.txt");
            Scanner scanner = new Scanner(wordFile);

            // Read words (assumes whitespace-seperated)
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    wordSet.add(word);
                }
            }

            scanner.close();

            // Ascending order (natural order)
            System.out.println("Words in Ascending Order:");
            for (String word : wordSet) {
                System.out.print(word = " ");
            }

            System.out.println("\n\nWords in Descending Order:");
            for (String word : wordSet.descendingSet()) {
                System.out.print(word = " ");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: File 'collection_of_words.txt' not found.");
        }
    }
}
