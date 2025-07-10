// Test Driver for Module 6 Bubble Sort Assignment

import java.util.Arrays;
import java.util.Comparator;

public class TestBubbleSort {

    static class Student {
        String name;
        int id;

        Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return name + " (" + id + ")";
        }
    }

    public static void main(String[] args) {
        //Test 1: Integer using Comparable
        Integer[] intArray = {5,2, 9, 1, 3};
        Module6BubbleSort.bubbleSort(intArray);
        System.out.println("Sorted Integers: " + Arrays.toString(intArray));

        // Test 2: String using Comparable
        String[] strArray = {"pear", "apple", "banana", "orange"};
        Module6BubbleSort.bubbleSort(strArray);
        System.out.println("Sorted Strings: " + Arrays.toString(strArray));

        // Test 3: Custom class using Comparator
        Student[] students = {
                new Student("Jack", 105),
                new Student("Danny", 110),
                new Student("Samantha", 102)
        };

        Comparator<Student> idComparator = Comparator.comparingInt(s -> s.id);
        Module6BubbleSort.bubbleSort(students, idComparator);

        System.out.println("Sorted Students by ID: ");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
