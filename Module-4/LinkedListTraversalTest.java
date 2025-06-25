// Name: Nilam Abdul-Haqq
// Date: 06/24/2025
// Assignment: LinkedList Traversal Performance Test
// Purpose: Compare traversal time of LinkedList using Iterator vs. get(index)

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraversalTest {

    // Fills LinkedList with integers 0 to (size - 1)
    private static LinkedList<Integer> generateList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    // Traverses list using Iterator and returns elapsed time in ms
    private static long traverseWithIterator(LinkedList<Integer> list) {
        long start = System.nanoTime();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return (System.nanoTime() - start) / 1_000_000;
    }

    // Traverses list using get(index) and returns elapsed time in ms
    private static long traverseWithGet(LinkedList<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        return (System.nanoTime() - start) / 1_000_000;
    }

    // Test method for both list sizes
    private static void runTest(int size) {
        System.out.println("\nTesting LinkedList traversal with " + size + " elements.");

        LinkedList<Integer> list = generateList(size);

        long timeIterator = traverseWithIterator(list);
        long timeGet = traverseWithGet(list);

        System.out.println("Iterator traversal time: " + timeIterator + " ms");
        System.out.println("get(index) traversal time: " + timeGet + " ms");
    }

    public static void main(String[] args) {
        runTest(50_000);
        runTest(500_000);
    }
}
