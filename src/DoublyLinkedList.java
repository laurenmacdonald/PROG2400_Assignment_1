/**
 *
 * @param <T> using generic types to allow the lists to work with any data type.
 *           <br>
 *           Doubly linked list class that sequentially links records (nodes).
 *           Contains references to previous (tail) and next (head) nodes in the sequence. Works with a Node<T> class.
 */
public class DoublyLinkedList<T> {
    Node<T> head = null; // will point to first node
    Node<T> tail = null; // will point to last node

    /**
     *
     * @param <T> takes any data type.
     *           <br>
     *           Node class - has next and previous objects for pointer reference, and data that is stored.
     */
    static class Node<T> {
        T data;
        Node<T> next = null;
        Node<T> previous = null;
        // constructor
        Node(T data){
            this.data = data;
        }
    }

    /**
     *
     * @return true if head is null, false if head is not null
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Print the list of nodes.
     */
    public void printNodes(){
        // If the list is empty (nothing at head) then do not continue
        if(!isEmpty()){
            // Create current pointer to point at head to print the list in forward direction
            Node<T> current = head;
            // Check the nodes to see if the pointer is equal to head (at start) or null (empty)
            // If more than 1 node, will run the while loop, printing the data at pointer and moving the pointer to the next value.
            while(current.next != head && current.next != null){
                System.out.println(current.data);
                current = current.next;
            }
            // If there is only 1 node, will run this line
            System.out.println(current.data);
        }
    }

    /**
     *
     * @param value value to be added to the list
     * <br>
     *        Adds new node containing value to end of list. Assigns bidirectional characteristic to the nodes (doubly linked).
     */
    public void append(T value){
        // Create new node with data = value
        Node<T> newNode = new Node<>(value);
        // If list is empty, this will be the only node in the list (node is both head and tail)
        // When more values are added, the head will stay the same and the tail will be adjusted.
        if(tail == null) {
            head = tail = newNode;
        } else {
            // Next pointer of the tail points at the new node.
            tail.next = newNode;
            // Previous pointer of the new node to point at the tail - for connection in both directions
            newNode.previous = tail;
            // Assign the tail to point at the new node - makes the new node the last in the list.
            tail = newNode;
        }
    }

    /**
     *
     * @param value value to be added to the list
     *              <br>
     *              Adds new node containing value to start of list. Assigns bidirectional characteristic to the nodes (doubly linked).
     */
    public void prepend(T value){
        // Create new node with data = value
        Node<T> newNode = new Node<>(value);
        // If list empty, this will be the only node in the list (the node is both head and tail)
        // When more values are added, the tail will stay the same and only the head will be adjusted
        if(head == null){
            head = tail = newNode;
        } else {
            // Next pointer of the new node to point at the current head of the list. Makes connection between previous first node.
            newNode.next = head;
            // Previous pointer of head to point back to new node - for connection in both directions.
            head.previous = newNode;
            // Assign the head to point to the new node - makes the new node the first in list.
            head = newNode;
        }
    }

    /**
     *
     * @return total number of nodes in the list
     */
    public int size(){
        int counter = 0; // initialize at 0, if list empty will return 0
        if (!isEmpty()) {
            // Create a current node, pointing at the head
            Node<T> current = head;
            counter++; // start the counter at 1 (head)
            // Loop through and update the counter.
            while (current.next != head && current.next != null) {
                counter++;
                current = current.next;
            }
        }
        return counter;
    }

    /**
     *
     * @return the value of the first node in the list
     */
    public T head(){
        // If the list is empty, return null, otherwise return the data stored in the head.
        if(isEmpty()){
            return null;
        } else {
            return head.data;
        }
    }

    /**
     *
     * @return the last node in the list
     */
    public T tail(){
        // If list is empty, return null, otherwise return the data stored in the tail.
        if(isEmpty()){
            return null;
        } else {
            return tail.data;
        }
    }
    /**
     * Removes the last element from the list
     */
    public void pop(){
        // Check to see if list is empty
        if(!isEmpty()){
            // If there is only one element, make the head the tail and make it null (no elements in list)
            if(head == tail) {
                head = tail = null;
                return;
            }
            // If more than one element, update the tail to the second to last index and set the next to null
            Node<T> secondLast = head;
            while(secondLast.next != tail){
                secondLast = secondLast.next;
            }
            // Remove the last node by setting the next of second last to null
            secondLast.next = null;
            // Update the tail to the new last node
            tail = secondLast;
        }
    }

    /**
     *
     * @param index index to search
     * @return node value stored at the index provided
     */
    public T at(int index){
        // Ensure index valid int and greater or equal to size of list
        if(index < 0 || index >= size()){
            return null; // Index is invalid
        }
        // Pointer node starting pointed at the head
        Node<T> pointer = head;
        // Counter starting at 0.
        int counter = 0;
        // Loop through list until the counter is equal to the index provided and then return the data at the index
        while(pointer != null){
            if(counter == index){
                return pointer.data;
            }
            // Increment counter and point to the next node.
            counter++;
            pointer = pointer.next;
        }
        return null;
    }



    /**
     *
     * @param value value to search for
     * @return true if the passed in value is in the list, false if not
     */
    public boolean contains(T value){
        if(!isEmpty()){
            // Set pointer node to head
            Node<T> pointer = head;
            // Loop through until pointer is null, return false if it gets to this point (no match)
            while(pointer != null){
                // If the data of the pointer equals the value supplied, return true
                if(pointer.data == value){
                    return true;
                }
                pointer = pointer.next;
            }
            return false;
        }
        return false;
    }

    /**
     *
     * @param value value to search
     * @return the index of the node containing the value or nil if not found
     */
    public Integer find(T value){
        if(!isEmpty()){
            // Set pointer to head
            Node<T> pointer = head;
            // Start index at 0
            int index = 0;
            // Loop through until pointer is null (no match)
            while(pointer != null){
                // If the pointer data is equal to the value supplied, return the index value
                if(pointer.data == value){
                    return index;
                }
                // Increment the index value per loop and point to the next node in the list
                index++;
                pointer = pointer.next;
            }
            return null;
        }
        return null;
    }
}
