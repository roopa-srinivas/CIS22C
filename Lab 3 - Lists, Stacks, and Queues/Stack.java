/*
Stack - a class that extends SinglyLinkedlist, represents a LIFO ADT
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADT's using the above three mentioned 
ADT's, Lists, Stacks, and Queues, on Currency and Dollar classes
*/
public class Stack extends SinglyLinkedList {

    public Stack () {
        super();
    }

    /**
     * Adds new Currency object to the stack
     * Pre: currencyToPush is new Currency object
     * Post: stack has new Currency object
     * Return: none
     */
    public void push(Currency currencyToPush) {
        addCurrency(currencyToPush, 0);
    }

    /**
     * Removes first Currency object in stack
     * Pre: none
     * Post: first node removed from stack
     * Return: value of Currency object that was just removed
     */
    public Currency pop() {
        LinkNode nodeToRemove = getStart();
        return removeCurrency(nodeToRemove.getData());
    }

    /**
     * Accesses data in first node of stack
     * Pre: none
     * Post: none
     * Return: value of Currency object at top of stack 
     */
    public Currency peek() {
        return getStart().getData();
    }

    /**
     * prints all the Currency objects in stack
     * Pre: none
     * Post: all values of Currency objects in stack printed
     * Return: string of all values of Currency objects in stack
     */
    public String printStack() {
        return printList();
    }
}
