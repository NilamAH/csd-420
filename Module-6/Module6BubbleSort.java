// Name: Nilam Abdul-Haqq
// Date: 07/10/2025
// Assignment: Module 6 Programming Assignment
// Purpose: Implement generic bubble sort using Comparable and Comparator interfaces

import java.util.Comparator;

public class Module6BubbleSort {

    /**
     * Bubble sort using Comparable interface
     */

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        for (int i= 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    /**
     * Bubble sort using Comparator interface
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i= 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
