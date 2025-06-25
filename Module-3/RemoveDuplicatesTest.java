// Name: Nilam Abdul-Haqq
// Date: 06/24/2025
// Assignment: Module 3 Programming Assignment
// Purpose: Generate 50 random integers, store them in an ArrayList, remove duplicates using a generic method, and display results.

import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

public class RemoveDuplicatesTest {

    /**
     * Static generic method to remove duplicates from the ArrayList.
     * @param list the input ArrayList with possible duplicates.
     * @return A new ArrayList containing unique elements.
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return new ArrayList<>(new  HashSet<>(list));
    }
    public static void main(String[] args) {
        // Create an ArrayList to hold 50 random integers between 1 and 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random randomGenerator =  new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(randomGenerator.nextInt(20) +1);
        }

        // Display the original list
        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // Call removeDuplicates method
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Display the list without duplicates
        System.out.println("\nList After Removing Duplicates: ");
        System.out.println(uniqueList);
    }
}
