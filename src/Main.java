import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("UNDEFINED TYPE:");
        System.out.println("=================================");

        // Using data type of Object to allow for any data type to be supplied to list.
        DoublyLinkedList<Object> undefinedList = new DoublyLinkedList<>();

        // Append elements
        System.out.println("Append: cat, 12");
        undefinedList.append("cat");
        undefinedList.append(12);

        // Print current list
        printSection("Current list:");
        undefinedList.printNodes();
        printSeparator();

        // Prepend elements
        System.out.println("Prepend: dog, 45");
        undefinedList.prepend("dog");
        undefinedList.prepend(45);

        // Print current list
        printSection("Current list:");
        undefinedList.printNodes();
        printSeparator();

        // List size, head, tail, and element at index
        System.out.println("List size: " + undefinedList.size());
        System.out.println("Head: " + undefinedList.head());
        System.out.println("Tail: " + undefinedList.tail());
        System.out.println("At index 2: " + undefinedList.at(2));
        printSeparator();

        // Remove last element
        printSection("Before removing last element:");
        undefinedList.printNodes();
        undefinedList.pop();
        printSeparator();

        // Print list after removal
        printSection("After removing last element:");
        undefinedList.printNodes();
        printSeparator();

        // Check element presence and find element index
        System.out.println("Will return true if cat is in the list: " + undefinedList.contains("cat"));
        System.out.println("Will return false if bunny is not in the list: " + undefinedList.contains("bunny"));
        System.out.println("Returns the index of the node containing 45: " + undefinedList.find(45));
    }

    // Helper method to print section separator
    private static void printSeparator() {
        System.out.println("=================================");
    }

    // Helper method to print section title
    private static void printSection(String title) {
        System.out.println(title);
    }
}

