/*
Queue - a class that extends SinglyLinkedlist, represents a FIFO ADT
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADT's using the above three mentioned 
ADT's, Lists, Stacks, and Queues, on Currency and Dollar classes
*/
public class Queue extends SinglyLinkedList{

    public Queue() {
        super();
    }

    /**
     * Adds new Currency object to the queue
     * Pre: currencyToEnqueue is new Currency object
     * Post: queue has new Currency object
     * Return: none
     */
    public void enqueue(Currency currencyToEnqueue) {
        addCurrency(currencyToEnqueue, countCurrency());
    }

    /**
     * Removes first Currency object in queue
     * Pre: none
     * Post: first node removed from queue
     * Return: value of Currency object that was just removed
     */
    public Currency dequeue() {
        return removeCurrency(0);
    }

    /**
     * Accesses data in first node of queue
     * Pre: none
     * Post: none
     * Return: value of Currency object at front of queue
     */
    public Currency peekFront() {
        return getStart().getData();
    }

    /**
     * Accesses data in last node of queue
     * Pre: none
     * Post: none
     * Return: value of Currency object at end of queue 
     */
    public Currency peekRear() {
        return getEnd().getData();
    }

    /**
     * prints all the Currency objects in queue
     * Pre: none
     * Post: all values of Currency objects in queue printed
     * Return: string of all values of Currency objects in queue
     */
    public String printQueue() {
        return printList();
    }
}
