/*
LinkNode - a class that represents one element of the SinglyLinkedlist ADT
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADTs using the Binary Search 
Tree on Currency and Dollar classes
*/
public class LinkNode {
    private Currency data; // Field var represents the data stored by this node
    private LinkNode next; // Field var represents next node

    public LinkNode(Currency data) {
        this.data = data;
    }

    public LinkNode(Currency data, LinkNode next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Getter methods to return data and next node respectively
     * pre: none
     * post: used in SinglyLinkedList, Stack and Queue to get Currency object at specific nodes
     * return: data and next
     */
    public Currency getData() {
        return data;
    }
    public LinkNode getNext() {
        return next;
    }

    /**
     * Setter methods to set data and next to be the respective parameters
     * pre: data parameter of Currency type and next parameter of LinkNode type
     * post: data nad next have new values respectively
     * return: none
     */
    public void setData(Currency data) {
        this.data = data;
    }
    public void setNext(LinkNode next) {
        this.next = next;
    }
}